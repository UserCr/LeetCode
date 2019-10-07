package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

import java.util.List;

public class Q120_Triangle implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。要注意输入为空的情况，不过因为题目没有对输入为空的情况做特别的输出约定，所以可以不用考虑。
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] tempRes = new int[triangle.size()];
        int min = Integer.MAX_VALUE;
        for (int curRow = 0; curRow < triangle.size(); ++curRow) {
            min = Integer.MAX_VALUE;
            if (0 == curRow) {
                tempRes[0] = triangle.get(curRow).get(0);
                min = Math.min(tempRes[0], min);
            } else {
                for (int col = curRow; col >= 0; --col) {
                    if (curRow == col) {
                        tempRes[col] = triangle.get(curRow).get(col) + tempRes[col - 1];
                    } else if (0 == col) {
                        tempRes[col] = triangle.get(curRow).get(col) + tempRes[col];
                    } else {
                        tempRes[col] = triangle.get(curRow).get(col) + Math.min(tempRes[col], tempRes[col - 1]);
                    }
                    min = Math.min(tempRes[col], min);
                }
            }
        }
        return min;
    }
}
