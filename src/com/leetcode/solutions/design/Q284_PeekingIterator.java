package com.leetcode.solutions.design;

import com.leetcode.solutions.SolutionInterface;

import java.util.Iterator;

public class Q284_PeekingIterator implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    static class PeekingIterator implements Iterator<Integer> {
        private Iterator<Integer> iterator;
        private boolean peeked = false;
        private Integer peekValue;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (!peeked) {
                peekValue = iterator.next();
                peeked = true;
            }
            return peekValue;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (peeked) {
                peeked = false;
                return peekValue;
            } else {
                return iterator.next();
            }
        }

        @Override
        public boolean hasNext() {
            if (peeked) {
                return true;
            } else {
                return iterator.hasNext();
            }
        }
    }
}
