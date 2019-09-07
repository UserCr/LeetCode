package com.leetcode.solutions.string;

import com.leetcode.solutions.SolutionInterface;

public class Q6_ZigZagConversion implements SolutionInterface {
    @Override
    public void run() {
    }

    //略水，将每个字符用其所在行号标号后发现整个字符串标号是个不断重复的回文串，按行号递增顺序输出对应字符就是答案。
    public String convert(String s, int numRows) {
        if (1 == numRows || s.isEmpty()) return s;

        StringBuilder stringBuilder = new StringBuilder(s.length());
        for (int i = 0; i < numRows; ++i) {
            if (0 == i || numRows - 1 == i) {
                for (int pos = i; pos < s.length(); pos += 2 * (numRows - 1)) {
                    stringBuilder.append(s.charAt(pos));
                }
            } else {
                int posLeft = i, posRight = 2 * (numRows - 1) - i;
                while (posLeft < s.length() || posRight < s.length()) {
                    if (posLeft < s.length()) {
                        stringBuilder.append(s.charAt(posLeft));
                        posLeft += 2 * (numRows - 1);
                    }
                    if (posRight < s.length()) {
                        stringBuilder.append(s.charAt(posRight));
                        posRight += 2 * (numRows - 1);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}
