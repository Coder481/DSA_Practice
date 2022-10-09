import java.util.Scanner;

public class KickStart2021_G_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int z=1; z<=t; z++){

            Scanner sc1 = new Scanner(System.in);

            String[] ip1 = sc1.nextLine().split(" ");

            int N = Integer.parseInt(String.valueOf(ip1[0]));
            int D = Integer.parseInt(String.valueOf(ip1[1]));
            int C = Integer.parseInt(String.valueOf(ip1[2]));
            int M = Integer.parseInt(String.valueOf(ip1[3]));

            String ip2 = sc1.nextLine();

            if (M == 0){
                long numberOfDogs = ip2.chars().filter(ch -> ch == 'D').count();
                long numberOfCats = ip2.length() - numberOfDogs;

                if (numberOfCats > C || numberOfDogs > D){
                    System.out.println("NO");
                    continue;
                }

            }

            String res = feed(ip2,D,C,M);

            System.out.println(res);

        }

    }

    private static String feed(String ip2, int D, int C, int M) {
        for (char ch : ip2.toCharArray()){

            if (ch == 'D'){
                if (D <= 0)
                    return "NO";

                D-=1;
                C+=M;

            }
            else if (ch == 'C'){
                if (C <= 0)
                    return "NO";

                C-=1;
            }

        }

        return "YES";
    }

}
