package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

import java.util.HashMap;
import java.util.Map;

public class Q166_FractionToRecurringDecimal implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。难点在于corner case，注意负数和 1/6 = 0.1(6) 这种从某位才开始循环的情况，还有每次都会出现的负最大取相反数会溢出的问题。
    public String fractionToDecimal(int numerator, int denominator) {
        if (0 == denominator) {
            return null;
        }

        boolean isNegative = numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0;

        String intPart = String.valueOf(Math.abs((long) numerator / (long) denominator));
        if (isNegative) {
            intPart = "-" + intPart;
        }

        if (0 == numerator % denominator) {
            return intPart;
        }

        long curNumerator = numerator % denominator;
        StringBuilder stringBuilder = new StringBuilder();
        Map<Long, Integer> repeatNumber = new HashMap<>();
        while (curNumerator != 0 && !repeatNumber.containsKey(curNumerator)) {
            repeatNumber.put(curNumerator, stringBuilder.length());
            stringBuilder.append(Math.abs(curNumerator * 10 / (long) denominator));
            curNumerator = curNumerator * 10 % (long) denominator;
        }

        if (curNumerator != 0) {
            stringBuilder.insert(repeatNumber.get(curNumerator), "(");
            stringBuilder.append(")");
        }
        return intPart + "." + stringBuilder.toString();
    }
}
