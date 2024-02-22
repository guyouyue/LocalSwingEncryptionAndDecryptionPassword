package org.example.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.example.JFApplication.saltList;


/**
 * 解析密码工具栏
 *
 * @author MaybeLXH
 * @since 2024-02-02 17:39
 */
public class AnalysisPasswordUtil {
    /**
     * 解密方法
     *
     * @param content 要解开的密文
     * @param salt    盐
     */
    public static String analysis(String content, String salt) {
        try {
            List<Integer> contextCharIntList = saltAndContentStringToContextCharIntList(content);
            List<Integer> saltListCharIntList = ContentUtil.str2charIntList(salt);
            int size = saltListCharIntList.size();
            List<String> charCodeList = new ArrayList<>();
            for (int i = 0; i < contextCharIntList.size(); i++) {
                int charCode = contextCharIntList.get(i) - saltListCharIntList.get(i % size);
                charCodeList.add(String.valueOf(charCode));
            }
            if (Objects.isNull(charCodeList) || charCodeList.isEmpty()) {
                return "输入文本异常";
            }
            return ContentUtil.charCodeList2str(charCodeList);
        } catch (Exception e) {
            return "输入文本异常";
        }
    }

    private static List<Integer> saltAndContentStringToContextCharIntList(String content) {
        List<Integer> contextCharIntList = new ArrayList<>();
        List<Integer> integers = saltAndContentStringToCharIntList(content);
        StringBuilder beast = new StringBuilder();
        for (int i = 0; i < integers.size(); i++) {
            char aChar = Character.forDigit(integers.get(i), 16);
            beast.append(aChar);
            if ((i + 1) % 4 == 0) {
                contextCharIntList.add(Integer.parseInt(beast.toString(), 16));
                beast = new StringBuilder();
            }
        }
        return contextCharIntList;
    }

    public static List<Integer> saltAndContentStringToCharIntList(String saltAndcontentString) {
        char[] chars = saltAndcontentString.toCharArray();
        int n = 0;
        int temp = 0;
        List<Integer> contextCharIntList = new ArrayList<>();
        for (char aChar : chars) {
            int index = saltList.indexOf(aChar);
            if (n++ % 2 == 0) {
                temp += (index * 4);
            } else {
                temp += index;
                contextCharIntList.add(temp);
                temp = 0;
            }
        }
        return contextCharIntList;
    }
}
