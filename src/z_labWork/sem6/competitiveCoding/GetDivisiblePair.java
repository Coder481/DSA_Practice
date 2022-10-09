package z_labWork.sem6.competitiveCoding;

import java.util.HashMap;
import java.util.Map;

public class GetDivisiblePair {

    public static void main(String[] args) {

        int[] arr = {30,40,60,80,100,120};
        System.out.println("Brute Force:"+getPairBruteForce(arr));
        System.out.println("Algo:"+getPairAlgo(arr));

    }


    private static int getPairAlgo(int[] arr){

        Map<Integer, Integer> countMap = new HashMap<>();

        // Store mod counts in map
        for(int e : arr){
            int mod = e % 60;
            if(countMap.containsKey(mod)){
                int value = countMap.get(mod);
                value++;
                countMap.put(mod, value);
            }
            else{
                countMap.put(mod, 1);
            }
        }

        int totalPairs = 0;
        for(int e : countMap.keySet()){
            if(e < 30 && e != 0){
                int keyToFind = 60 - e;
                int pair1Val = countMap.get(e);
                int pair2Val = countMap.get(keyToFind);
                totalPairs += (pair1Val * pair2Val);
            }
        }

        if(countMap.containsKey(30)){
            totalPairs += (countMap.get(30) / 2);
        }
        if(countMap.containsKey(0)){
            totalPairs += (countMap.get(0) / 2);
        }

        return totalPairs;
    }



    private static int getPairBruteForce(int[] arr){
        int total = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if((arr[i]+arr[j]) % 60 == 0)
                    total += 1;
            }
        }
        return total;
    }

}
