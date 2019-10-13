package com.leetcode.solutions.design;

import com.leetcode.solutions.SolutionInterface;

import java.util.HashMap;
import java.util.Map;

public class Q146_LRUCache implements SolutionInterface {
    @Override
    public void run() {
    }

    //可用HashMap+双向链表来实现。
    public class LRUCache {
        private RecentRankList recentRankList = new RecentRankList();
        private int size = 0;
        private int capacity;
        private Map<Integer, Integer> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity);
        }

        public int get(int key) {
            Integer res = map.get(key);
            recentRankList.moveNodeToHead(key);
            return res != null ? res : -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                recentRankList.moveNodeToHead(key);
                map.put(key, value);
            } else {
                if (size < capacity) {
                    size++;
                } else {
                    map.remove(recentRankList.getLast());
                    recentRankList.removeLast();
                }
                map.put(key, value);
                recentRankList.insertToHead(key);
            }
        }

        class RecentRankList {
            private Node head = new Node();
            private Node tail = new Node();

            RecentRankList() {
                head.next = tail;
                tail.prev = head;
            }

            void moveNodeToHead(int nodeValue) {
                Node curNode = head.next;
                while (curNode != tail) {
                    if (curNode.val != nodeValue) {
                        curNode = curNode.next;
                    } else {
                        curNode.prev.next = curNode.next;
                        curNode.next.prev = curNode.prev;
                        curNode.next = head.next;
                        curNode.prev = head;
                        head.next.prev = curNode;
                        head.next = curNode;
                        return;
                    }
                }
            }

            void insertToHead(int value) {
                Node node = new Node();
                node.val = value;
                node.next = head.next;
                node.prev = head;
                head.next.prev = node;
                head.next = node;
            }

            Integer getLast() {
                if (tail.prev == head) {
                    return null;
                } else {
                    return tail.prev.val;
                }
            }

            void removeLast() {
                if (tail.prev != head) {
                    Node toDelete = tail.prev;
                    toDelete.prev.next = tail;
                    tail.prev = toDelete.prev;
                    toDelete.next = null;
                    toDelete.prev = null;
                }
            }

            class Node {
                int val;
                Node next;
                Node prev;
            }
        }
    }
}
