package recursion.leetcodeProblems;

import java.util.ArrayList;
import java.util.List;

public class Find_The_Winner_of_Circular_Game {

    public static void main(String[] args) {

        int n = 6 , k = 3;

        int res = findTheWinner(n,k);

        System.out.println(res);
    }

    public static int findTheWinner(int n, int k) {

        List<Integer> arr = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }

        k = k-1;

        int res = solve(arr,k,0);

        return res;
    }

    private static int solve(List<Integer> arr, int k, int index) {

        if (arr.size() == 1){
            return arr.get(0);
        }

        index = (index + k) % arr.size();
        arr.remove(index);

        return solve(arr, k, index);


    }

}
