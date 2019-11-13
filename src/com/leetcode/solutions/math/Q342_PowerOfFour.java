package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q342_PowerOfFour implements SolutionInterface {
    @Override
    public void run() {
    }

    //无聊的水题。要点是奇数比特位有且只能有一个1，其他位全部为0。
    public boolean isPowerOfFour(int num) {
        //(num & -num)是只保留最靠右且为1的比特位。
        return num > 0 && (0xAAAAAAAA & num) == 0 && (num - (num & -num)) == 0;
    }
}
