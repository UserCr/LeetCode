package com.leetcode.solutions.string;

import com.leetcode.solutions.SolutionInterface;

public class Q8_StringToInteger_atoi implements SolutionInterface {
    @Override
    public void run() {
        myAtoi("-91283472332");
    }

    public int myAtoi(String str) {
        int pos = 0;
        while (pos < str.length() && str.charAt(pos) == ' ') {
            pos++;
        }
        if (pos >= str.length() ||
                !(('0' <= str.charAt(pos) && str.charAt(pos) <= '9') || str.charAt(pos) == '+' || str.charAt(pos) == '-')) {
            return 0;
        }
        boolean isNegative = false;
        if (str.charAt(pos) == '+' || str.charAt(pos) == '-') {
            if (str.charAt(pos) == '-') {
                isNegative = true;
            }
            pos++;
        }
        if (pos >= str.length() || !('0' <= str.charAt(pos) && str.charAt(pos) <= '9')) {
            return 0;
        }
        int res = 0;
        while (pos < str.length() && '0' <= str.charAt(pos) && str.charAt(pos) <= '9') {
            int pre = res;
            res = (res * 10) + str.charAt(pos) - '0';
            if (res / 10 != pre) {
                if (isNegative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            pos++;
        }
        if (isNegative) {
            res *= (-1);
        }
        return res;
    }
}
