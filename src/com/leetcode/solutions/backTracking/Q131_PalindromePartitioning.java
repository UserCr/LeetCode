package com.leetcode.solutions.backTracking;

import com.leetcode.solutions.SolutionInterface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q131_PalindromePartitioning implements SolutionInterface {
    @Override
    public void run() {
    }

    //回溯水题。
    public List<List<String>> partition(String s) {
        List<String> curRes = new ArrayList<>();
        List<List<String>> finalRes = new LinkedList<>();
        backTracking(s, 0, curRes, finalRes);
        return finalRes;
    }

    private void backTracking(String s, int startPos, List<String> curRes, List<List<String>> finalRes) {
        if (startPos == s.length()) {
            finalRes.add(new LinkedList<>(curRes));
        } else {
            for (int endPos = startPos; endPos < s.length(); ++endPos) {
                if (isPalindrome(s, startPos, endPos)) {
                    curRes.add(s.substring(startPos, endPos + 1));
                    backTracking(s, endPos + 1, curRes, finalRes);
                    curRes.remove(curRes.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int startPos, int endPos) {
        while (startPos <= endPos && s.charAt(startPos) == s.charAt(endPos)) {
            startPos++;
            endPos--;
        }
        return startPos > endPos;
    }
}
