package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q223_RectangleArea implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。注意溢出。
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return (C - A) * (D - B) + (G - E) * (H - F) - overlap(A, C, E, G) * overlap(B, D, F, H);
    }

    private int overlap(int start1, int end1, int start2, int end2) {
        long res = (long) Math.min(end1, end2) - (long) Math.max(start1, start2);
        return (int) Math.max(res, 0);
    }
}
