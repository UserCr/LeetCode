package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q50_Pow_x_n implements SolutionInterface {
    @Override
    public void run() {
    }

    //注意corner case。分治二分递归也可以做。
    public double myPow(double x, int n) {
        if (0 == n) {
            return 1;
        } else if (Integer.MIN_VALUE == n) {
            if (1 == x || -1 == x) {
                return 1;
            } else {
                return 0;
            }
        }

        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n = -n;
        }

        double res = indexPositivePow(x, n);

        if (isNegative) {
            return 1 / res;
        } else {
            return res;
        }
    }

    private double indexPositivePow(double x, int n) {
        final int N_BIT_WIDTH = 32;
        //powRes[i] = x ^ (2 ^ i)
        double[] powRes = new double[N_BIT_WIDTH];
        int[] powNumber = new int[N_BIT_WIDTH];
        powRes[0] = x;
        powNumber[0] = 1;

        for (int i = 1; i < N_BIT_WIDTH; ++i) {
            double tempPowRes = powRes[i - 1] * powRes[i - 1];
            int tempPowNumber = powNumber[i - 1] * 2;
            if (tempPowNumber > n || tempPowNumber <= 0) {
                break;
            } else {
                powRes[i] = tempPowRes;
                powNumber[i] = tempPowNumber;
            }
        }

        double res = 1;
        for (int i = powNumber.length - 1; i >= 0; i--) {
            if (0 != powNumber[i] && powNumber[i] <= n) {
                res *= powRes[i];
                n -= powNumber[i];
            }
        }
        return res;
    }
}
