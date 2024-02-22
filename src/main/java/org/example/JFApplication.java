package org.example;


import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class JFApplication {
    public static String salt = "guyouyue";
    public static List<Character> saltList = Arrays.asList('○', 'O', '0', 'o');

    public static void main(String[] args) {
        JFrame jf = new JFrame("简易对称加密解密程序");
        jf.setContentPane(new JFTest().mainPanel);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }

}
