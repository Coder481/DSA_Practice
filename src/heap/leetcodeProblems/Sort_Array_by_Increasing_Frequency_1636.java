package heap.leetcodeProblems;

import java.util.*;

public class Sort_Array_by_Increasing_Frequency_1636 {


    public static void main(String[] args) {

        Integer[] nums = {1,1,1,3,2,2,2,4,3,3,3};

        Map<Integer,Integer> freqMap = new HashMap<>();

        for (Integer integer : nums) {
            if (freqMap.containsKey(integer))
                freqMap.put(integer, freqMap.get(integer) + 1);
            else
                freqMap.put(integer, 1);
        }

        PriorityQueue<Object[]> queue = new PriorityQueue<>((a, b)-> ((int)b[1]==(int)a[1]) ? (int)b[0]-(int)a[0] :-(int)b[1]+(int)a[1]);

        for (Integer num : freqMap.keySet()){
            queue.add(new Object[]{num, freqMap.get(num)});
        }

        List<Integer> res = new ArrayList<>();
        System.out.println("Elements after frequency sort");
        while (queue.size()>0){
            int ele = (int) queue.peek()[0];
            int freq = (int) queue.peek()[1];

            for (int i=0; i<freq; i++)
                res.add(ele);

            queue.poll();
        }

        int[] otp = res.stream().mapToInt(i->i).toArray();
        System.out.println(Arrays.toString(otp));
    }


}
