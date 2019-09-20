package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

import java.util.*;

public class Q56_MergeIntervals implements SolutionInterface {
    private interface Algorithm {
        //为了保证多种解法的方法签名和LeetCode保持一致而使用的策略模式类。
        //这里有个额外的好处是实现类的类名可以简单描述算法。
        int[][] merge(int[][] intervals);
    }

    @Override
    public void run() {
    }

    private static class SortStart implements Algorithm {
        //线段重合题。比较容易想到的思路是先按照起点递增排序，然后根据当前线段起点是否在结果集中某一线段范围内来判断是否将当前线段与
        //结果集中对应线段合并，合并时终点取两个线段最大值。需要注意的是这种思路有一个可以优化的点是当前线段只需和结果集最后一个线段作比较，
        //原因是线段已按照起点排序，结果集的起点必然也是递增顺序且线段互不重合，若已有两个线段[start1,end1]和[start2,end2]，
        //必然满足关系start1 < end1 < start2 < end2，否则这两个线段就可以合并了。当前需要合并进结果集的线段记为[start3,end3]，
        //其中start3 > start2。那么当前线段最多只能和第二条线段合并，不可能和第一条线段乃至第一条之前的线段合并，所以只需和最后一条线段比较。
        @Override
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
            List<int[]> resList = new ArrayList<>();
            for (int[] interval : intervals) {
                if (resList.size() > 0 && interval[0] <= resList.get(resList.size() - 1)[1]) {
                    resList.get(resList.size() - 1)[1] = Math.max(interval[1], resList.get(resList.size() - 1)[1]);
                } else {
                    int[] temp = {interval[0], interval[1]};
                    resList.add(temp);
                }
            }
            return resList.toArray(new int[resList.size()][]);
        }
    }

    private static class SortStartAndEnd implements Algorithm {
        //比较难想到的一种贪心(?)解法。题目实质是在一堆起点终点中找重合部分，把起点和终点按递增顺序排好后，固定起点遍历终点的过程可以
        //看作是从该起点寻找最远终点的过程，只要下一个起点在当前终点之前，这个过程就可以持续下去。当下个起点不在当前终点之前，就说明
        //当前的重合线段到了尽头，需要将起点移到下个节点处再次开始寻找另一段最长重合线段。如果不理解上述文字的话，可以把排好序的起点终点
        //画成一个个侧边贴在一起的矩形，模拟一下就可以很直观地理解了。
        //若将这些起点终点映射在一条数轴上，那么贪心的局部最优解就是从左到右寻找当前最长重叠线段。
        @Override
        public int[][] merge(int[][] intervals) {
            int[] starts = new int[intervals.length], ends = new int[intervals.length];
            for (int i = 0; i < intervals.length; ++i) {
                starts[i] = intervals[i][0];
                ends[i] = intervals[i][1];
            }
            Arrays.sort(starts);
            Arrays.sort(ends);
            List<int[]> resList = new LinkedList<>();
            for (int endPos = 0, startPos = 0; endPos < intervals.length; ++endPos) {
                if (intervals.length - 1 == endPos || starts[endPos + 1] > ends[endPos]) {
                    int[] temp = {starts[startPos], ends[endPos]};
                    resList.add(temp);
                    startPos = endPos + 1;
                }
            }
            return resList.toArray(new int[resList.size()][]);
        }
    }
}
