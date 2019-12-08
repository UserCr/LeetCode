package com.leetcode.solutions.string;

import com.leetcode.solutions.SolutionInterface;

public class Q482_LicenseKeyFormatting implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public String licenseKeyFormatting(String S, int K) {
        S = S.replaceAll("-", "").toUpperCase();
        StringBuilder stringBuilder = new StringBuilder();
        for (int start = 0; start < S.length(); ) {
            if (0 == start && S.length() % K != 0) {
                stringBuilder.append(S, start, start + S.length() % K);
                start += S.length() % K;
            } else {
                stringBuilder.append(S, start, start + K);
                start += K;
            }
            if (start < S.length()) {
                stringBuilder.append('-');
            }
        }
        return stringBuilder.toString();
    }
}
