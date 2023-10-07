package heap;


import globalClasses.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Find all the k number of co-ordinates that are closest to the origin
 *
 * Example:
 *          arr:    X   Y           Distance (X^2+Y^2) ^ (1/2)
 *                  1   3               10^0.5 = 3.16
 *                 -2   2               8^0.5  = 2.82
 *                  5   8               89^0.5 = 9.43
 *                  0   1               1^0.5  = 1
 *
 *          k:      2
 *
 *          Output: (0,1) , (-2,2)
 */
public class K_closest_points_to_origin {

    public static void main(String[] args) {

        List<Pair<Integer,Integer>> arr = Arrays.asList(
                new Pair<>(1,3),
                new Pair<>(-2,2),
                new Pair<>(5,8),
                new Pair<>(0,1),
                new Pair<>(0,0)
        );
        int k = 3;

        PriorityQueue<Pair<Integer,Pair<Integer,Integer>>> maxH = new PriorityQueue<>((a, b)->b.getKey()-a.getKey());

        for (Pair<Integer,Integer> pair : arr) {

            int x = pair.getKey();
            int y = pair.getValue();

            maxH.add(new Pair<>((x*x)+(y*y), new Pair<>(x,y)));
            if (maxH.size() > k)
                maxH.poll();
        }

        System.out.println(k+" closest coordinates to origin(0,0) are: ");

        while (maxH.size() > 0){
            Pair<Integer,Integer> coordinate = maxH.poll().getValue();
            System.out.println("("+coordinate.getKey()+","+coordinate.getValue()+")");
        }

    }

}
