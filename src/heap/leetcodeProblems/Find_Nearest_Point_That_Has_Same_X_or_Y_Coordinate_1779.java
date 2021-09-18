package heap.leetcodeProblems;

import java.util.PriorityQueue;

public class Find_Nearest_Point_That_Has_Same_X_or_Y_Coordinate_1779 {

    public static void main(String[] args) {
        int x=3;
        int y=4;
        int[][] points = {{1,2},{3,1},{2,4},{2,3},{4,4}};

        PriorityQueue<int[]> minH = new PriorityQueue<>((a,b) -> (a[1]==b[1]) ? a[0]-b[0] : a[1]-b[1]);

        for (int i=0; i< points.length; i++){
            int[] arr = points[i];

            int xC = arr[0];
            int yC = arr[1];

            if (xC == x || yC == y) {
                int dis = ((x-xC)*(x-xC)) + ((y-yC)*(y-yC)) ;
                minH.add(new int[]{i,dis});
            }
        }

        if (minH.isEmpty())
            System.out.println(-1);
        else {
            System.out.println(minH.peek()[0]);
        }

    }

}
