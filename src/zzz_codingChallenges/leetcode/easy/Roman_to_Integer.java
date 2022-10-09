package zzz_codingChallenges.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Roman_to_Integer {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    private static int romanToInt(String s) {

        Map<String, Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);

        int res = 0;

        for(int i=0; i<s.length(); i++){
            switch(s.charAt(i)){
                case 'I' : {
                    if(i != s.length()-1){
                        switch (s.charAt(i+1)){
                            case 'V':{
                                res += 4;
                                i += 1;
                                break;
                            }
                            case 'X':{
                                res += 9;
                                i += 1;
                                break;
                            }
                            default : {
                                res += 1;
                            }
                        }
                    }
                    else res += 1;
                    break;
                }
                case 'X' : {
                    if(i != s.length()-1){
                        switch (s.charAt(i+1)){
                            case 'L':{
                                res += 40;
                                i += 1;
                                break;
                            }
                            case 'C':{
                                res += 90;
                                i += 1;
                                break;
                            }
                            default : {
                                res += 10;
                            }
                        }
                    }
                    else res += 10;
                    break;
                }
                case 'C' : {
                    if(i != s.length()-1){
                        switch (s.charAt(i+1)){
                            case 'D':{
                                res += 400;
                                i += 1;
                                break;
                            }
                            case 'M':{
                                res += 900;
                                i += 1;
                                break;
                            }
                            default : {
                                res += 100;
                            }
                        }
                    }
                    else res += 100;
                    break;
                }
                default:{
                    res += map.get(s.charAt(i)+"");
                }
            }
        }

        return res;
    }
}
