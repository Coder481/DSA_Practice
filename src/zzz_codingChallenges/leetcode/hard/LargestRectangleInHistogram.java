package zzz_codingChallenges.leetcode.hard;


import globalClasses.Pair;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5,6,2,3};
        System.out.println(largestRectangleArea(arr));
    }

    private static int largestRectangleArea(int[] heights) {

        int size = heights.length;

        int[] allNGR = getAllNGR(heights);
        int[] allNGL = getAllNGL(heights);
        int maxArea = 0;

        for(int i=0; i<size; i++){
            int left = allNGL[i];
            int right = allNGR[i];

            int totalBlocks = 0;

            totalBlocks += ((left == -1) ? i : (i-left-1));
            totalBlocks += ((right == -1) ? (size - 1 -i) : (right - i -1));
            totalBlocks += 1;

            int area = heights[i] * totalBlocks;
            if(area > maxArea) maxArea = area;
        }

        return maxArea;
    }

    private static int[] getAllNGR(int[] arr){
        int size = arr.length;
        if(size == 0) return arr;

        Stack<Pair<Integer, Integer>> s = new Stack<>();
        int[] res = new int[size];

        for(int i=size-1; i>=0; i--){

            while(s.size() > 0 && s.peek().getKey()>=arr[i])
                s.pop();

            if(s.size() == 0) res[i] = -1;
            else res[i] = s.peek().getValue();
            s.push(new Pair<>(arr[i],i));

        }

        return res;
    }

    private static int[] getAllNGL(int[] arr){
        int size = arr.length;
        if(size == 0) return arr;

        Stack<Pair<Integer, Integer>> s = new Stack<>();
        int[] res = new int[size];

        for(int i=0; i<size; i++){

            while(s.size() > 0 && s.peek().getKey()>=arr[i])
                s.pop();

            if(s.size() == 0) res[i] = -1;
            else res[i] = s.peek().getValue();
            s.push(new Pair<>(arr[i],i));

        }

        return res;
    }
}
