package com.leetcode.solutions.hashtable;

import com.leetcode.solutions.SolutionInterface;

import java.util.*;

public class Q187_RepeatedDNASequences implements SolutionInterface {
    interface Algorithm {
        List<String> findRepeatedDnaSequences(String s);
    }

    @Override
    public void run() {
    }

    static class Straightforward implements Algorithm {
        //水题。
        @Override
        public List<String> findRepeatedDnaSequences(String s) {
            final int SUBSTRING_LENGTH = 10;
            List<String> res = new ArrayList<>();
            Map<String, Integer> hashMap = new HashMap<>();

            for (int i = 0; i <= s.length() - SUBSTRING_LENGTH; ++i) {
                String subString = s.substring(i, i + SUBSTRING_LENGTH);
                if (hashMap.containsKey(subString)) {
                    hashMap.put(subString, hashMap.get(subString) + 1);
                } else {
                    hashMap.put(subString, 1);
                }
            }

            for (String key : hashMap.keySet()) {
                if (hashMap.get(key) > 1) {
                    res.add(key);
                }
            }

            return res;
        }
    }

    static class CodeSubstring implements Algorithm {
        //给字符编码加快hash速度。不过因为结果里必须出现子串，所以没有办法避免subString操作，时间复杂度还是O(n^2)。
        @Override
        public List<String> findRepeatedDnaSequences(String s) {
            final int SUBSTRING_LENGTH = 10;
            Set<Integer> seen = new HashSet<>();
            Set<String> resSet = new HashSet<>();
            for (int i = 0; i <= s.length() - SUBSTRING_LENGTH; ++i) {
                int code = codeString(s, i, i + SUBSTRING_LENGTH);
                if (seen.contains(code)) {
                    resSet.add(s.substring(i, i + SUBSTRING_LENGTH));
                } else {
                    seen.add(code);
                }
            }

            return new ArrayList<>(resSet);
        }

        private int codeString(String s, int start, int end) {
            int res = 0;
            while (start < end) {
                int code = 0;
                switch (s.charAt(start)) {
                    case 'C':
                        code = 1;
                        break;
                    case 'G':
                        code = 2;
                        break;
                    case 'T':
                        code = 3;
                        break;
                }
                res = (res << 2) + code;
                start++;
            }
            return res;
        }
    }
}
