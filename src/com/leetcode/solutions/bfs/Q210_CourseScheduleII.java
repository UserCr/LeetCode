package com.leetcode.solutions.bfs;

import com.leetcode.solutions.SolutionInterface;

public class Q210_CourseScheduleII implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[][] graph = generateGraph(numCourses, prerequisites);

        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            indegree[edge[0]]++;
        }

        int[] res = new int[numCourses];
        for (int curNodePos = 0; curNodePos < numCourses; ++curNodePos) {
            res[curNodePos] = findIndegreeZeroNode(indegree);
            if (-1 == res[curNodePos]) {
                return new int[0];
            }
            for (int row = 0; row < numCourses; row++) {
                if (graph[res[curNodePos]][row]) {
                    indegree[row]--;
                }
            }
            indegree[res[curNodePos]] = -1;
        }
        return res;
    }

    private boolean[][] generateGraph(int numCourses, int[][] prerequisites) {
        boolean[][] graph = new boolean[numCourses][numCourses];
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]][prerequisite[0]] = true;
        }
        return graph;
    }

    private int findIndegreeZeroNode(int[] indegree) {
        for (int i = 0; i < indegree.length; ++i) {
            if (indegree[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
