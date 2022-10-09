import java.util.*;
import java.util.stream.Collectors;

public class Numbers_With_Repeated_Digits_1012 {

    public static void main(String[] args) {

        int n = 20;
        int count = 0;

        for (int i=1; i<=n; i++){
            String iStr = ""+i;
            Set<Character> set = iStr.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());

            System.out.println(iStr+" -> "+set);

            if (set.size() < iStr.length())
                count++;
        }

        System.out.println("Count "+count);

    }
}
