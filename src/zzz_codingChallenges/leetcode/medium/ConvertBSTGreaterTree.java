package zzz_codingChallenges.leetcode.medium;

import zzz_codingChallenges.leetcode.common.TreeNode;

public class ConvertBSTGreaterTree {

    public static void main(String[] args) {

        TreeNode zero = new TreeNode(4);
        TreeNode one = new TreeNode(4);
        TreeNode two = new TreeNode(4);
        TreeNode three = new TreeNode(4);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(4);
        TreeNode six = new TreeNode(4);
        TreeNode seven = new TreeNode(4);
        TreeNode eight = new TreeNode(4);


        four.left = one;
        four.right = six;

        one.left = zero;
        one.right = two;

        two.right = three;

        six.left = five;
        six.right = seven;

        seven.right = eight;

        System.out.println(convertBST(four));
    }

    private static TreeNode convertBST(TreeNode root) {
        solve(root);
        return root;
    }

    private static void solve(TreeNode node){
        if(node == null)
            return;

        int nodeSum = node.val;
        if(node.left != null) {
            nodeSum += getSum(node.left);
            System.out.println(nodeSum - node.val);
        }
        node.val = nodeSum;

//        if(node.left != null)
//        if(node.right != null)

        solve(node.left);
        solve(node.right);
    }

    private static int getSum(TreeNode node){
        if(node == null)
            return 0;

        int sum = node.val;

//        if(node.left != null)
//        if(node.right != null)

        sum += getSum(node.left);
        sum += getSum(node.right);

        return sum;
    }
}
