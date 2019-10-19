package com.leetcode.solutions.sort;

import com.leetcode.solutions.SolutionInterface;

import java.util.Arrays;

public class Q179_LargestNumber implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。注意可以用int拼出两个值比较大小，不用转成字符串。
    public String largestNumber(int[] nums) {
        Integer[] numbers = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = nums[i];
        }

        Arrays.sort(numbers, (o1, o2) -> {
            if (o1 == 0) {
                return 1;
            } else if (o2 == 0) {
                return -1;
            }

            int x = o1;
            for (int i = o2; i > 0; i /= 10) {
                x *= 10;
            }
            x += o2;

            int y = o2;
            for (int i = o1; i > 0; i /= 10) {
                y *= 10;
            }
            y += o1;

            return y - x;
        });

        if (0 == numbers[0]) {
            return "0";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int num : numbers) {
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }
}
