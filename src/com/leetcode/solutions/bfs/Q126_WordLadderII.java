package com.leetcode.solutions.bfs;

import com.leetcode.solutions.SolutionInterface;

import java.util.*;

public class Q126_WordLadderII implements SolutionInterface {
    @Override
    public void run() {
    }

    //BFS题目，有一定难度，主要是每层结点不太容易想到，实际上BFS中第i层的结点就是长度为i的path。
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Queue<List<String>> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        HashSet<String> wordSet = new HashSet<>(wordList);

        visited.add(beginWord);
        queue.add(Arrays.asList(beginWord));
        boolean found = false;

        while (!queue.isEmpty()) {
            int curLevelCount = queue.size();
            Set<String> addStrings = new HashSet<>();
            for (int count = 0; count < curLevelCount; ++count) {
                List<String> path = queue.poll();
                List<String> nextStrings = generateNextStrings(path.get(path.size() - 1), wordSet);

                if (nextStrings.contains(endWord)) {
                    found = true;
                }

                for (String nextString : nextStrings) {
                    if (!visited.contains(nextString)) {
                        ArrayList<String> addedPath = new ArrayList<>(path);
                        addedPath.add(nextString);

                        queue.add(addedPath);
                        addStrings.add(nextString);
                        if (nextString.equals(endWord)) {
                            res.add(addedPath);
                        }
                    }
                }
            }

            if (found) {
                break;
            }

            visited.addAll(addStrings);
        }
        return res;
    }

    private List<String> generateNextStrings(String s, Set<String> wordSet) {
        List<String> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            for (char c = 'a'; c <= 'z'; ++c) {
                if (c == chars[i]) {
                    continue;
                }
                char temp = chars[i];
                chars[i] = c;
                String generateString = String.valueOf(chars);
                if (wordSet.contains(generateString)) {
                    res.add(generateString);
                }
                chars[i] = temp;
            }
        }
        return res;
    }
}
