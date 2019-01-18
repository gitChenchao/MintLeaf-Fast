package org.mintleaf.utils;

import java.util.UUID;

/**
 * 生成随机字符串的工具类uuid
 */
public class UUIDUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void main(String[] args) {
        System.out.println("格式前的UUID ： " + UUID.randomUUID().toString());
        System.out.println("格式化后的UUID ：" + getUUID());
    }
}
