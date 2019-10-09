package com.leetcode.solutions.tree;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q129_SumRootToLeafNumbers implements SolutionInterface {
    @Override
    public void run() {
    }

    private List<Integer> path = new ArrayList<>();

    //二叉树后序遍历水题。
    public int sumNumbers(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int res = 0;
        path.add(root.val);
        if (null == root.left && null == root.right) {
            for (Integer num : path) {
                res = res * 10 + num;
            }
        } else {
            int leftRes = 0, rightRes = 0;
            if (root.left != null) {
                leftRes = sumNumbers(root.left);
            }
            if (root.right != null) {
                rightRes = sumNumbers(root.right);
            }
            res = leftRes + rightRes;
        }
        path.remove(path.size() - 1);
        return res;
    }
}
