package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

import java.util.ArrayList;
import java.util.List;

public class Q118_PascalsTriangle implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int row = 1; row <= numRows; ++row) {
            List<Integer> curRow = new ArrayList<>(row);
            for (int col = 0; col < row; ++col) {
                if (0 == col || row - 1 == col) {
                    curRow.add(1);
                } else {
                    curRow.add(res.get(row - 2).get(col - 1) + res.get(row - 2).get(col));
                }
            }
            res.add(curRow);
        }
        return res;
    }
}
