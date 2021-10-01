package heap.leetcodeProblems;

import java.util.*;

public class Top_K_Frequent_Words_692 {

    public static void main(String[] args) {
        String[] words = {"the","day","is","sunny","the","the","the","sunny","is","is","is"};
        int k = 4;

//        String[] words = {"i","love","leetcode","i","love","coding"};
//        int k = 2;

//        int a = words[0].charAt(0) - words[1].charAt(0);

        Map<String,Integer> freqMap = new HashMap<>();
        for (String word : words){
            if (freqMap.containsKey(word)){
                int freq = freqMap.get(word)+1;
                freqMap.put(word,freq);
            }else {
                freqMap.put(word,1);
            }
        }

        PriorityQueue<Object[]> minH = new PriorityQueue<>((a,b)-> (a[1]==b[1]) ? ((String)b[0]).compareTo(((String)a[0])) : (int)a[1]-(int)b[1]);

        for (String key : freqMap.keySet()){
            minH.add(new Object[]{key,freqMap.get(key)});
            if (minH.size()>k)
                minH.poll();
        }
        List<String> res = new ArrayList<>();
        while (minH.size()>0){
            res.add((String) minH.poll()[0]);
        }

        Collections.reverse(res);

        System.out.println(res);
    }

}
