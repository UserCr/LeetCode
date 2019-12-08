package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q492_ConstructTheRectangle implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int[] constructRectangle(int area) {
        int[] res = new int[2];
        for (int curW = (int) Math.sqrt(area) + 1; curW > 0; --curW) {
            if (area % curW == 0) {
                res[1] = Math.min(curW, area / curW);
                res[0] = Math.max(curW, area / curW);
                break;
            }
        }
        return res;
    }
}
