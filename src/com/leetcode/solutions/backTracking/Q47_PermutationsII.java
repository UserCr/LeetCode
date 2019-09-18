package com.leetcode.solutions.backTracking;

import com.leetcode.CommonPrint;
import com.leetcode.solutions.SolutionInterface;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q47_PermutationsII implements SolutionInterface {
    @Override
    public void run() {
        int[] nums = {1, 1, 2};
        List<List<Integer>> res = permuteUnique(nums);
        for (List<Integer> list : res) {
            CommonPrint.PrintList(list);
        }
    }

    //回溯。有些难度，说明见注释。
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        backTracking(nums, used, new LinkedList<>(), res);
        return res;
    }

    private void backTracking(int[] nums, boolean[] used, List<Integer> curRes, List<List<Integer>> finalRes) {
        if (curRes.size() == nums.length) {
            finalRes.add(new LinkedList<>(curRes));
        } else {
            for (int i = 0; i < nums.length; ++i) {
                //保证输出无重复的关键一是排序，二是保证靠后的同值元素不能先于之前的同值元素使用。比如112，无论哪种输出组合，都必须
                //保证第一个先被使用，不能出现第二个1先于第一个1使用的情况。
                //保证上述第二个条件可以通过检查后续同值元素是否被使用过来判断，也可以通过判断前一个同值元素是否被使用过来保证满足条件。
                //因为只要保证“若要使用i，则i-1必须使用”的条件，可递归推出：若i使用，则0~i-1都已使用（0指该值元素第一次出现的下标）。
                if (used[i] || (i > 0 && !used[i - 1] && nums[i - 1] == nums[i])) {
                    continue;
                }
                used[i] = true;
                curRes.add(nums[i]);
                backTracking(nums, used, curRes, finalRes);
                curRes.remove(curRes.size() - 1);
                used[i] = false;
            }
        }
    }
}
