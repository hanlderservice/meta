package com.chenyu.meta.common.util;

import org.fusesource.jansi.Ansi;
import org.springframework.core.env.Environment;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description:
 */
public class AnsiUtil {


    private static boolean enableAnsi;

    static {
        Boolean value = false;
        try {
            Environment environment = SpringContextUtils.getBean(Environment.class);
            value = environment.getProperty("meta.enable-ansi", boolean.class);
            value = value == null ? false : value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        enableAnsi = value;
    }

    public static String getAnsi(Ansi.Color color, String text) {

        if (enableAnsi) {
            return Ansi.ansi().eraseScreen().fg(color).a(text).reset().toString();
        }
        return text;
    }

    public static String getAnsi(Ansi.Color color, String text, boolean flag) {
        if (flag) {
            return Ansi.ansi().eraseScreen().fg(color).a(text).reset().toString();
        }
        return text;
    }


}