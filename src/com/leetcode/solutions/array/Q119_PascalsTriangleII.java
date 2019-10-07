package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

import java.util.ArrayList;
import java.util.List;

public class Q119_PascalsTriangleII implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        for (int curRow = 0; curRow <= rowIndex; ++curRow) {
            res.add(1);
            for (int col = curRow - 1; col > 0; --col) {
                res.set(col, res.get(col) + res.get(col - 1));
            }
        }
        return res;
    }
}
