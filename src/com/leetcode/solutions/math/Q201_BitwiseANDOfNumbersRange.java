package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q201_BitwiseANDOfNumbersRange implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 假设m和n若干高位相同，则这些高位一定可以保存下来，因为这些高位不可能发生变化。
     * 记相同的高位为xyz，则m一定是xyz0...,n一定是xyz1...这种形式，z右边的0和1不可互换，否则不满足 m <= n。
     * m变到n的过程中，一定会经历xyz1000...0这个数，加上原来z右边的那个0，可以知道xyz000...0就是解。
     * 若m和n没有若干高位相同，同理可知结果为0。
     */
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n) {
            m >>>= 1;
            n >>>= 1;
            count++;
        }
        return m << count;
    }
}
