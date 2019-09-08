package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

public class Q11_ContainerWithMostWater implements SolutionInterface {
    @Override
    public void run() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    //双指针法。难点在于寻找初始状态，找到初始状态后就是简单的剪枝搜索。
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxValue = Math.min(height[i], height[j]) * (j - i);
        while (i < j) {
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
            int value = Math.min(height[i], height[j]) * (j - i);
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }
}
