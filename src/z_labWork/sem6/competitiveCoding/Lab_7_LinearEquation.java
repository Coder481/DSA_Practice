package z_labWork.sem6.competitiveCoding;

public class Lab_7_LinearEquation {

    public static void main(String[] args) {

        int a = 2, b = 4, c = 6;

        int gcdAB = Lab_6_GCD.getGcdByAlgo(a, b);

        if(c % gcdAB == 0) System.out.println("Solution exists");
        else System.out.println("Solution not exists");

    }

}
