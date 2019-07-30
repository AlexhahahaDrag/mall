package com.alex.core.util;

import java.util.Random;

/**
 * @Description: 字符工具
 * @Author:     alex
 * @CreateDate: 2019/7/30 16:04
 * @Version:    1.0
 *
*/
public class CharUtil {

    public static String getRandomString(Integer num) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int len = base.length();
        int number;
        for (int i = 0; i < num; i++) {
            number = random.nextInt(len);
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static String getRandomNum(Integer num) {
        String base = "0123456789";
        Random random = new Random();
        int len = base.length();
        StringBuilder sb = new StringBuilder();
        int number;
        for (int i = 0; i < num; i++) {
            number = random.nextInt(len);
            sb.append(base.charAt(number));
        }
        return  sb.toString();
    }
}
