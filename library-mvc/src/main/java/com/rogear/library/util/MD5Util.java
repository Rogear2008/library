package com.rogear.library.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Rogear on 2020/4/22
 **/
public class MD5Util {

    public static String encode(String password){
        if (password.isEmpty()){
            return null;
        } else {
            MessageDigest messageDigest = null;
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            String result = messageDigest.digest(password.getBytes()).toString();
            return result;
        }
    }
}
