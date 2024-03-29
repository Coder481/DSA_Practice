package recursion;

public class Generate_All_Parenthesis {

    public static void main(String[] args) {

        int n = 3;

        int open = n;
        int closed = n;
        String op = "";

        if (n==0) return;


        solve(open,closed,op);

        solve1(op,open,closed);

    }

    private static void solve(int open, int closed, String op) {

        if (open == 0 && closed == 0){
            System.out.println(op);
            return;
        }


        if (open != 0){
            String op1 = op;
            op1 += "(";
            solve(open - 1,closed,op1);
        }

        if (open < closed){
            String op2 = op;
            op2 += ")";
            solve(open,closed - 1,op2);
        }

    }

    private static void solve1(String op, int o, int c){
        if(o==c) solve1(op + "(", o - 1, c);
        else{
            if (o != 0) solve1(op + "(", o - 1, c);
            solve1(op+")",o,c-1);
        }
    }

}
