package com.leetcode.solutions.backTracking;

import com.leetcode.solutions.SolutionInterface;

import java.util.ArrayList;
import java.util.List;

public class Q306_AdditiveNumber implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public boolean isAdditiveNumber(String num) {
        List<String> numbers = new ArrayList<>();
        return isAdditiveNumber(num, 0, numbers);
    }

    public boolean isAdditiveNumber(String num, int start, List<String> numbers) {
        if (start >= num.length()) {
            return isAdditiveNumber(numbers);
        }
        for (int end = start + 1; end <= num.length(); ++end) {
            if (num.charAt(start) == '0' && end > start + 1) {
                break;
            }
            if (numbers.size() >= 2) {
                int length1 = numbers.get(numbers.size() - 1).length();
                int length2 = numbers.get(numbers.size() - 2).length();
                if (end - start < Math.max(length1, length2)) {
                    continue;
                } else if (end - start > Math.max(length1, length2) + 1) {
                    break;
                }
            }
            numbers.add(num.substring(start, end));
            boolean res = isAdditiveNumber(num, end, numbers);
            if (res) {
                return true;
            }
            numbers.remove(numbers.size() - 1);
        }
        return false;
    }

    private boolean isAdditiveNumber(List<String> numbers) {
        if (numbers.size() < 3) {
            return false;
        }
        for (int i = 2; i < numbers.size(); ++i) {
            if (Long.parseLong(numbers.get(i)) != Long.parseLong(numbers.get(i - 1)) + Long.parseLong(numbers.get(i - 2))) {
                return false;
            }
        }
        return true;
    }
}
