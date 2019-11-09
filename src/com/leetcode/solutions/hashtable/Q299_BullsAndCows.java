package com.leetcode.solutions.hashtable;

import com.leetcode.solutions.SolutionInterface;

public class Q299_BullsAndCows implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 水题。用HashMap思路非常简单。用数组记录字符使用情况的思路稍有难度，实际上count数组维护的是非匹配字符的库存情况，
     * secret串负责供给，guess串负责消费。当字符不匹配时，同时出现一个供给和一个消费，供给的字符可以查看对应库存是否为负，
     * 为负说明之前有消费的需求，消费的字符可以查看对应库存是否为正，为正的话说明之前有增加对应库存。
     */
    public String getHint(String secret, String guess) {
        int[] count = new int[10];
        int countBull = 0, countCow = 0;
        for (int i = 0; i < secret.length(); ++i) {
            int sValue = secret.charAt(i) - '0';
            int gValue = guess.charAt(i) - '0';
            if (sValue == gValue) {
                countBull++;
            } else {
                if (count[sValue] < 0) {
                    countCow++;
                }
                if (count[gValue] > 0) {
                    countCow++;
                }
                count[sValue]++;
                count[gValue]--;
            }
        }

        return countBull + "A" + countCow + "B";
    }
}
