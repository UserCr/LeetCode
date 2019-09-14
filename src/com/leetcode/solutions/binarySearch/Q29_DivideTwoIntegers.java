package com.leetcode.solutions.binarySearch;

import com.leetcode.solutions.SolutionInterface;

public class Q29_DivideTwoIntegers implements SolutionInterface {
    @Override
    public void run() {
    }

    public int divide(int dividend, int divisor) {
        //商的绝对值小于等于被除数，因此商的范围是[Integer.MIN_VALUE, -Integer.MIN_VALUE]。该区间内-Integer.MIN_VALUE是无法
        //用int表示的（补码原理），所以商为该数的运算会发生溢出。商为该数的运算只有一种，就是被除数等于-Integer.MIN_VALUE，除数等于-1，
        //也就是说会发生溢出的情形只有这一种，单独处理即可。
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);

        //强制类型转换非常重要，否则取反运算会先发生溢出，再转换为long
        long dividendL = dividend > 0 ? dividend : -((long) dividend);
        long divisorL = divisor > 0 ? divisor : -((long) divisor);

        int res = 0;
        while (dividendL >= divisorL) {
            long multipleDivisor = divisorL, multiple = 1;
            while (dividendL >= (multipleDivisor << 2)) {
                multipleDivisor <<= 2;
                multiple <<= 2;
            }
            res += multiple;
            dividendL -= multipleDivisor;
        }

        if (isNegative) {
            res = -res;
        }

        return res;
    }
}
