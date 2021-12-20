package recursion.leetcodeProblems;

public class Pow_x_n_50 {

    public static void main(String[] args) {
        double x = 0.00001;
        int n = 2147483647;


        if (n<0){
            x = 1/x;
            n = n * (-1);
        }

        double res = pow(x,n);
        System.out.println(res);
    }

    private static double pow(double x, int n) {
        if (n==0)
            return 1;

        return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);
    }

}
