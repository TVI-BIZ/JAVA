package com.javarush.task.task40.task4012;
import java.security.MessageDigest;
/**
 * Program prints code in console.
 */

public class test {
    public static void main(String[] args) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest("abracadabra".getBytes("UTF-8"));
        for (byte b : digest) {
            System.out.printf("%02x", b);
        }
    }
}
