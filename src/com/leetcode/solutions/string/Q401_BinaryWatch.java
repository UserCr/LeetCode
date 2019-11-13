package com.leetcode.solutions.string;

import com.leetcode.solutions.SolutionInterface;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q401_BinaryWatch implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public List<String> readBinaryWatch(int num) {
        List<String> res = new LinkedList<>();
        for (int hourNum = 0; hourNum <= num; ++hourNum) {
            List<String> hours = generateHourString(hourNum);
            List<String> minutes = generateMinuteString(num - hourNum);
            for (String hour : hours) {
                for (String minute : minutes) {
                    res.add(hour + ":" + minute);
                }
            }
        }
        return res;
    }

    private List<String> generateHourString(int num) {
        List<String> hour = new LinkedList<>();
        switch (num) {
            case 0:
                hour.add("0");
                break;
            case 1:
                hour.addAll(Arrays.asList("1", "2", "4", "8"));
                break;
            case 2:
                hour.addAll(Arrays.asList("3", "5", "6", "9", "10"));
                break;
            case 3:
                hour.addAll(Arrays.asList("7", "11"));
                break;
        }
        return hour;
    }

    private List<String> generateMinuteString(int num) {
        List<String> minutes = new LinkedList<>();
        for (int minute = 0; minute < 60; ++minute) {
            if (num == countOneBit(minute)) {
                if (minute < 10) {
                    minutes.add("0" + minute);
                } else {
                    minutes.add(String.valueOf(minute));
                }
            }
        }
        return minutes;
    }

    private int countOneBit(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) != 0) {
                count++;
            }
            num >>= 1;
        }
        return count;
    }
}
