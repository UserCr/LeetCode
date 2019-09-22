package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

public class Q66_PlusOne implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int[] plusOne(int[] digits) {
        boolean allDigitEqual9 = true;
        for (int digit : digits) {
            if (digit != 9) {
                allDigitEqual9 = false;
                break;
            }
        }

        if (allDigitEqual9) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        } else {
            int[] res = new int[digits.length];
            int carry = 1;
            for (int i = digits.length - 1; i >= 0; --i) {
                int sum = digits[i] + carry;
                res[i] = sum % 10;
                carry = sum / 10;
            }
            return res;
        }
    }
}
