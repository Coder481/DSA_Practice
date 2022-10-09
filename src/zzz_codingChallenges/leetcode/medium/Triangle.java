package zzz_codingChallenges.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(-1)));
        list.add(new ArrayList<>(Arrays.asList(2,3)));
        list.add(new ArrayList<>(Arrays.asList(1,-1,-3)));
//        list.add(new ArrayList<>(Arrays.asList(4,1,8,3)));

        System.out.println("MinPath:"+ minimumTotal(list));
    }


    private static int minimumTotal(List<List<Integer>> triangle){

        int size = triangle.size();

        // if the input has only one item then that item will be the only path
        if(size == 1)
            return triangle.get(0).get(0);

        int[] res = new int[triangle.get(size-1).size()];

        // Fill result array with the elements of last list of triangle 2-D list
        for(int i=0; i<triangle.get(size-1).size(); i++)
            res[i] = triangle.get(size-1).get(i);

        // Now traverse from bottom of the triangle list to the top
        // by updating the minimum values in the result array
        for(int i=triangle.size()-2; i>=0; i--){
            List<Integer> curr = triangle.get(i);
            for(int j=0; j<curr.size(); j++)
                res[j] = Math.min(res[j], res[j + 1]) + curr.get(j);
        }

        return res[0];
    }

}
