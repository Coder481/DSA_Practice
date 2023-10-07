package zzz_codingChallenges.leetcode.easy;


import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public static void main(String[] args) {
        String[] ops = {"1"};
        System.out.println(calPoints(ops));
    }

    private static int calPoints(String[] ops) {

        List<Integer> list = new ArrayList<>();

        for (String op : ops) {
            switch (op) {
                case "+": {
                    int lastIndex = list.size() - 1;
                    int secLastIndex = lastIndex - 1;
                    list.add(list.get(lastIndex) + list.get(secLastIndex));
                    break;
                }
                case "D": {
                    int lastIndex = list.size() - 1;
                    list.add(list.get(lastIndex) * 2);
                    break;
                }
                case "C": {
                    list.remove(list.size() - 1);
                    break;
                }
                default: {
                    list.add(Integer.parseInt(op));
                }
            }
        }

        return list.stream().mapToInt(i->i).sum();

    }
}
