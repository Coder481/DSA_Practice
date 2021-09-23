package heap.leetcodeProblems;

import java.util.PriorityQueue;

public class Kth_Smallest_Element_in_Sorted_Matrix_378 {
    public static void main(String[] args) {
        int[][] matrix = {{-15}};
        int k = 1;

        PriorityQueue<Integer> maxH = new PriorityQueue<>((a,b)->b-a);

        for (int[] arr : matrix){
            for (Integer ele : arr){
                maxH.add(ele);
                if (maxH.size()>k)
                    maxH.poll();
            }
        }

        System.out.println(maxH.peek());
    }
}
