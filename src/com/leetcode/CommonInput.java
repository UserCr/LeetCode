package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommonInput {
    private static String preProcessArrayString(String s) {
        s = s.trim();
        if (s.charAt(0) != '[' || s.charAt(s.length() - 1) != ']') {
            throw new IllegalArgumentException();
        }
        s = s.substring(1, s.length() - 1);
        return s;
    }

    public static int[] toIntArray(String s) {
        s = preProcessArrayString(s);
        String[] strings = s.split(",");
        int[] array = new int[strings.length];
        for (int i = 0; i < strings.length; ++i) {
            array[i] = Integer.valueOf(strings[i]);
        }
        return array;
    }

    public static List<Integer> toIntList(String s) {
        return Arrays.stream(toIntArray(s)).boxed().collect(Collectors.toList());
    }

    public static int[][] toInt2Array(String s) {
        s = preProcessArrayString(s);
        String[] arrayStrings = new String[s.length()];
        int length = 0;
        for (int i = 0, j = 0; i < s.length() && j < s.length(); ++j, i = j) {
            while (i < s.length() && s.charAt(i) != '[') {
                ++i;
            }
            while (j < s.length() && s.charAt(j) != ']') {
                ++j;
            }
            if (s.charAt(i) == '[' && s.charAt(j) == ']') {
                arrayStrings[length++] = s.substring(i, j + 1);
            }
        }
        arrayStrings = Arrays.stream(arrayStrings).limit(length).toArray(String[]::new);
        int[][] res = new int[arrayStrings.length][];
        for (int i = 0; i < arrayStrings.length; ++i) {
            res[i] = toIntArray(arrayStrings[i]);
        }
        return res;
    }

    public static List<List<Integer>> toInt2List(String s) {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] array : toInt2Array(s)) {
            res.add(Arrays.stream(array).boxed().collect(Collectors.toList()));
        }
        return res;
    }
}
