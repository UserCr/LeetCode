package com.leetcode.solutions.backTracking;

import com.leetcode.solutions.SolutionInterface;

import java.util.ArrayList;
import java.util.List;

public class Q93_RestoreIPAddresses implements SolutionInterface {
    @Override
    public void run() {
    }

    //回溯水题。
    public List<String> restoreIpAddresses(String s) {
        List<String> curRes = new ArrayList<>();
        List<String> finalRes = new ArrayList<>();
        backTracking(s, 0, 4, curRes, finalRes);
        return finalRes;
    }

    private void backTracking(String s, int startPos, int leftPart, List<String> curRes, List<String> finalRes) {
        if (0 == leftPart && startPos == s.length()) {
            finalRes.add(String.join(".", curRes));
        } else if (leftPart > 0) {
            for (int rightPos = startPos; rightPos < s.length() && rightPos < startPos + 3; ++rightPos) {
                if (isValid(s, startPos, rightPos + 1)) {
                    curRes.add(s.substring(startPos, rightPos + 1));
                    backTracking(s, rightPos + 1, leftPart - 1, curRes, finalRes);
                    curRes.remove(curRes.size() - 1);
                }
            }
        }
    }

    private boolean isValid(String s, int i, int j) {
        if (s.isEmpty()) {
            return false;
        }
        int value = Integer.parseInt(s.substring(i, j));
        if (0 <= value && value < 10) {
            return j - i == 1;
        } else if (10 <= value && value < 100) {
            return j - i == 2;
        } else if (100 <= value && value < 256) {
            return j - i == 3;
        } else {
            return false;
        }
    }
}
