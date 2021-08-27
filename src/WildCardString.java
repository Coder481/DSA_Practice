/**
 * Print all the possible binary string replacing wildcards (?)
 * Example
 *      we have a string s = 110?00?10
 *      now what we have to output is
 *                  110 0 00 0 10   (without spaces)
 *                  110 0 00 1 10
 *                  110 1 00 0 10
 *                  110 1 00 1 10
 *
 *      Note: spaces are just used to clarify the output
 */
public class WildCardString {

    public static void main(String[] args) {

        String inputStr = "101?11?010?1";
        String temp = inputStr;

        int n = (int) inputStr.chars().filter(ch -> ch=='?').count();

        String[] binArray = new String[(int) Math.pow(2,n)];

        for (int i = 0; i < Math.pow(2, n); i++) {
            String binStr = String.format("%" + n + "s", Integer.toBinaryString(i)).replaceAll(" ", "0");
            binArray[i] = binStr;
        }

        for (String binNum : binArray){

            for (Character c : binNum.toCharArray()){
                inputStr = inputStr.replaceFirst("\\?",c.toString());
            }
            printLn(inputStr);
            inputStr = temp;
        }

    }

    private static void printLn(String s){
        System.out.println(s);
    }
}
