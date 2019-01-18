package org.mintleaf.utils;

/**
 * 加密相关工具类
 */
public class EncryptionUtils {
    public static String sign(String src,String timestamp){
        return MD5Util.MD5("mintleaf"+StringUtils.sort(src)+timestamp);
    }
}
