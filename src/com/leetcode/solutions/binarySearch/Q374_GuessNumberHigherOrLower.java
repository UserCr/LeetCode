package com.leetcode.solutions.binarySearch;

import com.leetcode.solutions.SolutionInterface;

public class Q374_GuessNumberHigherOrLower implements SolutionInterface {
    @Override
    public void run() {
    }

    //垃圾水题。
    public int guessNumber(int n) {
        for (long left = 1, right = n; left <= right; ) {
            int mid = (int) ((left + right) / 2);
            if (guess(mid) < 0) {
                right = mid - 1;
            } else if (guess(mid) > 0) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return 0;
    }

    private int guess(int num) {
        int ANSWER = 6;
        return -Integer.compare(num, ANSWER);
    }
}
