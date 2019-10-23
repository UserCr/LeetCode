package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

import java.util.Arrays;

public class Q204_CountPrimes implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 优化后的筛法，优化点有一定难度。
     */
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        //count = 1，这个1代表的是素数2。
        int count = 1;
        //所有偶数都不可能是素数，所以只检查奇数。
        for (int i = 3; i < n; i += 2) {
            if (isPrime[i]) {
                /*  j从 i * i开始是因为比i小的素数的倍数已经检查过了。比如i = 7，3 * 7和5 * 7 这两个数
                    已经在i = 3 和 i = 5 时被检查过了，没有必要再检查一次，直接从 i * i 开始就行。
                    注意j必须是long，否则i * i可能会溢出。
                    因为偶数不可能为素数，所以j一定是i的奇数倍，更新j时要加两个i。
                 */
                for (long j = (long) i * i; j < n; j += (2 * i)) {
                    isPrime[(int) j] = false;
                }
                count++;
            }
        }
        return count;
    }
}
