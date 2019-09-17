package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q415_AddStrings implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int pos1 = num1.length() - 1, pos2 = num2.length() - 1;
        while (pos1 >= 0 && pos2 >= 0) {
            int sum = (num1.charAt(pos1--) - '0') + (num2.charAt(pos2--) - '0') + carry;
            stringBuilder.append(sum % 10);
            carry = sum / 10;
        }
        while (pos1 >= 0) {
            int sum = (num1.charAt(pos1--) - '0') + carry;
            stringBuilder.append(sum % 10);
            carry = sum / 10;
        }
        while (pos2 >= 0) {
            int sum = (num2.charAt(pos2--) - '0') + carry;
            stringBuilder.append(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            stringBuilder.append(carry);
        }
        return stringBuilder.reverse().toString();
    }
}
