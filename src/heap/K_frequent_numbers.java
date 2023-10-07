package heap;


import globalClasses.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Find top k frequent numbers in an array
 * Frequent numbers means the elements which occurs most of the time in an array
 *
 * Example:
 *          arr:    1 1 1 3 2 2 4
 *          k:      2
 *
 *          number      frequency
 *            1             3
 *            3             1
 *            2             2
 *            4             1
 *
 *          output: 1(freq->3), 2(freq->2)
 */
public class K_frequent_numbers {

    public static void main(String[] args) {

        Integer[] nums = {1,1,1,3,2,2,4,3,3,3};
        int k = 2;

        Map<Integer,Integer> freqMap = new HashMap<>();

        for (Integer integer : nums) {
            if (freqMap.containsKey(integer))
                freqMap.put(integer, freqMap.get(integer) + 1);
            else
                freqMap.put(integer, 1);
        }

        PriorityQueue<Pair<Integer,Integer>> minH = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));

        for (Integer num : freqMap.keySet()){
            minH.add(new Pair<>(num, freqMap.get(num)));

            if (minH.size()>k)
                minH.poll();
        }

        while (minH.size()>0)
            System.out.println(minH.poll().getKey()+" ");
    }

}
