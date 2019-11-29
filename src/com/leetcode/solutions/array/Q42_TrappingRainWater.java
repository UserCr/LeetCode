package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

public class Q42_TrappingRainWater implements SolutionInterface {
    @Override
    public void run() {
    }

    /**
     * 难度不小。每个位置能存的水等于左右两边最高峰较矮的那个高度减去当前位置的高度，最小为零。用代码表示就是：
     * r[i] = min(max[:i+1], max[i:]) - height[i]
     * result = sum(r[i])
     * 暴力实现此算法时间复杂度是O(n2)，实际可以用两个数组分别存储某个位置左右最高峰的高度，这样时间复杂度降为O(n)，空间复杂度升为O(n)。
     * 接下来的工作是将空间复杂度降为O(1)，也就是双指针法，当左右指针确定时，左右最高峰的相对关系也就确定了。
     * 因为当height[left] < height[right]时，leftMax <= height[left] < height[right]，此时两边最高峰最小值显然是leftMax，
     * 右边同理。
     */
    public int trap(int[] height) {
        if (null == height || 0 == height.length) {
            return 0;
        }

        int res = 0;
        for (int left = 0, right = height.length - 1, leftMax = height[0], rightMax = height[height.length - 1];
             left < right; ) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    //这种情况的(leftMax - height[left]) < 0，因为最少能存的水是0，所以直接略过，更新最大值即可。
                    leftMax = height[left];
                } else {
                    res += (leftMax - height[left]);
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    res += (rightMax - height[right]);
                }
                right--;
            }
        }
        return res;
    }
}
