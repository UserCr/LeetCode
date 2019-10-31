package com.leetcode.solutions.hashtable;

import com.leetcode.solutions.SolutionInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Q220_ContainsDuplicateIII implements SolutionInterface {
    interface Algorithm {
        boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t);
    }

    @Override
    public void run() {
    }

    static class TreeMap implements Algorithm {
        //掌握TreeSet用法。注意溢出和非法输入。
        @Override
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if (null == nums || nums.length == 0 || k < 0 || t < 0) {
                return false;
            }

            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < nums.length; ++i) {
                final Integer big = treeSet.floor(Integer.MAX_VALUE - t >= nums[i] ? nums[i] + t : Integer.MAX_VALUE);
                final Integer small = treeSet.ceiling(Integer.MIN_VALUE + t <= nums[i] ? nums[i] - t : Integer.MIN_VALUE);
                if ((big != null && big >= nums[i])
                        || (small != null && small <= nums[i])) {
                    return true;
                }

                treeSet.add(nums[i]);
                if (i >= k) {
                    treeSet.remove(nums[i - k]);
                }
            }
            return false;
        }
    }

    static class Bucket implements Algorithm {
        /***
         * 桶排序法，难度不小，需要专门复习。
         * 定义桶宽度是t+1，这样可以保证一个桶里任意两个数的差绝对值不大于t。nums[i] 放入第 nums[i] / (t+1) 号桶，
         * 这样一个范围内的数就被映射成了一个数，比如[x, x+t]内的数就被映射到了x。
         *
         * 对于一个桶号为x，值为v的新元素，依题意要检查桶中是否有[v-t, v+t]范围内的元素。该范围长度是2t+1，
         * 显然这个范围有一部分会且只会落在x两边的桶中，所以要检查x-1, x, x+1这三个桶中是否有[v-t, v+t]范围内的元素。
         * 若x号桶中已有元素，显然两个元素之差小于等于t，算法直接返回true。这也保证了桶中至多只有一个元素。
         * 若x号桶中没有元素，就要检查x-1号桶和x+1号桶，看看其中的元素与v的差的绝对值是否小于等于t。
         *
         * 显然桶最多只有k个，所以当桶的个数多于k个时，依题意要删去nums[i-k]对应的那个桶。
         */
        @Override
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if (null == nums || nums.length == 0 || k < 0 || t < 0) {
                return false;
            }

            //nums[i]为负数时计算桶号方法与为正数时不同，因此直接用移码思想将nums[i]全部转为正数，这一过程会产生溢出，所以桶号为long。
            //因为nums中的数据做减法时可能会造成溢出，比如Integer.MAX和-1，所以计算时要转换成long。
            Map<Long, Long> buckets = new HashMap<>();
            //注意溢出，t = Integer.MAX_VALUE时会溢出。
            final long bucketWidth = (long) t + 1;
            for (int i = 0; i < nums.length; ++i) {
                long bucketId = (((long) nums[i] - Integer.MIN_VALUE) / bucketWidth);
                if (buckets.containsKey(bucketId)) {
                    return true;
                }

                Long low = buckets.get(bucketId - 1);
                Long high = buckets.get(bucketId + 1);
                if (low != null && nums[i] - low <= t ||
                        high != null && high - nums[i] <= t) {
                    return true;
                }
                buckets.put(bucketId, (long) nums[i]);

                if (i >= k) {
                    buckets.remove((((long) nums[i - k] - Integer.MIN_VALUE) / bucketWidth));
                }
            }
            return false;
        }
    }
}
