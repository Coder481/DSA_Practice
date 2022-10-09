package z_labWork.sem6.competitiveCoding;

public class Lab_6_GCD {

    public static void main(String[] args) {

        int a = 7, b = 15;

        int gcdBF = getGcdByBruteForce(a,b);
        int gcdAlgo = getGcdByAlgo(a,b);

        System.out.println("GCD by Brute Force:" + gcdBF + "\nGCD by Algo:" + gcdAlgo);

    }


    static int getGcdByAlgo(int a, int b){
        if(b == 0) return a;
        return getGcdByAlgo(b,a%b);
    }

    private static int getGcdByBruteForce(int a, int b){

        int min = Math.min(a,b);

        for(int i = min; i>0; i--){
            if(a%i == 0 && b%i == 0) return i;
        }

        return -1;

    }


}
