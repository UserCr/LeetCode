package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

import java.util.Arrays;

public class Q43_MultiplyStrings implements SolutionInterface {
    @Override
    public void run() {
    }

    //稍有难度，难点在于要判断出被乘数第i位和乘数第j位相乘后结果存在积中的哪位。
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int[] intRes = new int[num1.length() + num2.length()];
        Arrays.fill(intRes, 0);
        for (int i = num1.length() - 1; i >= 0; --i) {
            for (int j = num2.length() - 1; j >= 0; --j) {
                //假设数组下标是从1开始，根据竖式乘法规则，intRes位置应该是i+j。因为数组下标是从0开始的，所以位置应该是(i+1 +j+1 -1)。
                int tempRes = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + intRes[i + j + 1];
                intRes[i + j + 1] = tempRes % 10;
                //intRes[i+j]可能会大于10，但因为i和j都是在缩小的，所以可以将intRes[i+j]的进位问题延迟到下轮循环中，与乘积加法合并处理。
                intRes[i + j] += (tempRes / 10);
            }
        }
        int firstPos;
        for (firstPos = 0; firstPos < intRes.length; ++firstPos) {
            if (intRes[firstPos] != 0) {
                break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (firstPos < intRes.length) {
            stringBuilder.append(intRes[firstPos++]);
        }
        return stringBuilder.toString();
    }
}
