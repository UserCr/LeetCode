package com.leetcode.solutions.string;

import com.leetcode.solutions.SolutionInterface;

import java.util.LinkedList;
import java.util.List;

public class Q17_LetterCombinationsOfAPhoneNumber implements SolutionInterface {

    @Override
    public void run() {
    }

    //水题。
    private char[][] keyboardMap = {
            {}, {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}};

    private String recordToResString(String digits, int[] record) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < record.length; ++i) {
            stringBuilder.append(keyboardMap[digits.charAt(i) - '0'][record[i]]);
        }
        return stringBuilder.toString();
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();

        if (0 == digits.length()) {
            return res;
        }

        int resSize = 1;
        for (int i = 0; i < digits.length(); ++i) {
            resSize *= keyboardMap[digits.charAt(i) - '0'].length;
        }

        int[] record = new int[digits.length()];
        for (int i = 0; i < record.length; ++i) {
            record[i] = 0;
        }

        for (int i = 0; i < resSize; ++i) {
            res.add(recordToResString(digits, record));

            int curPos = record.length - 1;
            record[curPos]++;
            while (record[curPos] == keyboardMap[digits.charAt(curPos) - '0'].length) {
                record[curPos] = 0;
                if (curPos != 0) {
                    record[curPos - 1]++;
                    curPos--;
                }
            }
        }
        return res;
    }
}
