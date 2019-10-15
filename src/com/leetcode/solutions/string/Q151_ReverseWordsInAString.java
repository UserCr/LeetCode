package com.leetcode.solutions.string;

import com.leetcode.solutions.SolutionInterface;

import java.util.ArrayList;
import java.util.List;

public class Q151_ReverseWordsInAString implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public String reverseWords(String s) {
        List<String> strings = new ArrayList<>();
        for (int left = 0; left < s.length(); left++) {
            if (s.charAt(left) != ' ') {
                int right = left;
                while (right < s.length() && s.charAt(right) != ' ') {
                    right++;
                }
                strings.add(s.substring(left, right));
                left = right;
            }
        }
        for (int i = 0; i < strings.size(); ++i) {
            strings.set(i, reverseString(strings.get(i)));
        }
        return reverseString(String.join(" ", strings));
    }

    private String reverseString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return String.valueOf(chars);
    }
}
