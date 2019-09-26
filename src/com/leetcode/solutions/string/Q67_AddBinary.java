package com.leetcode.solutions.string;

import com.leetcode.solutions.SolutionInterface;

public class Q67_AddBinary implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int posA = a.length() - 1, posB = b.length() - 1;
        int carry = 0;
        while (posA >= 0 && posB >= 0) {
            int sum = a.charAt(posA--) - '0' + b.charAt(posB--) - '0' + carry;
            stringBuilder.append(sum % 2);
            carry = sum / 2;
        }
        while (posA >= 0) {
            int sum = a.charAt(posA--) - '0' + carry;
            stringBuilder.append(sum % 2);
            carry = sum / 2;
        }
        while (posB >= 0) {
            int sum = b.charAt(posB--) - '0' + carry;
            stringBuilder.append(sum % 2);
            carry = sum / 2;
        }
        if (carry > 0) {
            stringBuilder.append(carry);
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}
