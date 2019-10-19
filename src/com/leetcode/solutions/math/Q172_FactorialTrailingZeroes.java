package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q172_FactorialTrailingZeroes implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 阶乘有多少个零，取决于乘数里有多少个10，而10可以分解成2和5的乘积，所以阶乘有多少个零取决于乘数里有多少个2和5。
     * 因为2的个数远远多于5的个数，所以只需要关注5的数量。
     * 5 * 1，5 * 2，5 * 3，5 * 4这样的数只能提供一个5，25 * 1， 25 * 2， 25 * 3这样的数可以提供两个5，以此类推。
     * n / 5 结果就是可以提供一个5的数（包含可以提供多个5的数）的个数，
     * n / 25 就是可以提供两个5的数（包含可以提供更多5的数）的个数，以此类推，n / 5 + n / 25 + ... + n / 5 ^ m
     * 就是最终解。这里需要额外解释一下为什么25可以提供两个解，却只加一次的问题。因为计算 n / 5 的时候已经将25的一个5
     * 计算进了最终解，等到计算 n / 25 时，只需要再计算一次就可以了，n / 5 ^ m只加一次也是同样的道理。
     */
    public int trailingZeroes(int n) {
        int count5 = 0;
        while (n > 0) {
            count5 += (n / 5);
            n /= 5;
        }
        return count5;
    }
}
