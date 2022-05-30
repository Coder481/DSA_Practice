package zzz_codingChallenges.leetcode.medium;

public class FindUniqueBinaryString {


    public static void main(String[] args) {
        String[] nums = new String[]{"01","10"};
        System.out.println(findIn_N(nums));
    }

    // Solve in O(n)
    private static String findIn_N(String[] nums){
        String ans = "";
        int n = nums.length;
        for(int i=0; i<n; i++)
            ans += (nums[i].charAt(i) == '1') ? '0' : '1';
        return ans;
    }

    private static String findDifferentBinaryString(String[] nums) {
        int size = nums.length;
        int n = (int)Math.pow(2, size);
        for(int i=0; i<n; i++){
            String binary = toBinaryString(size, i);
            if(!isBinaryExists(binary, nums)) return binary;
        }
        return "";
    }

    private static boolean isBinaryExists(String binary, String[] nums) {
        for(String e : nums)
            if(e.equals(binary)) return true;
        return false;
    }

    private static String toBinaryString(int len, int num){
        return String.format("%" + len + "s",
                Integer.toBinaryString(num)).replaceAll(" ", "0");
    }
}
