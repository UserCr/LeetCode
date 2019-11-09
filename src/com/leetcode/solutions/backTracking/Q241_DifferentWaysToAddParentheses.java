package com.leetcode.solutions.backTracking;

import com.leetcode.solutions.SolutionInterface;

import java.util.LinkedList;
import java.util.List;

public class Q241_DifferentWaysToAddParentheses implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 乍看有难度，又要加括号，又要解析字符串，又要计算字符串值什么的，实际是个水题。
     * 括号本质是改变运算优先级，只要让某个运算符两边的等式先计算，就等于给两边的等式加了括号，这样就可以用回溯法递归解题了。
     */
    public List<Integer> diffWaysToCompute(String input) {
        return diffWaysToCompute(input, 0, input.length());
    }

    private List<Integer> diffWaysToCompute(String input, int start, int end) {
        List<Integer> res = new LinkedList<>();
        for (int i = start; i < end; ++i) {
            char c = input.charAt(i);
            if ('+' == c || '-' == c || '*' == c) {
                List<Integer> beforeRes = diffWaysToCompute(input, start, i);
                List<Integer> postRes = diffWaysToCompute(input, i + 1, end);

                for (int before : beforeRes) {
                    for (int post : postRes) {
                        if ('+' == c) {
                            res.add(before + post);
                        } else if ('-' == c) {
                            res.add(before - post);
                        } else {
                            res.add(before * post);
                        }
                    }
                }
            }
        }
        if (0 == res.size()) {
            res.add(Integer.valueOf(input.substring(start, end)));
        }
        return res;
    }
}
