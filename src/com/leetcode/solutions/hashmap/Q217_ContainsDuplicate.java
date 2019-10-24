package com.leetcode.solutions.hashmap;

import com.leetcode.solutions.SolutionInterface;

import java.util.HashSet;
import java.util.Set;

public class Q217_ContainsDuplicate implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}
