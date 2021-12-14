package recursion.leetcodeProblems;

public class Kth_Symbol_in_Grammar_779 {

    public static void main(String[] args) {
        int n = 4;
        int k = 5;

        int symbol = solve(n,k);
        System.out.print(symbol);
    }

    private static int solve(int n, int k) {

        if (k==1 && n==1)
            return 0;

        int mid = (int) (Math.pow(2,n-1) / 2);

        if (k<=mid)
            return solve(n-1,k);
        else
            return 1 ^ solve(n-1,k-mid);  // compliment of solve(n-1,k-mid);
    }

}
