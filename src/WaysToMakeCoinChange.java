public class WaysToMakeCoinChange {

    public static int coinChange(int[] deno, int n){

//        int[] dp = new int[n+1];
//        dp[0] = 1;
//        for(int i = 0; i < deno.length; i++){
//
//            for(int j = 1; j < dp.length; j++){
//
//                if(deno[i] <= j){
//
//                    dp[j] += dp[j-deno[i]];
//                }
//            }
//        }
//        return dp[n];

        //Base case
        if (n == 0) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < deno.length; i++) {
            if (n >= deno[i]) {
                int smallAns = coinChange(deno, n - deno[i]);
                if(ans < smallAns){
                    ans = smallAns;
                }
            }
        }
        return 1+ans;
    }

    public static void main(String[] args) {

        int[] deno = { 1, 2, 3};
        int n = 4;
        int ans = coinChange(deno, n);
        System.out.println(ans);
    }
}
