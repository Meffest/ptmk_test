package ru.test;

import java.util.Random;

/**
 * Генератор рандомных строк
 */
public class StrGenerator {

    public static final Random RND = new Random(1);

    public static String generateString(int length, Consist consist) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = consist.getConsist().charAt(RND.nextInt(consist.getConsist().length()));
        }
        String s = new String(text);
        return s;
    }

    public enum Consist {
        ONLY_LETTERS("АБВГДЕЖЗИКЛМНОПРСТУФХЧШЩЭЮЯ"),
        ONLY_DIGITS("0123456789");

        private String consist;

        Consist(String consist) {
            this.consist = consist;
        }

        public String getConsist() {
            return consist;
        }
    }
}
