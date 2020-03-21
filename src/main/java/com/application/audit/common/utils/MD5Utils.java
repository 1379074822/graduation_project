package com.application.audit.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @description:
 * @author:
 * @time: 2020/3/9 19:15
 */
public class MD5Utils {


    private static final Logger LOGGER = LoggerFactory.getLogger(MD5Utils.class);
    private static final String SALT = "graduation_project";

    private static byte[] md5(String s) {
        MessageDigest algorithm;
        try {
            algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(s.getBytes("UTF-8"));
            byte[] messageDigest = algorithm.digest();
            return messageDigest;
        } catch (Exception e) {
            LOGGER.error("MD5 Error...", e);
        }
        return null;
    }

    private static final String toHex(byte[] hash) {
        if (hash == null) {
            return null;
        }
        StringBuffer buf = new StringBuffer(hash.length * 2);
        int i;

        for (i = 0; i < hash.length; i++) {
            if ((hash[i] & 0xff) < 0x10) {
                buf.append("0");
            }
            buf.append(Long.toString(hash[i] & 0xff, 16));
        }
        return buf.toString();
    }

    public static String hash(String s) {
        try {
            return new String(toHex(md5(s)).getBytes("UTF-8"), "UTF-8");
        } catch (Exception e) {
            LOGGER.error("not supported charset...{}", e);
            return s;
        }
    }

    /**
     * 对密码按照用户名，密码，盐进行加密
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public static String encryptPassword(String username, String password) {
        return MD5Utils.hash(username + password + SALT);
    }

    /**
     * 对密码按照密码，盐进行加密
     *
     * @param password 密码
     * @return
     */
    public static String encryptPassword(String password) {
        return MD5Utils.hash(password + SALT);
    }


}
