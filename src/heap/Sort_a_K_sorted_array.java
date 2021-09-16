package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Example
 *          arr:            6 5 3 2 8 10 9
 *                          <-----|----->
 *                             k     k
 *
 */
public class Sort_a_K_sorted_array {


    public static void main(String[] args) {

        Integer[] arr = {6,5,3,2,8,10,9};
        int k = 3;
        List<Integer> res = new ArrayList<>();

        PriorityQueue<Integer> minH = new PriorityQueue<>();

        for (Integer i : arr) {
            minH.add(i);
            if (minH.size() > k)
                res.add(minH.poll());
        }

        while (minH.size()>0)
            res.add(minH.poll());

        System.out.println(res);

    }

}
