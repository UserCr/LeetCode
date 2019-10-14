package com.leetcode.solutions.stack;

import com.leetcode.solutions.SolutionInterface;

import java.util.Stack;

public class Q150_EvaluateReversePolishNotation implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 + num2);
            } else if ("-".equals(token)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 - num2);
            } else if ("*".equals(token)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 * num2);
            } else if ("/".equals(token)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 / num2);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
