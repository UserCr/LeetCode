package com.leetcode.solutions.hashtable;

import com.leetcode.solutions.SolutionInterface;

import java.util.HashMap;

public class Q447_NumberOfBoomerangs implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int res = 0;
        for (int i = 0; i < points.length; ++i) {
            hashMap.clear();
            for (int j = 0; j < points.length; ++j) {
                if (i != j) {
                    int distance = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                    res += hashMap.getOrDefault(distance, 0) * 2;
                    hashMap.put(distance, hashMap.getOrDefault(distance, 0) + 1);
                }
            }
        }
        return res;
    }
}
