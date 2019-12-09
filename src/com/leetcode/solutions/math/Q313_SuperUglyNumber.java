package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q313_SuperUglyNumber implements SolutionInterface {
    @Override
    public void run() {
    }

    //思路和UglyNumberII相近，水题。
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        int[] primeIndex = new int[primes.length];
        res[0] = 1;
        for (int i = 1; i < n; ++i) {
            int uglyNumber = primes[0] * res[primeIndex[0]];
            for (int j = 1; j < primeIndex.length; ++j) {
                if (primes[j] * res[primeIndex[j]] < uglyNumber) {
                    uglyNumber = primes[j] * res[primeIndex[j]];
                }
            }
            res[i] = uglyNumber;
            for (int j = 0; j < primes.length; ++j) {
                if (primes[j] * res[primeIndex[j]] == uglyNumber) {
                    primeIndex[j]++;
                }
            }
        }
        return res[n - 1];
    }
}
