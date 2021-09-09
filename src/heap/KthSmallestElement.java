package heap;

import java.util.PriorityQueue;

/**
 * Find the kth smallest element in an array
 *
 * Example
 *          arr:    7 10 4 3 20 15
 *          k:      3
 *          output: 7
 */
public class KthSmallestElement {

    public static void main(String[] args) {

        Integer[] arr = {7,10,4,3,20,15};
        int k = 3;

        PriorityQueue<Integer> maxH = new PriorityQueue<>((a,b)->b-a);

        for (Integer i : arr) {
            maxH.add(i);
            if (maxH.size() > k)
                maxH.poll();
        }

        System.out.println(maxH.peek());

    }

}
