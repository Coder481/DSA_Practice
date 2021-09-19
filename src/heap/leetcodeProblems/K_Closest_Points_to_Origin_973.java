package heap.leetcodeProblems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class K_Closest_Points_to_Origin_973 {

    public static void main(String[] args) {

        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;

        PriorityQueue<Object[]> maxH = new PriorityQueue<>((a, b)->(int)b[0]-(int)a[0]);

        for (int[] arr : points) {

            int x = arr[0];
            int y = arr[1];

            maxH.add(new Object[]{(x*x)+(y*y), new int[]{x,y}});
            if (maxH.size() > k)
                maxH.poll();
        }


        int[][] res = new int[k][2];
        int i = 0;
        while (maxH.size() > 0){
            int[] coordinate = (int[]) maxH.poll()[1];
            res[i] = new int[]{coordinate[0], coordinate[1]};
            i++;
        }


        System.out.println(Arrays.deepToString(res));

    }


}
