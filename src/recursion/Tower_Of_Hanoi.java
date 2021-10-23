package recursion;

public class Tower_Of_Hanoi {

    static int count = 0;
    public static void main(String[] args) {
        int n = 9;

        String s = "Source", h = "Helper", d = "Destination";

        solve(s,d,h,n);

        System.out.println("Total steps taken = "+count);
    }

    private static void solve(String s, String d, String h, int n) {

        count++;

        if (n == 1){
            System.out.println("Move disc "+n+" from "+s+" to "+d);
            return;
        }

        solve(s,h,d,n-1);

        System.out.println("Move disc "+n+" from "+s+" to "+d);

        solve(h,d,s,n-1);
    }

}
