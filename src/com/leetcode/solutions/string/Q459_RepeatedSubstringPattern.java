package com.leetcode.solutions.string;

import com.leetcode.solutions.SolutionInterface;

public class Q459_RepeatedSubstringPattern implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 该解法有难度，但是很好理解。比较直接的思路是检查长度为1到length/2的各个子串是否相同。
     */
    public boolean repeatedSubstringPattern(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s);
        stringBuilder.append(s);
        stringBuilder.delete(0, 1);
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        return stringBuilder.toString().contains(s);
    }
}
