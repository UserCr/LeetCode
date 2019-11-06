package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

import java.util.*;

public class Q229_MajorityElementII implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题，注意投票法除了每次扔掉若干个不一样的元素外，还有统计剩下元素个数是否合法的步骤。
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(2);
        for (int num : nums) {
            Integer count = map.get(num);
            if (null != count) {
                map.put(num, count + 1);
            } else if (map.size() < 2) {
                map.put(num, 1);
            } else {
                map.replaceAll((k, v) -> map.get(k) - 1);
                map.values().removeIf(value -> value == 0);
            }
        }
        map.keySet().removeIf(key -> Arrays.stream(nums).filter(num -> num == key).count() <= nums.length / 3);
        return new LinkedList<>(map.keySet());
    }
}
