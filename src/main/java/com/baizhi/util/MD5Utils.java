package com.baizhi.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Md5加盐
 */
public class MD5Utils {

    //����һ���޶��ַ�
    static String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    /**
     * @Author : ZK
     * @Description : �����(һ��8λ������ַ�)
     * @Return : ������ɵ���
     * @Date : 20:55 2018/6/9
     */
    public static String getSalt() {
        StringBuffer salt = new StringBuffer();
        for (int i = 0; i <= 7; i++) {
            salt.append(str.charAt(new Random().nextInt(62)));
        }
        return salt.toString();
    }


    public static String getPassword(String upassword) {
        StringBuffer password = null;
        try {
            //ָ�����ܵķ�ʽΪmd5
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] digest = messageDigest.digest(upassword.getBytes());
            password = new StringBuffer();
            for (byte b : digest) {
                //λ����
                int len = b & 0xff;
                if (len < 15) {
                    password.append("0");
                }
                password.append(Integer.toHexString(len));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return password.toString();
    }
}

