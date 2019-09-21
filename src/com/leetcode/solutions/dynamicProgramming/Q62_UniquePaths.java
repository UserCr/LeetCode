package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

public class Q62_UniquePaths implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int uniquePaths(int m, int n) {
        if (0 == m || 0 == n) {
            return 0;
        }

        int[] lastRes = new int[m], curRes = new int[m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (0 == j) {
                    curRes[j] = 1;
                } else {
                    curRes[j] = curRes[j - 1] + lastRes[j];
                }
            }
            if (n - 1 != i) {
                int[] temp = curRes;
                curRes = lastRes;
                lastRes = temp;
            }
        }
        return curRes[m - 1];
    }
}
