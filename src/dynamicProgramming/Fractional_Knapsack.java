package dynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

public class Fractional_Knapsack {

    public static void main(String[] args) {
        int[] wt = {10,40,20,30};
        int[] val = {60,40,100,120};
        int capacity = 50;

        double maxVal = getMaxValue(wt, val, capacity);
        System.out.println(maxVal);
    }


    private static double getMaxValue(int[] wt, int[] val, int capacity){

        ItemValue[] iVal = new ItemValue[wt.length];

        for(int i=0; i< wt.length; i++)
            iVal[i] = new ItemValue(wt[i], val[i], i);

        Arrays.sort(iVal);

        double totalVal = 0d;

        for(ItemValue i : iVal){
            int curWt = (int)i.wt;
            int curVal = (int)i.value;
            if(capacity > curWt){
                capacity = capacity - curWt;
                totalVal += curVal;
            }else {
                double fraction = (double) capacity / (double) curWt;
                totalVal += (curVal * fraction);
                capacity = (int)(capacity - (curWt * fraction));
                break;
            }
        }

        return totalVal;
    }


    static class ItemValue{
        double cost;
        double wt, value, index;

        public ItemValue(double wt, double value, double index) {
            this.wt = wt;
            this.value = value;
            this.index = index;
            cost = value / wt;
        }
    }
}
