package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Connect_ropes_to_minimise_cost {

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5};

        PriorityQueue<Integer> minH = new PriorityQueue<>();

        minH.addAll(Arrays.asList(arr));

        int tCost = 0;
        while (minH.size()>=2){
            int a = minH.poll();
            int b = minH.poll();

            int sum = a+b;

            tCost += sum;
            minH.add(sum);

        }

        System.out.println("Minimum cost:"+tCost);
    }

}
