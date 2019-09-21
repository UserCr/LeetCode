package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q60_PermutationSequence implements SolutionInterface {
    interface Algorithm {
        String getPermutation(int n, int k);
    }

    @Override
    public void run() {
    }

    static class MathSolution implements Algorithm {
        static class Set {
            private int size;
            //used[0]与题意无关，废弃不用
            private boolean[] used;

            Set(int size) {
                this.size = size;
                used = new boolean[size + 1];
            }

            void use(int i) {
                if (0 < i && i <= size) {
                    used[i] = true;
                }
            }

            int getIthUnused(int i) {
                for (int pos = 1, count = 0; pos < used.length; ++pos) {
                    if (!used[pos]) {
                        count++;
                    }
                    if (count == i) {
                        return pos;
                    }
                }
                return 0;
            }
        }

        /**
         * 水题。
         * 因为排列组合是按照字典序排序的，所以可以利用除法或取模运算直接算出某一位的结果。
         * 比较费时间的运算是在每次循环里定位剩下未使用的数中第i大的数，这是个O(n)操作，因此整个算法时间复杂度是O(n^2)。
         */
        @Override
        public String getPermutation(int n, int k) {
            final int MAX_N = 9;
            Set used = new Set(n);
            int[] factorial = new int[MAX_N + 1];
            for (int i = 0; i <= MAX_N; i++) {
                if (0 == i) {
                    factorial[i] = 1;
                } else {
                    factorial[i] = i * factorial[i - 1];
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = n; i > 0; i--) {
                int curNumberIndex = (int) Math.ceil((double) k / factorial[i - 1]);
                if (1 == i) {
                    curNumberIndex = 1;
                }
                stringBuilder.append(used.getIthUnused(curNumberIndex));
                used.use(used.getIthUnused(curNumberIndex));
                k -= ((curNumberIndex - 1) * factorial[i - 1]);
            }
            return stringBuilder.toString();
        }
    }

    static class BackTrackingSolution implements Algorithm {
        private StringBuilder stringBuilder = new StringBuilder();
        private int curK = 0;
        private String res = null;

        /**
         * 回溯水题，时间复杂度O(n!)。
         */
        @Override
        public String getPermutation(int n, int k) {
            boolean[] used = new boolean[n + 1];
            backTracking(used, n, k);
            return res;
        }

        private void backTracking(boolean[] used, int leftNumberCount, int k) {
            if (0 == leftNumberCount) {
                curK++;
                if (curK == k) {
                    res = stringBuilder.toString();
                }
            }
            for (int i = 1, usedNumber = 0; i < used.length && usedNumber <= leftNumberCount; ++i) {
                if (!used[i]) {
                    usedNumber++;
                    stringBuilder.append(i);
                    used[i] = true;
                    backTracking(used, leftNumberCount - 1, k);
                    used[i] = false;
                    stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
                }
            }
        }
    }
}
