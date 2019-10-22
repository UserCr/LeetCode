package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

import java.util.HashSet;
import java.util.Set;

public class Q202_HappyNumber implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            if (set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
                n = sum;
            }
        }
        return true;
    }
}
