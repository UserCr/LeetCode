package com.leetcode.solutions.design;

import com.leetcode.solutions.SolutionInterface;

import java.util.ArrayList;
import java.util.List;

public class Q155_MinStack implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。经典解法是双栈法。这里用的是另一个思路，入栈时压入两个元素，靠近栈顶的是x，靠近栈底的是min，这样只需要一个栈。
    class MinStack {
        private List<Integer> stack;

        public MinStack() {
            stack = new ArrayList<>();
        }

        public void push(int x) {
            if (stack.isEmpty()) {
                stack.add(x);
                stack.add(x);
            } else {
                stack.add(Math.min(x, stack.get(stack.size() - 2)));
                stack.add(x);
            }
        }

        public void pop() {
            stack.remove(stack.size() - 1);
            stack.remove(stack.size() - 1);
        }

        public int top() {
            return stack.get(stack.size() - 1);
        }

        public int getMin() {
            return stack.get(stack.size() - 2);
        }
    }
}
