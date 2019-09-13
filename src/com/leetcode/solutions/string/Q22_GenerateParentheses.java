package com.leetcode.solutions.string;

import com.leetcode.solutions.SolutionInterface;

import java.util.ArrayList;
import java.util.List;

public class Q22_GenerateParentheses implements SolutionInterface {
    @Override
    public void run() {
    }

    //DP状态转移方程有些难度。f（n）不可由f（n-1）推导得出，而是要分成左右两边逐渐遍历再加括号得到。
    //加括号时要注意不能直接加（），而是对left或right加括号，否则会少解。因为有的解是直接加一个括号（比如()->()()），
    //所以left或right应当有空串以保证这类解可以生成。
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (0 == n) {
            res.add("");
        } else {
            for (int i = 0; i < n; i++) {
                for (String left : generateParenthesis(i)) {
                    for (String right : generateParenthesis(n - i - 1)) {
                        // (left)right 和 left(right)等价，也就是说给right加括号也可以。
                        res.add("(" + left + ")" + right);
                    }
                }
            }
        }
        return res;
    }
}
