package unionAndFind;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Implementation {

    static int[] rank ;
    static int[] parent ;

    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int start=k-1
                ,end=n-1
                ,startSum=0
                ,endSum=0
                ,totalSum=0
                ,result;

        for(int i=0;i<k;i++)
            startSum +=cardPoints[i];

        if(n==k)
            return startSum;

        result=startSum;
        while(start>=0 && end>=n-k){
            startSum -=cardPoints[start];
            endSum +=cardPoints[end];
            totalSum=startSum+endSum;
            result=Math.max(result,totalSum);

            start--;
            end--;
        }

        return result;
    }
    public static void main(String[] args) {


        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','1'}
                };

        int rows = grid.length;
        int cols = grid[0].length;

        prepare(rows*cols);

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){


                if(i>0 && grid[i-1][j]=='1') union(i*rows+j, (i-1)*rows+j);
                if(j>0 && grid[i][j-1]=='1') union(i*rows+j, i*rows+(j-1));

            }
        }

        System.out.println("Parent: "+Arrays.toString(parent));
//        System.out.println();

        Set<Integer> set = new HashSet<>();
        for(int i=0; i<rows*cols; i++){
            if(parent[i]!=i)
                set.add(findPar(i));
        }

        System.out.println("Result:"+set.size());
    }

    static int findPar(int node){
        if(parent[node] == node)
            return node;
        return parent[node] = findPar(parent[node]);
    }

    static void union(int u, int v){
        u = findPar(u);
        v = findPar(v);

        if(rank[u] < rank[v])
            parent[u] = v;
        else if(rank[v] < rank[u])
            parent[v] = u;
        else{
            parent[v] = u;
            rank[u]++;
        }
    }

    static void prepare(int n){
        rank = new int[n];
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }
}
