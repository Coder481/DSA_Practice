package recursion.permutations;

public class Permutation_With_Spaces {

    public static void main(String[] args) {

        String ip = "ABCD";
        String op = "";

        op += ip.charAt(0);
        ip = ip.substring(1);

        solve(ip,op);
    }

    private static void solve(String ip, String op) {
        if (ip.length() == 0){
            System.out.println(op);
            return;
        }

        String op1 = op;
        String op2 = op;

        op1 += "_" + ip.charAt(0);
        op2 += ip.charAt(0);

        ip = ip.substring(1);

        solve(ip,op1);
        solve(ip,op2);
    }

}
