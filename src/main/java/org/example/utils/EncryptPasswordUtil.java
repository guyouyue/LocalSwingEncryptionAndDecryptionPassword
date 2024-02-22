package org.example.utils;

import java.util.List;

import static org.example.JFApplication.saltList;


/**
 * 加密密码工具类
 *
 * @author MaybeLXH
 * @since 2024-02-02 17:36
 */
public class EncryptPasswordUtil {
    /**
     * 加密方法
     *
     * @param content 要加密的原文
     * @param salt    盐
     */
    public static String encrypt(String content, String salt) {
        List<Integer> contextCharIntList = ContentUtil.str2charIntList(content);
        List<Integer> saltListCharIntList = ContentUtil.str2charIntList(salt);
        int size = saltListCharIntList.size();
        StringBuilder beast = new StringBuilder();
        for (int i = 0; i < contextCharIntList.size(); i++) {
            int charCode = contextCharIntList.get(i) + saltListCharIntList.get(i % size);
            beast.append(ContentUtil.charCodeToHexStr(charCode));
        }
        return stringListToSaltString(beast.toString());
    }

    private static String stringListToSaltString(String str) {
        StringBuilder beast = new StringBuilder();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            int k = Integer.parseInt(String.valueOf(aChar), 16);
            beast.append(saltList.get(k / 4)).append(saltList.get((k % 4)));
        }
        return beast.toString();
    }
}
