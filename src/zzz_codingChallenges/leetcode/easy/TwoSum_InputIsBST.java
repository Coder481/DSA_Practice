package zzz_codingChallenges.leetcode.easy;

import zzz_codingChallenges.leetcode.common.TreeNode;

import java.util.*;

public class TwoSum_InputIsBST {

    private static List<Integer> numberList;
    private static Set<Integer> numberSet;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2), new TreeNode(4)),
                new TreeNode(6,null, new TreeNode(7)));
        int target = 6;

        TreeNode root1 = new TreeNode(2,null, new TreeNode(3));

        boolean res = solve(root1, target);
        System.out.println(res);
    }

    private static boolean solve(TreeNode root, int k) {
        numberList = new ArrayList<>();
        numberSet = new HashSet<>();
//        System.out.println(numberSet);
        return bstToList(root,k);
    }

    private static boolean checkForTarget(int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i< numberList.size(); i++){
            if(map.containsKey(target - numberList.get(i))) return true;
            map.put(numberList.get(i), i);
        }
        return false;
    }
    private static boolean bstToList(TreeNode root, int k) {
        if(root != null) {
            if(numberSet.contains(k - root.val))
                return true;
//            numberList.add(root.val);
            numberSet.add(root.val);
            return bstToList(root.left,k) || bstToList(root.right,k);
        }
        else {
            return false;
        }
    }

}
