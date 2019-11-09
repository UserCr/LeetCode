package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q260_SingleNumberIII implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 位操作题目一般都有一定难度。
     * 记nums中只出现一次的两个数分别是a，b。由异或性质可知，零和所有数异或后的结果就是a xor b，记为c。
     * c中某位为1意味着a和b在该位的比特值不同，那么就可以根据该位将nums分成两组，每一组都是由若干出现两次的数和一个独特的数组成，
     * 问题就转化成了非常简单的SingleNumberI问题。
     */
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        //寻找xor中最靠右且值为1的比特位，记xor为aaa1000，a为0或1。根据补码原理可知，-xor为bbb1000，其中b是a的相反值，
        //显然xor & (-xor)就是解。
        xor &= -xor;

        int[] res = new int[2];
        for (int num : nums) {
            if (0 == (xor & num)) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
