package zzz_codingChallenges.leetcode.hard;

public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] a = new int[]{2147483647};
//        System.out.println(firstMissingPositive1(a));
        System.out.println(Integer.MAX_VALUE);
    }

    private static int firstMissingPositive1(int[] nums){

        int n = nums.length;
        int[] positiveArr = new int[n+1];
        int maxPositive = Integer.MIN_VALUE;

        int i=0;
        for(int e : nums){
            if(e > 0){
                positiveArr[i] = e;
                i++;

                if(e > maxPositive) maxPositive = e;
            }
        }

        if(maxPositive < 0) maxPositive = 0;

        System.out.println("MaxPositive:"+(maxPositive+1));
        int[] resArr = new int[maxPositive + 1];
        for(int e : positiveArr) resArr[e] = 1;

        int res = maxPositive+1;
        for(int j=1; j<=resArr.length-1; j++){
            if(resArr[j] == 0){
                res = j;
                break;
            }
        }

        return res;
    }


    private static int firstMissingPositive(int[] nums) {

        int min = Integer.MAX_VALUE;
        int n = nums.length;
        int[] minArr = new int[n+1];
        int i=0;
        for(int e : nums){
            if(e < min) {
                min = e;
                minArr[i] = min;
                i++;
            }
        }

        int minArrSize = minArr.length;
        int[] resArr = new int[minArrSize + 1];
        for(int j=0; j<=minArrSize-1; j++) resArr[minArr[j]] = 1;

        int res = resArr.length + 1;
        for(int j=0; j<=resArr.length-1; j++){
            if(resArr[j] == 0){
                res = j;
                break;
            }
        }



        /*int max = Integer.MIN_VALUE;
        for(int e : minArr) if (e > max) max = e;

        for(int j=0; j<=max; j++){

        }*/


        return res;
    }
}
