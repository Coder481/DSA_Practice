package stackDS.problems;


import globalClasses.Pair;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * MAH -> Maximum Area Histogram
 *
 * The main concept behind this problem is that
 *  We have to find the index of the NSL elements as well as NSR elements
 */
public class MAH {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        print("Enter heights in positive integer with space:");
        String[] arr = sc.nextLine().split("\\s+");

        List<Integer> nslIndex = new ArrayList<>();   // Store index of all nearest smaller elements to left
        List<Integer> nsrIndex = new ArrayList<>();   // Store index of all nearest smaller elements to right

        Stack<Pair<Integer,Integer>> leftS = new Stack<>();
        Stack<Pair<Integer,Integer>> rightS = new Stack<>();

        int leftPI = -1;           // Pseudo Index for NSL
        int rightPI = arr.length; // Pseudo Index for NSR

        for (int i=0; i< arr.length; i++){
            int j = (arr.length - 1) - i;

            int arrI = Integer.parseInt(arr[i]);
            int arrJ = Integer.parseInt(arr[j]);

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
                .mapToObj(i -> Integer.parseInt(arr[i]) * (nsrIndex.get(i) - nslIndex.get(i) - 1))
                .collect(Collectors.toList());

        int max = Collections.max(areaList);

        print("Maximum area is: "+max);

    }

    private static void print(String s){
        System.out.print(s);
    }
}
