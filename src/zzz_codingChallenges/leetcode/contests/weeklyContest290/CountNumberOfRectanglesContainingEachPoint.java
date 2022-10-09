package zzz_codingChallenges.leetcode.contests.weeklyContest290;

import javax.xml.ws.FaultAction;
import java.util.Arrays;

public class CountNumberOfRectanglesContainingEachPoint {

    public static void main(String[] args) {
        int[][] rec = new int[][]{{1,2},{2,3},{2,5}};
        int[][] points = new int[][]{{2,1},{1,4}};

        System.out.println(Arrays.toString(countRectanglesByAlgo(rec, points)));

    }

    // Incomplete method
    public static int[] countRectanglesByAlgo(int[][] rectangles, int[][] points){

        int recSize = rectangles.length;
        int pointsSize = points.length;

        double[] recDis = new double[recSize];
        double[] pointsDis = new double[pointsSize];

        int[] res = new int[pointsSize];

        for(int i=0; i<recSize; i++)
            recDis[i] = getDis(0,0, rectangles[i][0], rectangles[i][1]);

        System.out.println(Arrays.toString(recDis));

        for(int i=0; i<pointsSize; i++)
            pointsDis[i] = getDis(0,0, points[i][0], points[i][1]);


        System.out.println(Arrays.toString(pointsDis));

//        for(int i=recSize-1; i>=0; i--){
//            for(int j=0; j<pointsSize; j++){
//                if(pointsDis[j] <= recDis[i]) {
//                    res[j] = i + 1;
//                    break;
//                }
//            }
//        }

        for(int i=0; i<pointsSize; i++){
            for(int j=0; j< recSize; j++){
                if(pointsDis[i] <= recDis[j]){
                    res[i] = recSize - j;
                    break;
                }
            }
        }

        return res;
    }


    public static int[] countRectangles(int[][] rectangles, int[][] points) {

        int[] res = new int[points.length];
        int i = 0;
        for(int[] point : points){

            int count = 0;

            for(int[] rec : rectangles){

                int pointX = point[0];
                int pointY = point[1];

                int recX = rec[0];
                int recY = rec[1];

                if(pointX <= recX && pointY <= recY) count++;
            }

            res[i++] = count;

        }

        return res;
    }



    private static double getDis(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2));
    }
}
