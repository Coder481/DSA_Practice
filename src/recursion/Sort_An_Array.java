package recursion;

import java.util.ArrayList;
import java.util.List;

public class Sort_An_Array {

    static List<Integer> v = new ArrayList<>();

    public static void main(String[] args) {

        v.add(2);
        v.add(3);
        v.add(7);
        v.add(6);
        v.add(4);
        v.add(5);
        v.add(9);

        System.out.println("Array before sorting: "+v);

        sort(v);

        System.out.println("Array after sorting: "+v);
    }

    private static void sort(List<Integer> v) {
        if (v.size() == 1)
            return;

        int temp = v.remove(v.size()-1);
        sort(v);

        insert(v,temp);

    }

    private static void insert(List<Integer> v, int temp) {
        if (v.size()==0 || v.get(v.size()-1)<=temp){
            v.add(v.size(),temp);
            return;
        }

        int val = v.remove(v.size()-1);
        insert(v,temp);

        v.add(v.size(),val);
    }


}
