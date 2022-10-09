package zzz_codingChallenges.leetcode.contests.weeklyContest289;

public class CalculateDigitSumString {

    public static void main(String[] args) {
        String s = "00000000";
        int k = 3;
        System.out.println(solve(s,k));
    }


    private static String solve(String s, int k){
        while(s.length() > k){
            String temp = s;
            StringBuilder res = new StringBuilder();
            while(temp.length() > k){
                String str = temp.substring(0,k);
                temp = temp.substring(k);
                String sum = getSum(str);
                res.append(sum);
            }
            if(!temp.isEmpty())
                res.append(getSum(temp));
            s = res.toString();
        }
        return s;
    }

    private static String getSum(String str) {
        int sum = 0;
        for(char c : str.toCharArray()){
            sum += Integer.parseInt(c+"");
        }
        return sum+"";
    }
}
