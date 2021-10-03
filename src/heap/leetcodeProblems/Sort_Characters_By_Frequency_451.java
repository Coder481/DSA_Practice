package heap.leetcodeProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Sort_Characters_By_Frequency_451 {

    public static void main(String[] args) {
        String s = "Aabb";

        Map<Character,Integer> freqMap = new HashMap<>();

        for (Character c : s.toCharArray()){
            if (freqMap.containsKey(c))
                freqMap.put(c, freqMap.get(c) + 1);
            else
                freqMap.put(c, 1);
        }

        PriorityQueue<Object[]> maxH = new PriorityQueue<>((a, b)->(int)b[1]-(int)a[1]);

        for (Character c : freqMap.keySet())
            maxH.add(new Object[]{c,freqMap.get(c)});

        String otp = "";
        while (maxH.size()>0){
            char ele = (char) maxH.peek()[0];
            int freq = (int) maxH.peek()[1];

            for (int i=0; i<freq; i++)
                otp = otp + ele;

            maxH.poll();
        }
        System.out.println(otp);
    }

}
