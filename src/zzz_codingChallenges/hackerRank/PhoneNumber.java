package zzz_codingChallenges.hackerRank;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumber {

    public static void main(String[] args) {
        String s = "five eight double two double two four eight five six triple one one";
        System.out.println(getPhoneNumber(s));
    }


    private static String getPhoneNumber(String s) {
        // Write your code here

        String[] items = s.split(" ");
        StringBuilder res = new StringBuilder();

        Map<String, String> map = new HashMap<>();
        map.put("zero","0");
        map.put("one","1");
        map.put("two","2");
        map.put("three","3");
        map.put("four","4");
        map.put("five","5");
        map.put("six","6");
        map.put("seven","7");
        map.put("eight","8");
        map.put("nine","9");
        for(int i=0; i<=items.length-1; i++){
            switch(items[i]){
                case "double" : {
                    String nextItem = items[i+1];
                    res.append(map.get(nextItem)).append(map.get(nextItem));
                    i = i+1;
                    break;
                }
                case "triple" : {
                    String nextItem = items[i+1];
                    res.append(map.get(nextItem)).append(map.get(nextItem)).append(map.get(nextItem));
                    i = i+1;
                    break;
                }
                default : {
                    res.append(map.get(items[i]));
                }
            }
        }

        return res.toString();
    }
}
