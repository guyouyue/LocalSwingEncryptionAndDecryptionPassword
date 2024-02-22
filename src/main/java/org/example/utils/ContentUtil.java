package org.example.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 文本处理工具类
 *
 * @author MaybeLXH
 * @since 2024-02-02 17:44
 */
public class ContentUtil {
    /**
     * 文本转16进制字符串
     *
     * @param str 要处理的文本
     */
    public static String str2hex(String str) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int charCode = str.charAt(i);
            String charHexStr = charCodeToHexStr(charCode);
            ret.append(charHexStr);
        }
        return ret.toString();
    }

    /**
     * 文本转16进制字符串集合
     *
     * @param str 要处理的文本
     */
    public static List<String> str2hexList(String str) {
        ArrayList<String> hexList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            int charCode = str.charAt(i);
            String charHexStr = charCodeToHexStr(charCode);
            hexList.add(charHexStr);
        }
        return hexList;
    }

    /**
     * charcode转16进制字符串(保留4位)
     *
     * @param charCode 字符的code
     */
    public static String charCodeToHexStr(int charCode) {
        String charHexStr = Integer.toHexString(charCode);
        if (charHexStr.length() == 1) {
            charHexStr = "000" + charHexStr;
        } else if (charHexStr.length() == 2) {
            charHexStr = "00" + charHexStr;
        } else if (charHexStr.length() == 3) {
            charHexStr = "0" + charHexStr;
        }
        return charHexStr;
    }

    /**
     * 文本转16进制int集合
     *
     * @param str 要处理的文本
     */
    public static List<Integer> str2charIntList(String str) {
        ArrayList<Integer> hexList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            int charCode = str.charAt(i);
            hexList.add(charCode);
        }
        return hexList;
    }

    /**
     * 16进制字符串集合转文本
     *
     * @param hexList 16进制字符串集合
     */
    public static String hexList2str(List<String> hexList) {
        StringBuilder str = new StringBuilder("");
        for (String hex : hexList) {
            int number = Integer.parseInt(hex, 16);
            str.append(new String(Character.toChars(number)));
        }
        return str.toString();
    }
    public static String charCodeList2str(List<String> hexList) {
        StringBuilder str = new StringBuilder("");
        for (String hex : hexList) {
            str.append(new String(Character.toChars(Integer.parseInt(hex))));
        }
        return str.toString();
    }

    /**
     * 16进制字符串集合转文本
     *
     * @param hex 16进制字符串
     */
    public static String hex2str(String hex) {
        List<String> result = Arrays.asList(hex.split("(?<=\\G....)"));
        return hexList2str(result);
    }
}
