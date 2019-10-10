package com.leetcode.solutions.bfs;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.graph.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Q133_CloneGraph implements SolutionInterface {
    @Override
    public void run() {
    }

    //BFS水题。DFS也可以做，思路类似，基本就是经典的DFS稍作改动。
    public Node cloneGraph(Node node) {
        if (null == node) {
            return null;
        }

        HashMap<Node, Node> srcToCloneMap = new HashMap<>();
        Queue<Node> bfsQueue = new LinkedList<>();

        srcToCloneMap.put(node, new Node(node.val, new LinkedList<>()));
        bfsQueue.add(node);
        while (!bfsQueue.isEmpty()) {
            Node curNode = bfsQueue.poll();
            for (Node neighborNode : curNode.neighbors) {
                if (!srcToCloneMap.containsKey(neighborNode)) {
                    srcToCloneMap.put(neighborNode, new Node(neighborNode.val, new LinkedList<>()));
                    bfsQueue.add(neighborNode);
                }
            }
        }
        for (Node keyNode : srcToCloneMap.keySet()) {
            Node copyNode = srcToCloneMap.get(keyNode);
            for (Node neighborNode : keyNode.neighbors) {
                copyNode.neighbors.add(srcToCloneMap.get(neighborNode));
            }
        }
        return srcToCloneMap.get(node);
    }
}
