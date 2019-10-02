package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

import java.util.ArrayList;
import java.util.List;

public class Q89_GrayCode implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 格雷码有专门的生成规则，和经典算法关系不太大。这里用的是镜像生成法。记n-1位的解是G(n-1)，那么G(n)就是在G(n-1)前分别
     * 加上0和1，其中加0的G(n-1）和加1的G(n-1)顺序相反。比如G(1)= 0，1。那么G(2)就是0 0，0 1，1 1，1，0。顺序相反的必要性是
     * G(n-1)本来就符合题意，加0后生成新序列，把新加的0变为1后若要保持其他位不变，则必须将G(n-1)反过来再加1。
     */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; --j) {
                res.add(res.get(j) | 1 << i);
            }
        }
        return res;
    }
}
