package heap;


import globalClasses.Pair;

import java.util.PriorityQueue;

/**
 * Example
 *      arr:    6 5 7 9 8
 *      k:      3
 *      x:      7
 *
 *      Find k closest numbers to x in the arr
 *      Closest numbers means elements that have minimum difference with.
 *
 *      Output: 7,6,8 (order doesn't matter)
 */
public class K_Closest_Numbers_to_x {

    public static void main(String[] args) {
        Integer[] arr = {6,5,7,9,8};
        int k = 3, x = 10;

        PriorityQueue<Pair<Integer,Integer>> maxH = new PriorityQueue<>((a, b)->b.getValue()-a.getValue());

        for (Integer integer : arr) {
            maxH.add(new Pair<>(integer, Math.abs(integer - x)));
            if (maxH.size() > k)
                maxH.poll();
        }

        System.out.print(k+" closest elements to "+x+" are: ");

        while (maxH.size() > 0)
            System.out.print(maxH.poll().getKey()+" ");
    }

}
