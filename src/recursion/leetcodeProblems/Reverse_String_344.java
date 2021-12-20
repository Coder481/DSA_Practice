package recursion.leetcodeProblems;

public class Reverse_String_344 {

    public static void main(String[] args) {
        char[] s = {'a','b','c','d'};
        int mid = s.length/2;
        int i = 0;
        rev(s,i,mid);
        System.out.println(s);
    }

    private static void rev(char[] s, int i, int mid) {
        if (i==mid)
            return;

        char temp = s[i];
        s[i] = s[s.length - 1 - i];
        s[s.length - 1 - i] = temp;

        rev(s,i+1,mid);
    }

}
