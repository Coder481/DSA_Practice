package recursion;

/**
 * Example:
 *      Let n = 5
 *
 *      and the number we generate is   11010
 *                                                      1s        0s
 *      now possible prefixes are       11010           3   >=    2
 *                                      1101            3   >=    1
 *                                      110             2   >=    1
 *                                      11              2   >=    0
 *                                      1               1   >=    0
 *
 *       All possible prefixes has more 1s than 0s, so 11010 is accepted
 *
 *       Now, similarly we have to generate all the possible binary numbers
 */
public class Print_N_bit_binary_number_having_more_zero_than_one_in_each_prefix {

    public static void main(String[] args) {
        int n = 3;

        String op = "";

        solve(op,n,0,0);
    }

    private static void solve(String op, int rem, int oneS, int zeroS) {

        if (rem == 0){
            System.out.println(op);
            return;
        }

        String op1 = op;
        op1 += "1";
        solve(op1,rem - 1, oneS + 1, zeroS);

        if (oneS > zeroS){
            String op2 = op;
            op2 += "0";
            solve(op2,rem - 1, oneS, zeroS + 1);
        }


    }


}
