package recursion.permutations;

public class Letter_Case_Change_Permutation {

    public static void main(String[] args) {
        String ip = "aBc";
        String op = "";

        solve(ip,op);
    }

    private static void solve(String ip, String op) {

        if (ip.length() == 0){
            System.out.println(op);
            return;
        }

        if (Character.isDigit(ip.charAt(0))){
            String op1 = op;
            op1 += ip.charAt(0);
            ip = ip.substring(1);
            solve(ip,op1);
        }
        else {
            String op1 = op;
            String op2 = op;

            op1 += Character.toLowerCase(ip.charAt(0));
            op2 += Character.toUpperCase(ip.charAt(0));

            ip = ip.substring(1);

            solve(ip,op1);
            solve(ip,op2);
        }

    }

}
