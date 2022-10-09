package zzz_codingChallenges.leetcode.medium;

import zzz_codingChallenges.leetcode.common.TreeNode;

public class TrimBinarySearchTree {

    static TreeNode resRoot = null;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        root = trimBST(root,1,2);

        System.out.println(root.val);
    }


    private static TreeNode trimBST(TreeNode node, int low, int high) {
        if(node == null)
            return null;

        int val = node.val;

        if(val < low)
            return trimBST(node.right, low, high);
        if(val > high)
            return trimBST(node.left, low, high);

        node.left =  trimBST(node.left, low, high);
        node.right =  trimBST(node.right, low, high);

        return node;
    }

}
