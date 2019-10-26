package com.leetcode.solutions.design;

import com.leetcode.solutions.SolutionInterface;

import java.util.Stack;

public class Q232_ImplementQueueUsingStacks implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    static class MyQueue {
        private Stack<Integer> storeStack = new Stack<>();
        private Stack<Integer> popStack = new Stack<>();

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            storeStack.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (popStack.isEmpty()) {
                while (!storeStack.isEmpty()) {
                    popStack.push(storeStack.pop());
                }
            }
            int res = -1;
            if (!popStack.isEmpty()) {
                res = popStack.pop();
            }
            return res;
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (popStack.isEmpty()) {
                while (!storeStack.isEmpty()) {
                    popStack.push(storeStack.pop());
                }
            }
            int res = -1;
            if (!popStack.isEmpty()) {
                res = popStack.peek();
            }
            return res;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return storeStack.isEmpty() && popStack.isEmpty();
        }
    }
}
