package com.leetcode.solutions.stack;

import com.leetcode.solutions.SolutionInterface;

import java.util.Stack;

public class Q20_ValidParentheses implements SolutionInterface {
    @Override
    public void run() {
    }

    //简单题目，但是要注意边界条件。复习时需要关注循环中要判断栈是否为空。
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}' || c == ']' || c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (('}' == c && '{' != top) || (']' == c && '[' != top) || (')' == c && '(' != top)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
