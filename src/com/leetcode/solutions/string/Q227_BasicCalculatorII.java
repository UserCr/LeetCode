package com.leetcode.solutions.string;

import com.leetcode.solutions.SolutionInterface;

public class Q227_BasicCalculatorII implements SolutionInterface {
    @Override
    public void run() {
    }

    private int curPos = 0;

    //水题，因为题目比较特殊，可以用O(n)算法一次得到结果，不用栈转逆波兰式的方法。
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        int res = nextAddOrSubFactor(s);
        char op = '\0';
        while (curPos < s.length()) {
            if (!Character.isDigit(s.charAt(curPos))) {
                op = s.charAt(curPos++);
            } else {
                int curNum = nextAddOrSubFactor(s);
                res = operate(res, curNum, op);
            }
        }
        return res;
    }

    private int nextAddOrSubFactor(String s) {
        int res = nextInteger(s);
        char op = '\0';
        while (curPos < s.length() && '+' != s.charAt(curPos) && '-' != s.charAt(curPos)) {
            if (!Character.isDigit(s.charAt(curPos))) {
                op = s.charAt(curPos++);
            } else {
                int curNum = nextInteger(s);
                res = operate(res, curNum, op);
            }
        }
        return res;
    }

    private int nextInteger(String s) {
        int res = 0;
        while (curPos < s.length() && Character.isDigit(s.charAt(curPos))) {
            res = res * 10 + s.charAt(curPos++) - '0';
        }
        return res;
    }

    private int operate(int num1, int num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
        }
        return 0;
    }
}
