package com.leetcode.solutions.string;

import com.leetcode.solutions.SolutionInterface;

public class Q318_MaximumProductOfWordLengths implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int maxProduct(String[] words) {
        if (null == words || 0 == words.length) {
            return 0;
        }
        int[] values = new int[words.length];
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            for (char c : word.toCharArray()) {
                values[i] |= (1 << (c - 'a'));
            }
        }
        int res = 0;
        for (int i = 0; i < values.length; ++i) {
            for (int j = 0; j < values.length; ++j) {
                if ((values[i] & values[j]) == 0 && words[i].length() * words[j].length() > res) {
                    res = words[i].length() * words[j].length();
                }
            }
        }
        return res;
    }
}
