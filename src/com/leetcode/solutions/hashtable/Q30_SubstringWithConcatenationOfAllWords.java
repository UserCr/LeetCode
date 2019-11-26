package com.leetcode.solutions.hashtable;

import com.leetcode.solutions.SolutionInterface;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q30_SubstringWithConcatenationOfAllWords implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 本题难度主要在于判断子串是否能够由给定单词生成。如果用给定单词生成全部子串集合的话会超时，因为时间复杂度是O(n!)，
     * 因此要换一种思路，看看组成子串的单词集合是否是给定单词的子集，这样就不会超时。
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<>();
        if (0 == words.length || words[0].isEmpty()) {
            return res;
        }

        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            int count = wordsMap.getOrDefault(word, 0);
            wordsMap.put(word, count + 1);
        }

        Map<String, Integer> subMap = new HashMap<>();

        final int length = words.length * words[0].length();
        final int wordLength = words[0].length();

        for (int i = 0; i <= s.length() - length; i++) {
            String subString = s.substring(i, i + length);
            for (int j = 0; j < subString.length(); j += wordLength) {
                String word = subString.substring(j, j + wordLength);
                int count = subMap.getOrDefault(word, 0);
                subMap.put(word, count + 1);
            }
            boolean legal = true;
            for (String subWord : subMap.keySet()) {
                if (subMap.get(subWord) > wordsMap.getOrDefault(subWord, 0)) {
                    legal = false;
                    break;
                }
            }
            subMap.clear();
            if (legal) {
                res.add(i);
            }
        }
        return res;
    }
}
