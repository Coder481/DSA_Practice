package z_labWork.sem6.competitiveCoding;

import java.util.Scanner;

public class Lab_5_PrimeNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

//        System.out.print("Enter a integer: ");
        long num = 53L/*sc.nextLong()*/;

        long startMillis = System.currentTimeMillis();
//        boolean isNumPrime = isNumPrime_ByBruteForceMethod(num);
        boolean isNumPrime = isNumPrime_ByTheorem(num, 5);
        System.out.println("Is "+num+" prime: "+isNumPrime);

        long endMillisByBruteForce = System.currentTimeMillis();

        long timeTookByAlgoInMillis = (endMillisByBruteForce - startMillis);
        System.out.println("Time taken by brute force algo in millis: "+timeTookByAlgoInMillis);

    }

    private static boolean isNumPrime_ByTheorem(long num, int steps) {

        for(int i = 0; i<steps; i++){
            double a = Math.random() * (num - 2) + 2;
            double pow = Math.pow(a, num - 1);
            if(pow % num != 1){
                return false;
            }
        }
        return true;
    }

    private static boolean isNumPrime_ByBruteForceMethod(long num) {
        for(int i = 2; i<num; i++){
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }

}
