import java.util.Scanner;

public class KickStart_2021_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i=1; i<=t; i++){
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();

            Scanner scanner1 = new Scanner(System.in);
            String s = scanner1.nextLine();

            long sumTotal = 0;
            int latestOneIndex = -1;

            for (int j=0; j<s.length(); j++){

                if (s.charAt(j) == '1'){
                    latestOneIndex = j;
                    sumTotal += 0;
                    continue;
                }

                int leftDis = -1;
                if (latestOneIndex != -1)
                    leftDis = j - latestOneIndex;

                int rightDis = -1;

                // Calculating right distance
                int toRight = (leftDis==-1) ? n : j + leftDis;
                for (int k=j+1; k<toRight; k++){
                    if (k==n){
                        break;
                    }
                    if (s.charAt(k) == '1'){
                        rightDis = k - j;
                        break;
                    }

                }

                if (rightDis == -1 && leftDis != -1){
                    sumTotal += leftDis;
                }
                else if (rightDis != -1 && leftDis == -1){
                    sumTotal += rightDis;
                }
                else {
                    sumTotal += (Math.min(leftDis, rightDis));
                }

            }

            System.out.println("Case #"+i+": "+sumTotal);
        }


    }
}
