package com.leetcode.solutions.stack;

import com.leetcode.solutions.SolutionInterface;

import java.util.HashMap;
import java.util.Stack;

public class Q496_NextGreaterElementI implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 有些难度，主要是用栈维护一个递减序列不太容易想到。
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums2.length);
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.empty() && stack.peek() < num) {
                hashMap.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            res[i] = hashMap.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
