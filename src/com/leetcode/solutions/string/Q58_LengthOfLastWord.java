package com.leetcode.solutions.string;

import com.leetcode.solutions.SolutionInterface;

public class Q58_LengthOfLastWord implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int lengthOfLastWord(String s) {
        int length = 0;
        int curPos = s.length() - 1;
        while (curPos >= 0 && s.charAt(curPos) == ' ') {
            curPos--;
        }
        while (curPos >= 0 && s.charAt(curPos) != ' ') {
            curPos--;
            length++;
        }
        return length;
    }
}
