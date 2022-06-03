package recursion.permutations;

public class All_Permutations_of_a_String {

    public static void main(String[] args) {

        String s = "abc";
//        printAllPermutations(s,0,s.length()-1);
        solve(s,"");
    }



    private static void solve(String ip, String op){
        if(ip.length() == 0) {
            System.out.println(op);
            return;
        }
        for(int i=0; i<ip.length(); i++){
            String tempOP = op+ip.charAt(i);
            String tempIP = ip.substring(0,i) + ip.substring(i+1);
            solve(tempIP,tempOP);
        }
    }


    private static void printAllPermutations(String s, int l, int r) {
        if (l==r){
            System.out.println(s);
            return;
        }

        for (int i = l; i <= r ; i++) {
            s = String.valueOf(swap(s,l,i));
            printAllPermutations(s,l+1,r);
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
