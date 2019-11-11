package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q279_PerfectSquares implements SolutionInterface {
    @Override
    public void run() {
    }

    interface Algorithm {
        int numSquares(int n);
    }

    static class BFS implements Algorithm {
        //水题。
        @Override
        public int numSquares(int n) {
            Integer[] one = new Integer[(int) Math.floor(Math.sqrt(n))];
            for (int i = 1; i * i <= n; ++i) {
                if (i * i == n) {
                    return 1;
                }
                one[i - 1] = i * i;
            }
            Set<Integer> curRes = new HashSet<>(Arrays.asList(one));
            Set<Integer> generateRes = new HashSet<>();
            for (int k = 1; k <= n; ++k) {
                for (Integer oneValue : one) {
                    for (int kValue : curRes) {
                        if (oneValue + kValue == n) {
                            return k + 1;
                        } else {
                            generateRes.add(oneValue + kValue);
                        }
                    }
                }
                Set<Integer> temp = curRes;
                curRes = generateRes;
                generateRes = temp;
            }
            return -1;
        }
    }

    static class DP implements Algorithm {
        //稍有难度的水题。
        @Override
        public int numSquares(int n) {
            int[] res = new int[n + 1];
            Arrays.fill(res, Integer.MAX_VALUE);
            res[0] = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j * j <= i; ++j) {
                    res[i] = Math.min(res[i], 1 + res[i - j * j]);
                }
            }
            return res[n];
        }
    }

    static class MathMethod implements Algorithm {
        // 专门的数学方法，不用掌握，了解即可。
        // 原理是一个数可以写成最多四个平方数的和，详细说明见：
        // https://en.wikipedia.org/wiki/Lagrange%27s_four-square_theorem
        @Override
        public int numSquares(int n) {
            if (isSquare(n)) {
                return 1;
            }

            // The result is 4 if and only if n can be written in the
            // form of 4^k*(8*m + 7). Please refer to Legendre's three-square theorem.
            // n % 4 == 0
            while ((n & 3) == 0) {
                n >>= 2;
            }

            // n%8 == 7
            if ((n & 7) == 7) {
                return 4;
            }

            // Check whether 2 is the result.
            int sqrt = (int) (Math.sqrt(n));
            for (int i = 1; i <= sqrt; i++) {
                if (isSquare(n - i * i)) {
                    return 2;
                }
            }

            return 3;
        }

        private boolean isSquare(int n) {
            int sqrt = (int) Math.sqrt(n);
            return sqrt * sqrt == n;
        }
    }
}
