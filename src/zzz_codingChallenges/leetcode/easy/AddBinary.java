package zzz_codingChallenges.leetcode.easy;

public class AddBinary {

    public static void main(String[] args) {
        String a = "10111";
        String b = "10110";
//        System.out.println(solve(a,b));

        int aInt = Integer.parseInt(a,2);
        int bInt = Integer.parseInt(b,2);

        System.out.println(Integer.toBinaryString(aInt + bInt));

    }

    private static String solve(String a, String b){
        if(a.length() < b.length()){
            int diff = b.length() - a.length();
            for(int i=1; i<=diff; i++)
                a = "0"+a;
        }
        else{
            int diff = a.length() - b.length();
            for(int i=1; i<=diff; i++)
                b = "0"+b;
        }

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i=a.length()-1; i>=0; i--){
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);
            int total = carry + (c1 - '0') + (c2 - '0');

//            System.out.println(total);
            carry = total / 2;
            int sum = total % 2;
            sb.insert(0,sum);
        }

        if(carry != 0) sb.insert(0,carry);
        return sb.toString();
    }
}
