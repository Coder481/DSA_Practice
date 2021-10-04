package heap.leetcodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class K_Pairs_with_Smallest_Sum_373 {

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3};
        int k = 3;

        PriorityQueue<int[]> maxH = new PriorityQueue<>((a,b)->b[0]-a[0]);

        int i=0;
        int j=0;

        while (maxH.size()<=k && i< nums1.length){
            maxH.add(new int[]{nums1[i]+nums2[j],nums1[i],nums2[j]});
            j+=1;

            if (j>= nums2.length){
                i+=1;
                j = 0;
            }

            if (maxH.size()>k)
                maxH.poll();
        }

        /*for (Integer n1 : nums1){
            for (Integer n2 : nums2){
                maxH.add(new int[]{});
                if (maxH.size()>k)
                    maxH.poll();
            }
        }*/

        List<List<Integer>> res = new ArrayList<>();
        while (maxH.size()>0) {
            res.add(Arrays.asList(maxH.peek()[1], maxH.peek()[2]));
            maxH.poll();
        }

        System.out.println(res);
    }

}
class Pair<L,R> {

    private final L left;
    private final R right;

    public Pair(L left, R right) {
        assert left != null;
        assert right != null;

        this.left = left;
        this.right = right;
    }

    public L getLeft() { return left; }
    public R getRight() { return right; }

    @Override
    public int hashCode() { return left.hashCode() ^ right.hashCode(); }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) return false;
        Pair pairo = (Pair) o;
        return this.left.equals(pairo.getLeft()) &&
                this.right.equals(pairo.getRight());
    }

}
