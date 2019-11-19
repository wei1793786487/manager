package com.hqgml.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @data 11/17/2019 7:25 PM
 **/
public class encryptionUtlis {


  private static   BCryptPasswordEncoder  bs = new BCryptPasswordEncoder();

    public static String encodePassWord(String password) {
        return bs.encode(password);
    }

    public static void main(String[] args) {
        String password="123";
        String s = encodePassWord(password);
        System.out.println(s);
    }
}
