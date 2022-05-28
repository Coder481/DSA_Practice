package zzz_codingChallenges.leetcode.medium;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class DesignUndergroundSystem {

    public static void main(String[] args) {

        UndergroundSystem obj = new UndergroundSystem();
        obj.checkIn(45,"Leyton",3);
        obj.checkIn(32,"Paradise",8);
        obj.checkIn(27,"Leyton",10);

        obj.checkOut(45,"Waterloo",15);
        obj.checkOut(27,"Waterloo",20);
        obj.checkOut(32,"Cambridge",22);

        obj.getAverageTime("Paradise","Cambridge");
        obj.getAverageTime("Leyton","Waterloo");

        obj.checkIn(27,"Leyton",10);

        obj.getAverageTime("Leyton","Waterloo");
    }

}

class UndergroundSystem {

    Map<Integer, Pair<String, Integer>> checkInMap;
    Map<String, Pair<Integer, Integer>> checkOutMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        checkOutMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair<>(stationName,t));
    }

    public void checkOut(int id, String stationName, int t) {
        // {stationName, time}
        Pair<String , Integer> checkIn = checkInMap.get(id);
        String route = checkIn.getKey() + "_" + stationName;

        // {totalDuration, totalTrips}
        Pair<Integer, Integer> checkOut = checkOutMap.getOrDefault(route, new Pair<>(0,0));
        int duration = t - checkIn.getValue();
        checkOutMap.put(route, new Pair<>(checkOut.getKey() + duration, checkOut.getValue() + 1));

    }

    public double getAverageTime(String startStation, String endStation) {

        String route = startStation + "_" + endStation;
        Pair<Integer, Integer> checkOut = checkOutMap.get(route);
        double res = (double) checkOut.getKey() / (double)checkOut.getValue();
        System.out.println(res);

        return res;
    }
}
