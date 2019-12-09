package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q319_BulbSwitcher implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 智力题。只有约数中含有k的数会在第k轮翻转。设某个数为m，当翻转次数大于等于m时，数m的所有约数都会遍历一次，如果m的约数个数为偶数个，
     * 那么m并没有发生翻转。实际上，除了完全平方数以外，所有数的约数都是成对出现，所以问题转化成了寻找小于等于n的完全平方数的个数，
     * 直接开方求解。
     */
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
