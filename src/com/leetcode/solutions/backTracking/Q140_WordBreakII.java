package com.leetcode.solutions.backTracking;

import com.leetcode.solutions.SolutionInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q140_WordBreakII implements SolutionInterface {
    @Override
    public void run() {
    }

    //难度在于剪枝。普通的回溯算法中显然有大量重复计算，可以提前存好结果。
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<String, List<String>> map = new HashMap<>();
        return backTracking(s, wordDict, map);
    }

    private List<String> backTracking(String s, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        List<String> res = new ArrayList<>();
        if (0 == s.length()) {
            res.add("");
            return res;
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> stringList = backTracking(s.substring(word.length()), wordDict, map);
                for (String string : stringList) {
                    res.add(word + (string.isEmpty() ? "" : " ") + string);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
