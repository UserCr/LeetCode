package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

public class Q274_H_Index implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。SortedMap方法很容易想到。由题意可知 h <= N，所以可以自己实现Map提高效率。
    public int hIndex(int[] citations) {
        final int N = citations.length;
        int[] count = new int[citations.length + 1];
        for (int citation : citations) {
            if (citation > N) {
                count[N]++;
            } else {
                count[citation]++;
            }
        }
        int sum = 0;
        for (int i = N; i >= 0; i--) {
            sum += count[i];
            //引用数等于i的数既可以在统计h的一组，也可以在统计N-h的一组，所以sum >= i而不是sum == i
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
}
