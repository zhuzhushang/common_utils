package com.noahedu.yxputils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Author: shaoqw
 * Date: 2020/12/28 20:54
 * Description:
 */
public class YxpEncryptUtils {


    /**
     * Return the bytes of hash encryption.
     *
     * @param data      The data.
     * @param algorithm The name of hash encryption.
     * @return the bytes of hash encryption
     */
    static byte[] hashTemplate(final byte[] data, final String algorithm) {
        if (data == null || data.length <= 0) return null;
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(data);
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
