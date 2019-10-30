package com.leetcode.solutions.bfs;

import com.leetcode.solutions.SolutionInterface;

import java.util.Arrays;

public class Q207_CourseSchedule implements SolutionInterface {
    @Override
    public void run() {
    }

    private final int DELETE = -1;
    private final int NOT_FOUND = -1;

    //水题。
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] validEdge = new boolean[prerequisites.length];
        Arrays.fill(validEdge, true);

        int[] indegrees = new int[numCourses];
        Arrays.fill(indegrees, 0);
        for (int[] edge : prerequisites) {
            indegrees[edge[1]]++;
        }

        int curNode = findIndegreeZeroNode(indegrees);
        while (curNode != NOT_FOUND) {
            for (int i = 0; i < prerequisites.length; ++i) {
                if (validEdge[i] && prerequisites[i][0] == curNode) {
                    indegrees[prerequisites[i][1]]--;
                    validEdge[i] = false;
                }
            }
            indegrees[curNode] = DELETE;
            curNode = findIndegreeZeroNode(indegrees);
        }

        return isAllIndegreeZero(indegrees);
    }

    private int findIndegreeZeroNode(int[] indegree) {
        for (int i = 0; i < indegree.length; ++i) {
            if (indegree[i] == 0) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    private boolean isAllIndegreeZero(int[] indegree) {
        for (int num : indegree) {
            if (num > 0) {
                return false;
            }
        }
        return true;
    }
}
