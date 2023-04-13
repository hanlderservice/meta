package com.chenyu.meta.adapter;

import com.chenyu.meta.adapter.domain.DesensitizeAttrDefDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.AntPathMatcher;

import java.io.File;
import java.util.*;

/**
 * Create by 10296 on 2023/3/8
 *
 * @Description:
 */
public class Test {

    public static final Logger LOGGER = LoggerFactory.getLogger(Test.class);


    public static void main(String[] args) {
        AntPathMatcher pathMatcher = new AntPathMatcher();

        boolean match1 = pathMatcher.match("/user/getUserById/*", "/user/getUserById/3");
        Map<String, String> pathParamMap1 = pathMatcher.extractUriTemplateVariables("/user/getUserById/{userId}", "/user/getUserById/3");
        boolean match11 = pathMatcher.match("/user/getUserById/**", "/user/getUserById/3");
        Map<String, String> pathParamMap11 = pathMatcher.extractUriTemplateVariables("/user/getUserById/**", "/user/getUserById/3");
        String s11 = pathMatcher.extractPathWithinPattern("/user/getUserById/**", "/user/getUserById/3");
        boolean match12 = pathMatcher.match("/user/getUserById/**", "/user/getUserById/a/b");
        String s12 = pathMatcher.extractPathWithinPattern("/user/getUserById/**", "/user/getUserById/a/b");
        boolean match13 = pathMatcher.match("/user/getUserById/*", "/user/getUserById/a/b");
        boolean match2 = pathMatcher.match("/user/getUserById/{userId}", "/user/getUserById");


        String path = "/IOM-CLOUD-SERVICE/orderMonitor/gx/qryLogicData.qry/3128006403";


        Set<String> set = new HashSet<>();
        set.add("/IOM-CLOUD-SERVICE/orderMonitor/gx/qryLogicData.qry/{orderId}");
//        set.add("/IOM-CLOUD-SERVICE/orderMonitor/gx/qryLogicData.qry/*");
        set.add("/oss-web/IOM-CLOUD-SERVICE/orderManagerController/queryCust.qry");
        set.add("/oss-web/IOM-CLOUD-INF-SERVICE/OmResLogicDataController/qryLogicData.qry/{orderId}");
        boolean b = pathMatcher(path, set);
        System.out.println(">>>>>>>>>>>>>>>>"+b);

        System.out.println(match1);  // true
        System.out.println(pathParamMap1); // {userId=3}
        System.out.println(match11); // true
        System.out.println(pathParamMap11); // {}
        System.out.println(s11); // 3
        System.out.println(match12); // true
        System.out.println(s12); // a/b
        System.out.println(match13); // false
        System.out.println(match2); // false

    }


    private static boolean pathMatcher(String url, Set<String> set) {
        AntPathMatcher pathMatcher = new AntPathMatcher();
        Set<String> vagueUrls = set;
        for (String vagueUrl : vagueUrls) {
            if (pathMatcher.match(vagueUrl, url)) {
                return true;
            }
        }
        return false;
    }

}
