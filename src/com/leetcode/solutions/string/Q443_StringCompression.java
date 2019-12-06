package com.leetcode.solutions.string;

import com.leetcode.solutions.SolutionInterface;

public class Q443_StringCompression implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int compress(char[] chars) {
        int slow = 0;
        for (int fast = 0; fast < chars.length; ) {
            char curChar = chars[fast];
            int count = 0;
            while (fast < chars.length && chars[fast] == curChar) {
                fast++;
                count++;
            }
            chars[slow++] = curChar;
            if (count > 1) {
                char[] numChars = String.valueOf(count).toCharArray();
                for (char numChar : numChars) {
                    chars[slow++] = numChar;
                }
            }
        }
        return slow;
    }
}
