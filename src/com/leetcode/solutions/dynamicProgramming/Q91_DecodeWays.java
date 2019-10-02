package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

public class Q91_DecodeWays implements SolutionInterface {
    @Override
    public void run() {
    }

    //有些麻烦的DP水题。需要注意关于字符0的处理在题目中没有说明，需要反复测试出逻辑:0无法单独作为一个字符拆出，只能出现在10或20中。
    public int numDecodings(String s) {
        int numMiss1Char = s.charAt(0) == '0' ? 0 : 1;
        if (1 == s.length()) {
            return numMiss1Char;
        }
        for (int i = 1, numMiss2Char = is2BitCode(s, 0, 1) ? 1 : 0; i < s.length(); ++i) {
            int curNum = numMiss1Char;
            if (s.charAt(i) == '0') {
                curNum = 0;
            }
            if (is2BitCode(s, i - 1, i)) {
                curNum += numMiss2Char;
            }
            numMiss2Char = numMiss1Char;
            numMiss1Char = curNum;
        }
        return numMiss1Char;
    }

    private boolean is2BitCode(String s, int leftPos, int rightPos) {
        return s.charAt(leftPos) == '1' || (s.charAt(leftPos) == '2' && s.charAt(rightPos) <= '6');
    }
}
