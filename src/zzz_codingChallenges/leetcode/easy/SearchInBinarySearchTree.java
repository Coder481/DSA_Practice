package zzz_codingChallenges.leetcode.easy;

import zzz_codingChallenges.leetcode.common.TreeNode;

public class SearchInBinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {

        if(root == null)
            return null;

        if(root.val == val)
            return root;

        if(val < root.val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }

}
