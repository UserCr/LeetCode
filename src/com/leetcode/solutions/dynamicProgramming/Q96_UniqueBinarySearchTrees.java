package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

public class Q96_UniqueBinarySearchTrees implements SolutionInterface {
    @Override
    public void run() {
    }

    //DP水题。二叉树的总种类数=左子树种类数乘以右子树种类数，左子树从0个节点遍历到n-1个节点，然后结果相加。
    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i <= n; ++i) {
            res[i] = 0;
            for (int leftNum = i - 1; leftNum >= 0; --leftNum) {
                int rightNum = i - 1 - leftNum;
                res[i] += (res[leftNum] * res[rightNum]);
            }
        }
        return res[n];
    }
}
