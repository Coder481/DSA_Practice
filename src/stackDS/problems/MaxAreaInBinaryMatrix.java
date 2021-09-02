package stackDS.problems;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxAreaInBinaryMatrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        print("Enter number of rows (n):");
        int n = sc.nextInt();

        print("Enter number of columns (m):");
        int m = sc.nextInt();

        Integer[][] arr = new Integer[n][m];

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                print("Enter element ("+i+","+j+"):");
                arr[i][j] = sc.nextInt();
            }
        }

        Integer[] v = new Integer[n];

        System.arraycopy(arr[0], 0, v, 0, m);

        int max = MAH(v);

        for (int i=1; i<n; i++){
            for (int j=0; j<m; j++){
                if (arr[i][j] == 0) v[j] = 0;
                else v[j] = v[j] + arr[i][j];
            }

            max = Math.max(max, MAH(v));
        }

        print("Maximum area is:"+max);
    }

    private static int MAH(Integer[] arr){
        List<Integer> nslIndex = new ArrayList<>();   // Store index of all nearest smaller elements to left
        List<Integer> nsrIndex = new ArrayList<>();   // Store index of all nearest smaller elements to right

        Stack<Pair<Integer,Integer>> leftS = new Stack<>();
        Stack<Pair<Integer,Integer>> rightS = new Stack<>();

        int leftPI = -1;           // Pseudo Index for NSL
        int rightPI = arr.length; // Pseudo Index for NSR

        for (int i=0; i< arr.length; i++){
            int j = (arr.length - 1) - i;

            int arrI = arr[i];
            int arrJ = arr[j];

            // Code for NSL
            // This code will save the indexes of nearest smaller elements to the left
            if (leftS.size() == 0) nslIndex.add(leftPI);
            else if (leftS.size()>0 && leftS.peek().getKey()<arrI) nslIndex.add(leftS.peek().getValue());
            else if (leftS.size()>0 && leftS.peek().getKey()>=arrI){
                while (leftS.size()>0 && leftS.peek().getKey()>=arrI) leftS.pop();

                if (leftS.size() == 0) nslIndex.add(leftPI);
                else nslIndex.add(leftS.peek().getValue());
            }
            leftS.push(new Pair<>(arrI,i));



            // Code for NSR
            // This code will save the indexes of nearest smaller elements to the right
            if (rightS.size() == 0) nsrIndex.add(rightPI);
            else if (rightS.size()>0 && rightS.peek().getKey()<arrJ) nsrIndex.add(rightS.peek().getValue());
            else if (rightS.size()>0 && rightS.peek().getKey()>=arrJ){
                while (rightS.size()>0 && rightS.peek().getKey()>=arrJ) rightS.pop();

                if (rightS.size() == 0) nsrIndex.add(rightPI);
                else nsrIndex.add(rightS.peek().getValue());
            }
            rightS.push(new Pair<>(arrJ,j));

        }

        Collections.reverse(nsrIndex);

        /*int area = 0;
        for (int i=0; i< arr.length; i++){
            int width = nsrIndex.get(i) - nslIndex.get(i) - 1;
            int temp = width * Integer.parseInt(arr[i]);

            if (temp>area) area = temp;

        }*/

        List<Integer> areaList = IntStream.range(0, arr.length)
                .mapToObj(i -> arr[i] * (nsrIndex.get(i) - nslIndex.get(i) - 1))
                .collect(Collectors.toList());

        int max = Collections.max(areaList);

        return max;
    }

    private static void print(String s){
        System.out.print(s);
    }

}
