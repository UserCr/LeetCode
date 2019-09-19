package com.leetcode.solutions.string;

import com.leetcode.solutions.SolutionInterface;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Q49_GroupAnagrams implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String keyString = String.valueOf(chars);
            if (!hashMap.containsKey(keyString)) {
                hashMap.put(keyString, new LinkedList<>());
            }
            hashMap.get(keyString).add(s);
        }
        for (String key : hashMap.keySet()) {
            res.add(hashMap.get(key));
        }
        return res;
    }
}
