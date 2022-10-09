package hashMap.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode - https://leetcode.com/problems/check-distances-between-same-letters/
 */
public class CheckDistancesBetweenSameLetters {

    /*
        Use map to store the character and the index of its first occurance
        And when the second occurance found, count the elemnets in between
        and check in distance[] whether the distance at the place is correct or not
    */
    public boolean checkDistances(String s, int[] distance) {

        Map<Character,Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int len = arr.length;

        for(int i=0; i<len; i++){
            if(map.containsKey(arr[i])){
                int start = map.get(arr[i]);
                int diff = i - start - 1;
                if(distance[arr[i]-'a'] != diff) return false;
            }
            else map.put(arr[i], i);
        }
        return true;
    }
}
