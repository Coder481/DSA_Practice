package recursion.permutations;

/**
 * In this problem we have assumed that the input string is always in lowercase.
 */
public class Permutation_With_Case_Change {

    public static void main(String[] args) {
        String ip = "ab";
        String op = "";

        solve(ip,op);
    }

    private static void solve(String ip, String op) {
        if (ip.length() == 0){
            System.out.println(op);
            return;
        }

        String op1 = op;
        String op2 = op;

        op1 += ip.charAt(0);
        op2 += Character.toUpperCase(ip.charAt(0));

        ip = ip.substring(1);

        solve(ip,op1);
        solve(ip,op2);
    }

}
