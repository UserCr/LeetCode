package com.leetcode.solutions.hashtable;

import com.leetcode.solutions.SolutionInterface;

import java.util.*;

public class Q500_KeyboardRow implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public String[] findWords(String[] words) {
        List<String> resList = new ArrayList<>();

        Set<Character> set1 = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        Set<Character> set2 = new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        Set<Character> set3 = new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));
        List<Set<Character>> sets = new ArrayList<>(Arrays.asList(set1, set2, set3));

        for (String word : words) {
            String newWord = word.toLowerCase().trim();
            if (!newWord.isEmpty()) {
                int setIndex = 0;
                while (setIndex < sets.size()) {
                    if (sets.get(setIndex).contains(newWord.charAt(0))) {
                        break;
                    }
                    setIndex++;
                }
                boolean isRes = true;
                for (char c : newWord.toCharArray()) {
                    if (!sets.get(setIndex).contains(c)) {
                        isRes = false;
                        break;
                    }
                }
                if (isRes) {
                    resList.add(word);
                }
            }
        }

        String[] res = new String[resList.size()];
        for (int i = 0; i < res.length; ++i) {
            res[i] = resList.get(i);
        }

        return res;
    }
}
