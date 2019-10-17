package com.leetcode.solutions.string;

import com.leetcode.solutions.SolutionInterface;

public class Q165_CompareVersionNumbers implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int compareVersion(String version1, String version2) {
        String[] version1NumberStrings = version1.split("\\.");
        String[] version2NumberStrings = version2.split("\\.");

        int pos = 0;
        while (pos < version1NumberStrings.length && pos < version2NumberStrings.length) {
            int number1 = Integer.parseInt(version1NumberStrings[pos]);
            int number2 = Integer.parseInt(version2NumberStrings[pos]);
            if (number1 > number2) {
                return 1;
            } else if (number1 < number2) {
                return -1;
            }
            pos++;
        }
        while (pos < version1NumberStrings.length) {
            if (Integer.parseInt(version1NumberStrings[pos]) > 0) {
                return 1;
            }
            pos++;
        }
        while (pos < version2NumberStrings.length) {
            if (Integer.parseInt(version2NumberStrings[pos]) > 0) {
                return -1;
            }
            pos++;
        }
        return 0;
    }
}
