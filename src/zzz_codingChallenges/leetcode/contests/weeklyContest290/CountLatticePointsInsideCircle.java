package zzz_codingChallenges.leetcode.contests.weeklyContest290;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CountLatticePointsInsideCircle {

    public static void main(String[] args) {
        int[][] circles = new int[][]{{2,2,2},{3,4,1}};
        System.out.println(countLatticePoints(circles));
    }

    public static int countLatticePoints(int[][] circles) {

        Set<int[]> set = new HashSet<>();

        List<Pair<Integer,Integer>> res = new ArrayList<>();

        for(int[] circle : circles){
            int x = circle[0];
            int y = circle[1];
            int r = circle[2];

            int xMin = x - r;
            int yMin = y - r;
            int xMax = x + r;
            int yMax = y + r;


            for(int i = xMin; i<=xMax; i++){
                for(int j=yMin; j<=yMax; j++){
                    double dis = getDis(x,y, i,j);
                    if(dis <= r) {
//                        if(!isCoordinatePresent(res,i,j))

                        res.add(new Pair<>(i,j));
                    }
                }
            }

        }

        List<Pair<Integer, Integer>> res1 = res.stream().distinct().collect(Collectors.toList());
        return res1.size();

    }

    private static boolean isCoordinatePresent(List<Pair<Integer, Integer>> res, int i, int j) {
        boolean ret = false;

        for(Pair<Integer, Integer> pair : res)
            if(pair.getKey() == i && pair.getValue() == j){
                ret = true;
                break;
            }

        return ret;
    }


    private static double getDis(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2));
    }
}
