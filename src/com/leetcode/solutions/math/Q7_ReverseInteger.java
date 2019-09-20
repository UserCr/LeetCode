package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q7_ReverseInteger implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题，注意溢出。
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int temp = ans * 10 + x % 10;
            if ((temp - x % 10) / 10 != ans) {
                // temp计算过程可能造成溢出，如果逆向计算无法恢复到旧值，说明发生了溢出。
                return 0;
            }
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        return ans;
    }
}
