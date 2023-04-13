package com.chenyu.meta.system.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.chenyu.meta.common.param.BaseParam;
import com.chenyu.meta.common.util.ApiCode;
import com.chenyu.meta.common.util.ApiResult;
import com.chenyu.meta.common.util.SaltUtils;
import com.chenyu.meta.config.properties.JwtProperties;
import com.chenyu.meta.config.properties.MetaProperties;
import com.chenyu.meta.framework.constant.CommonConstant;
import com.chenyu.meta.framework.constant.CommonRedisKey;
import com.chenyu.meta.framework.shiro.jwt.JwtToken;
import com.chenyu.meta.framework.shiro.service.LoginRedisService;
import com.chenyu.meta.framework.shiro.util.JwtUtil;
import com.chenyu.meta.framework.shiro.vo.LoginSysUserRedisVo;
import com.chenyu.meta.framework.shiro.vo.LoginSysUserVo;
import com.chenyu.meta.framework.util.JwtTokenUtil;
import com.chenyu.meta.system.domain.SysDepartment;
import com.chenyu.meta.system.domain.SysRole;
import com.chenyu.meta.system.domain.SysUser;
import com.chenyu.meta.system.mapper.UmsSysUserMapper;
import com.chenyu.meta.system.param.LoginParam;
import com.chenyu.meta.system.param.ResetPwdParam;
import com.chenyu.meta.system.service.LoginService;
import com.chenyu.meta.system.service.SysDepartmentService;
import com.chenyu.meta.system.service.SysRolePermissionService;
import com.chenyu.meta.system.service.SysRoleService;
import com.chenyu.meta.system.vo.LoginSysUserTokenVo;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Create by 10296 on 2023/3/3
 *
 * @Description:
 */
