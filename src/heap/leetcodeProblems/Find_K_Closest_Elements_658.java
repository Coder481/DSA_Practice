package heap.leetcodeProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Find_K_Closest_Elements_658 {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        int k = 4,  x = -1;

        PriorityQueue<Object[]> maxH = new PriorityQueue<>((a,b)-> ((int)a[1]==(int)b[1]) ? (int)b[0]-(int)a[0] : (int)b[1]-(int)a[1] );

        for (Integer integer : arr){
            maxH.add(new Object[]{integer,Math.abs(integer-x)});
            if (maxH.size()>k)
                maxH.poll();
        }

        List<Integer> res = new ArrayList<>();
        while (maxH.size()>0)
            res.add((int)maxH.poll()[0]);

        Collections.sort(res);

        System.out.println(res);

    }

}
