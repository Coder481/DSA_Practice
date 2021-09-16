package heap;

import java.util.PriorityQueue;

/**
 * Print sum of all the elements between the k1th smallest element and k2th smallest element
 *
 * Example
 *          arr:        1 3 12 5 15 11
 *          k1:             3
 *          k2:             6
 *
 *          output:         23 (11+12)
 */
public class Sum_of_elements_between_k1_k2 {

    public static void main(String[] args) {

        Integer[] arr = {1,3,12,5,15,11};
        int k1 = 3, k2 = 6;

        int first = getSmallest(arr,k1);
        int sec = getSmallest(arr,k2);

        int sum = 0;
        for (Integer integer : arr){
            if (integer<sec && integer>first)
                sum += integer;
        }

        System.out.println("Sum:"+sum);
    }

    private static int getSmallest(Integer[] arr, int k) {

        PriorityQueue<Integer> maxH = new PriorityQueue<>((a, b)->b-a);

        for (Integer i : arr) {
            maxH.add(i);
            if (maxH.size() > k)
                maxH.poll();
        }

        return maxH.peek();
    }

}
