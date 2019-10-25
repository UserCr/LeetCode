package com.leetcode.solutions.design;

import com.leetcode.solutions.SolutionInterface;

import java.util.LinkedList;
import java.util.Queue;

public class Q225_ImplementStackUsingQueues implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    static class MyStack {
        private Queue<Integer> storeQueue = new LinkedList<>();
        private Queue<Integer> popQueue = new LinkedList<>();

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            storeQueue.add(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            int res = -1;
            if (!storeQueue.isEmpty()) {
                while (storeQueue.size() > 1) {
                    popQueue.add(storeQueue.poll());
                }
                res = storeQueue.poll();
                swapQueue();
            }
            return res;
        }

        /**
         * Get the top element.
         */
        public int top() {
            int res = -1;
            if (!storeQueue.isEmpty()) {
                while (storeQueue.size() > 1) {
                    popQueue.add(storeQueue.poll());
                }
                res = storeQueue.peek();
                popQueue.add(storeQueue.poll());
                swapQueue();
            }
            return res;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return storeQueue.size() == 0;
        }

        private void swapQueue() {
            Queue<Integer> temp = storeQueue;
            storeQueue = popQueue;
            popQueue = temp;
        }
    }
}
