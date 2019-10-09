package com.leetcode.solutions.bfs;

import com.leetcode.solutions.SolutionInterface;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q127_WordLadder implements SolutionInterface {
    @Override
    public void run() {
    }

    private Set<String> visited = new HashSet<>();

    //水题。注意BFS双端队列是一个技巧。
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        visited.add(endWord);
        int beginStep = 1, endStep = 1;
        while (beginStep + endStep <= wordList.size() + 1) {
            if (isReachOrStepTowardAnotherEnd(beginSet, endSet, wordList)) {
                return beginStep + endStep;
            }
            beginStep++;

            if (isReachOrStepTowardAnotherEnd(endSet, beginSet, wordList)) {
                return beginStep + endStep;
            }
            endStep++;
        }
        return 0;
    }

    private boolean isReachOrStepTowardAnotherEnd(Set<String> moveSet, Set<String> targetSet, List<String> wordList) {
        Set<String> temp = new HashSet<>();
        for (String moveString : moveSet) {
            for (String word : wordList) {
                if (twoStringDifferentOneChar(moveString, word)) {
                    if (targetSet.contains(word)) {
                        return true;
                    } else if (!visited.contains(word)) {
                        temp.add(word);
                        visited.add(word);
                    }
                }
            }
        }
        moveSet.clear();
        moveSet.addAll(temp);
        return false;
    }

    private boolean twoStringDifferentOneChar(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1;
    }
}
