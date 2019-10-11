package com.leetcode.solutions.linkedlist;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.list.Node;

import java.util.HashMap;
import java.util.Map;

public class Q138_CopyListWithRandomPointer implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public Node copyRandomList(Node head) {
        Map<Node, Node> srcToCopyMap = new HashMap<>();
        for (Node curNode = head; curNode != null; curNode = curNode.next) {
            srcToCopyMap.put(curNode, new Node(curNode.val, null, null));
        }
        for (Node curNode = head; curNode != null; curNode = curNode.next) {
            Node copyNode = srcToCopyMap.get(curNode);
            copyNode.next = srcToCopyMap.get(curNode.next);
            copyNode.random = srcToCopyMap.get(curNode.random);
        }
        return srcToCopyMap.get(head);
    }
}
