package zzz_codingChallenges.leetcode.contests.weeklyContest291;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class MinimumConsecutiveCardsPickUp {

    public static void main(String[] args) {

        int[] cards = new int[]{70,37,70,41,1,62,71,49,38,50,29,76,29,41,22,66,88,18,85,53};
        System.out.println(solve(cards));
    }

    private static int solve(int[] cards){
        Map<Integer, Integer> map = new HashMap<>();
        int minCards = Integer.MAX_VALUE;
        for(int i=0; i<cards.length; i++){
            int item = cards[i];
            if(map.containsKey(item)){
                int lastIndex = map.get(item);
                int gap = i - lastIndex + 1;
                if(gap < minCards) minCards = gap;
            }
            map.put(item, i);
        }
        if(minCards == Integer.MAX_VALUE || minCards == 0) return -1;
        return minCards;
    }
}
