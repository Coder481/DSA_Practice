package recursion.leetcodeProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Permutation_Sequence_60 {

    private static List<Integer> arr;

    public static void main(String[] args) {

//        String s = "123";

        String res1 = getPermutation(3,5);

        System.out.println(res1);

    }

    public static String getPermutation(int n, int k) {

        arr = new ArrayList<>();

        List<Integer> list = IntStream.range(1,n+1).boxed().collect(Collectors.toList());
        String s = list.stream().map(String::valueOf).collect(Collectors.joining());


        allPermutations(s,0,s.length()-1);

        Collections.sort(arr);

        return arr.get(k-1)+"";
    }

    private static void allPermutations(String s, int l, int r) {

        if (l==r){
            arr.add(Integer.parseInt(s));
            return;
        }

        for (int i = l; i <= r ; i++) {
            s = String.valueOf(swap(s,l,i));
            allPermutations(s,l+1,r);
            s = String.valueOf(swap(s,l,i));
        }

    }

    private static char[] swap(String s, int l, int i) {
        char cl = s.charAt(l);
        char ci = s.charAt(i);

        char[] arr = s.toCharArray();
        arr[i] = cl;
        arr[l] = ci;

        return arr;
    }


}
