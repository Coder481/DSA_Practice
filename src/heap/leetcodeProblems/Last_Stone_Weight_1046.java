package heap.leetcodeProblems;

import java.util.PriorityQueue;

/**
 * LeetCode Problem 1046
 */
public class Last_Stone_Weight_1046 {

    public static void main(String[] args) {

        int[] stones = {2,7,4,1,8,1};

        PriorityQueue<Integer> maxH = new PriorityQueue<>((a, b)->b-a);

        for (Integer integer : stones){
            maxH.add(integer);
        }

        while (maxH.size()>1){
            int x = maxH.poll();
            int y = maxH.poll();

            int dif = (x==y) ? 0 : (x-y);

            maxH.add(dif);
        }

        if (maxH.size() == 0)
            System.out.println(0);
        else
            System.out.println(maxH.peek());
    }

}
