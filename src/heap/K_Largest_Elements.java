package heap;

import java.util.PriorityQueue;

/**
 * In this problem, find k largest elements in an array
 *
 * Example:
 *          arr:    7 10 4 3 20 15
 *          k:      3
 *
 *          output: 20 15 10 (order doesn't matter)
 */
public class K_Largest_Elements {

    public static void main(String[] args) {

        Integer[] arr = {7,10,4,3,20,15,25};
        int k = 5;

        PriorityQueue<Integer> minH = new PriorityQueue<>();

        for (Integer i : arr) {
            minH.add(i);
            if (minH.size() > k)
                minH.poll();
        }

        System.out.println(minH);

    }

}
