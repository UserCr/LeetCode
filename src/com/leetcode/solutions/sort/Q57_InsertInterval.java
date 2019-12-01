package com.leetcode.solutions.sort;

import com.leetcode.solutions.SolutionInterface;

import java.util.ArrayList;
import java.util.List;

public class Q57_InsertInterval implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newIntervals = new int[intervals.length + 1][2];
        boolean inserted = false;
        for (int i = 0; i < intervals.length; ++i) {
            if (intervals[i][0] < newInterval[0]) {
                newIntervals[i] = intervals[i];
            } else {
                if (inserted) {
                    newIntervals[i + 1] = intervals[i];
                } else {
                    newIntervals[i] = newInterval;
                    i--;
                    inserted = true;
                }
            }
        }
        if (!inserted) {
            newIntervals[intervals.length] = newInterval;
        }
        List<List<Integer>> resList = new ArrayList<>();
        int start = newIntervals[0][0], end = newIntervals[0][1];
        for (int[] interval : newIntervals) {
            if (end < interval[0]) {
                List<Integer> temp = new ArrayList<>();
                temp.add(start);
                temp.add(end);
                resList.add(temp);
                start = interval[0];
                end = interval[1];
            } else {
                end = Math.max(end, interval[1]);
            }
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(start);
        temp.add(end);
        resList.add(temp);

        int[][] res = new int[resList.size()][2];
        for (int i = 0; i < resList.size(); i++) {
            res[i][0] = resList.get(i).get(0);
            res[i][1] = resList.get(i).get(1);
        }
        return res;
    }
}
