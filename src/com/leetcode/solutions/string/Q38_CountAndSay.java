package com.leetcode.solutions.string;

import com.leetcode.solutions.SolutionInterface;

public class Q38_CountAndSay implements SolutionInterface {
    @Override
    public void run() {
    }

    //双缓冲水题。
    public String countAndSay(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        String res = "1";
        for (int i = 2; i <= n; ++i) {
            for (int readPos = 0; readPos < res.length(); ) {
                char c = res.charAt(readPos);
                int count = 0;
                while (readPos < res.length() && res.charAt(readPos) == c) {
                    readPos++;
                    count++;
                }
                stringBuilder.append(count);
                stringBuilder.append(c);
            }
            res = stringBuilder.toString();
            stringBuilder.delete(0, res.length());
        }
        return res;
    }
}
