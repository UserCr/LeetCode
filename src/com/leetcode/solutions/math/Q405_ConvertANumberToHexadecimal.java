package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q405_ConvertANumberToHexadecimal implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public String toHex(int num) {
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder stringBuilder = new StringBuilder();
        while (num != 0) {
            stringBuilder.insert(0, map[num & 0xf]);
            num >>>= 4;
        }
        if (stringBuilder.length() == 0) {
            stringBuilder.append(0);
        }
        return stringBuilder.toString();
    }
}
