package com.chenyu.meta.config;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create by 10296 on 2023/3/7
 *
 * @Description:
 */
public class DesensitizeUtils {


    public static List<Map<String, String>> addressResolution(String address) {
        String regex = "((?<province>[^省]+省|.+自治区)|上海|北京|天津|重庆)(?<city>[^市]+市|.+自治州)(?<county>[^县]+县|.+区|.+镇|.+局)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
        Matcher m = Pattern.compile(regex).matcher(address);
        String province = null, city = null, county = null, town = null, village = null;
        List<Map<String, String>> table = new ArrayList<>();
        Map<String, String> row = null;
        while (m.find()) {
            row = new LinkedHashMap<>();
            province = m.group("province");
            row.put("province", province == null ? "" : province.trim());
            city = m.group("city");
            row.put("city", city == null ? "" : city.trim());
            county = m.group("county");
            row.put("county", county == null ? "" : county.trim());
            town = m.group("town");
            row.put("town", town == null ? "" : town.trim());
            village = m.group("village");
            row.put("village", village == null ? "" : village.trim());
            table.add(row);
        }
        return table;
    }


}
