package com.leetcode.solutions.stack;

import com.leetcode.solutions.SolutionInterface;

import java.util.Stack;

public class Q84_LargestRectangleInHistogram implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 难度不小。暴力解法很容易想到，遍历每个柱所能形成的最大矩形并取面积最大值。
     * 优化难点在于如何保存每个柱所形成的最大矩形的宽，栈中保存的是一个高度递增的柱下标，那么对于栈中保存的每个柱来说，
     * 最左边小于其高度的柱下标就是它在栈中前一个柱的下标，最右边小于其高度的柱下标只可能是弹栈时所遍历到的下标。
     */
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int height = heights[stack.pop()];
                maxArea = Math.max(maxArea, height * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            maxArea = Math.max(maxArea, height * (heights.length - stack.peek() - 1));
        }
        return maxArea;
    }
}
