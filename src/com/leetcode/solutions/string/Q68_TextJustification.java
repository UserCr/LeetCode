package com.leetcode.solutions.string;

import com.leetcode.solutions.SolutionInterface;

import java.util.ArrayList;
import java.util.List;

public class Q68_TextJustification implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int wordPos = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (wordPos < words.length) {
            List<String> temp = new ArrayList<>();
            int wordsLength = 0;
            while (wordPos < words.length && wordsLength + words[wordPos].length() <= maxWidth) {
                temp.add(words[wordPos]);
                wordsLength += words[wordPos].length() + 1;
                wordPos++;
            }

            wordsLength -= temp.size();
            int spaceNum = temp.size() == 1 ? maxWidth - wordsLength : (maxWidth - wordsLength) / (temp.size() - 1);
            int stringPos = 0;
            stringBuilder.delete(0, stringBuilder.length());
            while (stringBuilder.length() < maxWidth) {
                stringBuilder.append(temp.get(stringPos));
                if (stringBuilder.length() < maxWidth) {
                    if (wordPos < words.length) {
                        for (int i = 0; i < spaceNum; i++) {
                            stringBuilder.append(' ');
                        }
                        if (temp.size() > 1 && stringPos < (maxWidth - wordsLength) % (temp.size() - 1)) {
                            stringBuilder.append(' ');
                        }
                    } else {
                        stringBuilder.append(' ');
                        while (stringPos == temp.size() - 1 && stringBuilder.length() < maxWidth) {
                            stringBuilder.append(' ');
                        }
                    }
                }
                stringPos++;
            }
            res.add(stringBuilder.toString());
        }
        return res;
    }
}
