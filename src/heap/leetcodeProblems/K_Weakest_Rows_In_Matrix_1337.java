package heap.leetcodeProblems;

import java.util.*;

// LeetCode problem 1337
public class K_Weakest_Rows_In_Matrix_1337 {

    public static void main(String[] args) {

        int[][] mat = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        int k = 3;

        PriorityQueue<int[]> maxH = new PriorityQueue<>((a,b) -> (b[1]==a[1]) ? b[0]-a[0] : b[1]-a[1]);

        for (int j = 0; j< mat.length; j++){
            int[] arr = mat[j];
            int i = 0, count = 0;
            while (i< arr.length && arr[i]==1){
                count++;
                i++;
            }

            maxH.add(new int[]{j, count});
            if (maxH.size() > k) {
                maxH.poll();
            }
        }

        PriorityQueue<int[]> minH = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        while (maxH.size()>0) {
            minH.add(maxH.poll());
        }

        List<Integer> otp = new ArrayList<>();

        while (minH.size()>0){
            int[] arr = minH.poll();
            PriorityQueue<int[]> minSortedH = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            minSortedH.add(arr);

            while (minH.size()>0 && minH.peek()[1] == arr[1]) {
                minSortedH.add(minH.poll());
            }

            while (minSortedH.size()>0)
                otp.add(minSortedH.poll()[0]);

        }
        int[] res = otp.stream().mapToInt(i->i).toArray();

        System.out.println(Arrays.toString(res));

    }

}
