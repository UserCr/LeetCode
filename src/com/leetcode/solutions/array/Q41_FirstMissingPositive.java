package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

public class Q41_FirstMissingPositive implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 空间O(n)算法相对简单，只需仔细考虑就会发现大于nums数组个数的正数和负数没必要保存，所以只需要申请一个长度等于nums.length + 1的数组，
     * 将nums中值为i的数放进新数组中第i个位置上，最后遍历新数组就可以轻松求解。
     * 空间O(1)算法比较麻烦，思路十分简单，只要用海豚算法替换元素将使得num[i] == i + 1即可，因为下标和元素不一致，
     * 所以海豚算法要做一些很麻烦的调整。
     */
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            if (0 < nums[i] && nums[i] <= nums.length && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }
        int res = 0;
        while (res < nums.length && nums[res] == res + 1) {
            res++;
        }
        return res + 1;
    }
}