@Service
public class LoginServiceImpl implements LoginService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MetaProperties metaProperties;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UmsSysUserMapper umsSysUserMapper;
    @Autowired
    private SysDepartmentService sysDepartmentService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRolePermissionService sysRolePermissionService;
    @Autowired
    private LoginRedisService loginRedisService;
    @Autowired
    private JwtProperties jwtProperties;

    @Override
    public ApiResult login(LoginParam loginParam, HttpServletResponse response) {

        try {
            //校验验证码
            checkVerifyCode(loginParam.getVerifyToken(), loginParam.getCode());

            String username = loginParam.getUsername();
            String password = loginParam.getPassword();
            Map<String, Object> params = new HashMap<>();
            params.put("username", username);
            List<SysUser> sysUserList = umsSysUserMapper.qrySysUmsUserByUserName(username);
            if (CollectionUtils.isEmpty(sysUserList)) {
                return ApiResult.fail("用户不存在！");
            }
            params.put("password", password);
            List<SysUser> sysUsers = umsSysUserMapper.qrySysUser(params);
            if (CollectionUtils.isEmpty(sysUsers)) {
                return ApiResult.fail("用户名或密码错误！");
            }
            SysUser sysUser = sysUsers.get(0);
            logger.info(">>>>>>>userInfo:::" + JSONObject.toJSONString(sysUser));

            LoginSysUserVo loginSysUserVo = new LoginSysUserVo();
            loginSysUserVo.setId(sysUser.getUserId());
            loginSysUserVo.setDepartmentId(sysUser.getDepartmentId());
            loginSysUserVo.setGender(sysUser.getGender());
            loginSysUserVo.setNickname(sysUser.getNickname());
            Long roleId = sysUser.getRoleId();
            loginSysUserVo.setRoleId(roleId);
            loginSysUserVo.setUsername(sysUser.getUsername());
            loginSysUserVo.setState(sysUser.getState());
            loginSysUserVo.setHead(sysUser.getHead());
            loginSysUserVo.setEmail(sysUser.getEmail());
            loginSysUserVo.setPhone(sysUser.getPhone());


            if (("0").equals(sysUser.getState())) {
                return ApiResult.fail("账号已禁用！");
            }
            if (("2").equals(sysUser.getState())) {
                return ApiResult.fail("账号已锁定！");
            }
            //
            Map<String, Object> deptParams = new HashMap<>();
            deptParams.put("departmentId", sysUser.getDepartmentId());
            List<SysDepartment> sysDepartments = sysDepartmentService.qrySysDepartmentById(deptParams);

            if (CollectionUtils.isEmpty(sysDepartments)) {
                return ApiResult.fail("部门不存在");
            }
            SysDepartment sysDepartment = sysDepartments.get(0);
            if (("0").equals(sysDepartment.getState())) {
                return ApiResult.fail("部门已禁用");
            }
            loginSysUserVo.setDepartmentName(sysDepartment.getDeptName());

            //获取当前用户角色
            Map<String, Object> roleParams = new HashMap<>();
            roleParams.put("roleId", sysUser.getRoleId());


            List<SysRole> sysRoles = sysRoleService.qrySysRole(roleParams);
            if (CollectionUtils.isEmpty(sysRoles)) {
                return ApiResult.fail("角色已禁用！");
            }
            SysRole sysRole = sysRoles.get(0);
            loginSysUserVo.setRoleName(sysRole.getRoleName());
            loginSysUserVo.setRoleCode(sysRole.getRoleCode());
            //获取当前用户权限
            Set<String> permissionCodes = sysRolePermissionService.getPermissionCodesByRoleId(sysRole.getRoleId());
            if (CollectionUtils.isEmpty(permissionCodes)) {
                return ApiResult.fail("权限不能为空!");
            }
            loginSysUserVo.setPermissionCodes(permissionCodes);


            //获取系统中保存的盐值
            String salt = SaltUtils.getSalt(sysUser.getSalt(), jwtProperties.getSecret());
            //生成token
            Long expireSecond = jwtProperties.getExpireSecond();
            String token = JwtUtil.generateToken(username, salt, Duration.ofSeconds(expireSecond));

            logger.info(">>>>>>>> login generate Token :{}", token);
            //创建AuthenticationToken
            JwtToken jwtToken = JwtToken.build(token, username, salt, expireSecond);

            boolean enable = metaProperties.getShiro().isEnable();
            if (enable) {
                //从SecurityUtils里边创建一个 subject
                Subject subject = SecurityUtils.getSubject();
                subject.login(jwtToken);
            } else {
                logger.info(">>>>>>>>>>>Login 未启用 Shiro>>>>>>>>");
            }

            // 缓存登录信息到Redis
            loginRedisService.cacheLoginInfo(jwtToken, loginSysUserVo);
            logger.info(">>>>>>>>用户登录成功>>>>>>>,username:{}", username);
            //缓存登录信息
            String hex = DigestUtils.sha256Hex(token);
            redisTemplate.opsForValue().set(hex, loginSysUserVo, 1, TimeUnit.DAYS);
            // 返回token和登录用户信息对象
            LoginSysUserTokenVo loginSysUserTokenVo = new LoginSysUserTokenVo();
            loginSysUserTokenVo.setToken(token);
            loginSysUserTokenVo.setUserInfo(loginSysUserVo);

            //设置Token请求头
            response.setHeader(JwtTokenUtil.getTokenName(), token);
            Object json = JSON.toJSON(loginSysUserTokenVo);
            return ApiResult.ok(json, "登录成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(">>>>>>>>>>>>>>>>>登录失败,失败原因" + e.getMessage(), e);
            return ApiResult.fail("登录失败:失败原因：" + e.getMessage());
        }
    }

    @Override
    public ApiResult getUserInfo(HttpServletRequest request, BaseParam param, HttpServletResponse response) {
        try {
            String token = request.getHeader(CommonConstant.HEADER_ACCESS_TOKEN);
            //判断token是否存在
            boolean exists = loginRedisService.exists(token);
            if (!exists) {
                ApiResult.result(ApiCode.UNAUTHORIZED);
            }
            //判断token是否过期
            LoginSysUserRedisVo sysUser = loginRedisService.getLoginSysUserByToken(token);


//            String username = param.getName();
//            List<SysUser> sysUserList = umsSysUserMapper.qrySysUmsUserByUserName(username);
//            SysUser sysUser = sysUserList.get(0);
//            logger.info(">>>>>>>userInfo:::" + JSONObject.toJSONString(sysUser));
            LoginSysUserVo loginSysUserVo = new LoginSysUserVo();
            loginSysUserVo.setId(sysUser.getId());
            Long roleId = sysUser.getRoleId();
            loginSysUserVo.setDepartmentId(sysUser.getDepartmentId());
            loginSysUserVo.setGender(sysUser.getGender());
            loginSysUserVo.setNickname(sysUser.getNickname());
            loginSysUserVo.setRoleId(roleId);
            loginSysUserVo.setUsername(sysUser.getUsername());
            loginSysUserVo.setState(sysUser.getState());
            loginSysUserVo.setHead(sysUser.getHead());
            loginSysUserVo.setEmail(sysUser.getEmail());
            loginSysUserVo.setPhone(sysUser.getPhone());
            if (("0").equals(sysUser.getState())) {
                return ApiResult.fail("账号已禁用！");
            }
            if (("2").equals(sysUser.getState())) {
                return ApiResult.fail("账号已锁定！");
            }
            Map<String, Object> deptParams = new HashMap<>();
            deptParams.put("departmentId", sysUser.getDepartmentId());
            List<SysDepartment> sysDepartments = sysDepartmentService.qrySysDepartmentById(deptParams);

            if (CollectionUtils.isEmpty(sysDepartments)) {
                return ApiResult.fail("部门不存在");
            }
            SysDepartment sysDepartment = sysDepartments.get(0);
            if (("0").equals(sysDepartment.getState())) {
                return ApiResult.fail("部门已禁用");
            }
            loginSysUserVo.setDepartmentName(sysDepartment.getDeptName());

            //获取当前用户角色
            Map<String, Object> roleParams = new HashMap<>();
            roleParams.put("roleId", sysUser.getRoleId());
            List<SysRole> sysRoles = sysRoleService.qrySysRole(roleParams);
            if (CollectionUtils.isEmpty(sysRoles)) {
                return ApiResult.fail("角色已禁用！");
            }
            SysRole sysRole = sysRoles.get(0);
            loginSysUserVo.setRoleName(sysRole.getRoleName());
            loginSysUserVo.setRoleCode(sysRole.getRoleCode());
            Set<String> permissionCodes = sysRolePermissionService.getPermissionCodesByRoleId(sysRole.getRoleId());
            if (CollectionUtils.isEmpty(permissionCodes)) {
                return ApiResult.fail("权限不能为空!");
            }
            loginSysUserVo.setPermissionCodes(permissionCodes);
            Object json = JSON.toJSON(loginSysUserVo);
            return ApiResult.ok(json, "用户信息获取成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(">>>>>>>>>>>>>>>>>用户信息获取失败,失败原因" + e.getMessage(), e);
            return ApiResult.fail("用户信息获取失败:失败原因：" + e.getMessage());
        }
    }


    @Override
    public ApiResult verifyAuthToken(String token) {
        try {
            boolean exists = loginRedisService.exists(token);

            if (exists) {
                return ApiResult.ok("校验成功！");
            } else {
                ApiResult.fail("校验失败");
            }

        } catch (Exception e) {
            logger.error(">>>>>>>>>>>>>token 校验失败：" + e.getMessage(), e);
            return ApiResult.fail("校验失败！请重新登录");
        }
        return ApiResult.ok("校验成功！");
    }

    @Override
    public ApiResult resetPassword(ResetPwdParam resetPwdParam) {

        //对密码进行解密
        try {
            List<SysUser> users = umsSysUserMapper.qrySysUmsUserByUserName(resetPwdParam.getUsername());
            Map<String, Object> params = new HashMap<>();
            params.put("username", resetPwdParam.getUsername());
            if (CollectionUtils.isEmpty(users)) {
                return ApiResult.fail("用户不存在！");
            }

            params.put("password", resetPwdParam.getOldPassword());
            List<SysUser> sysUsers = umsSysUserMapper.qrySysUser(params);

            SysUser sysUser;
            if (CollectionUtils.isNotEmpty(sysUsers)) {
                sysUser = sysUsers.get(0);
            } else {
                return ApiResult.fail("原密码错误！");
            }

            Map<String, Object> resetMap = new HashMap<>();
            resetMap.put("password", resetPwdParam.getNewPassword());
            resetMap.put("userId", sysUser.getUserId());
            logger.info(">>>>>>>>>" + JSONObject.toJSONString(resetMap));
            boolean reset = umsSysUserMapper.resetPassword(resetMap);
            if (reset) {
                return ApiResult.ok("密码修改成功！");
            }
        } catch (Exception e) {
            logger.error(">>>>>>>>>>>>>密码修改失败！失败原因:", e);
            return ApiResult.fail("密码修改失败!" + e.getMessage());
        }
        return ApiResult.fail("密码修改失败!");

    }

    @Override
    public ApiResult forgetPassword(LoginParam loginParam) {
        //对密码进行解密
        try {
            List<SysUser> sysUsers = umsSysUserMapper.qrySysUmsUserByUserName(loginParam.getUsername());
            if (CollectionUtils.isEmpty(sysUsers)) {
                return ApiResult.fail("用户不存在！");
            }
            SysUser sysUser = null;
            if (CollectionUtils.isNotEmpty(sysUsers)) {
                sysUser = sysUsers.get(0);
            }
            Map<String, Object> resetMap = new HashMap<>();
            resetMap.put("password", loginParam.getPassword());
            assert sysUser != null;
            resetMap.put("userId", sysUser.getUserId());
            boolean reset = umsSysUserMapper.resetPassword(resetMap);
            if (reset) {
                return ApiResult.ok("密码修改成功！");
            }
        } catch (Exception e) {
            logger.error(">>>>>>>>>>>>>密码修改失败！失败原因:", e);
            return ApiResult.fail("密码修改失败!" + e.getMessage());
        }
        return ApiResult.fail("密码修改失败!");

    }

    @Override
    public ApiResult logout(HttpServletRequest request) {

        try {
            boolean enable = metaProperties.getShiro().isEnable();
            if (enable) {
                Subject subject = SecurityUtils.getSubject();

                subject.logout();
            }
            String token = JwtTokenUtil.getToken(request);
            logger.info(">>>>>>>>>>>>>>>  token    " + token);
            String username = JwtUtil.getUsername(token);
            logger.info(">>>>>>>>>>>>>>..  username  " + username);
            //删除Redis信息
            loginRedisService.deleteLoginInfo(token, username);
            return ApiResult.ok("退出成功！");
        } catch (Exception e) {
            logger.error(">>>>>>>>>>>>>>>>.退出失败！", e);
            return ApiResult.fail("退出失败");
        }


    }

    private void checkVerifyCode(String verifyToken, String code) {


        logger.info(">>>>>>>>>>>>" + metaProperties.isEnableVerifyCode());
        logger.info(">>>>>>>>>>-------" + JSONObject.toJSONString(metaProperties));

        if (!metaProperties.isEnableVerifyCode()) {
            return;
        }
        //校验验证码
        if (StringUtils.isEmpty(code)) {
            throw new RuntimeException("请输入验证码！");
        }
        //从redis中获取验证码
        String key = String.format(CommonRedisKey.VERIFY_CODE, verifyToken);
        String generateCode = (String) redisTemplate.opsForValue().get(key);
        if (StringUtils.isEmpty(generateCode)) {
            throw new RuntimeException("验证码已过期！");
        }
        if (!generateCode.equalsIgnoreCase(code)) {
            throw new RuntimeException("验证码输入错误！");
        }
        //验证码校验成功，删除Redis缓存中的验证码
        redisTemplate.delete(key);

    }


}
