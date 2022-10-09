package z_labWork.sem6.competitiveCoding;

public class SequencePrint {

    public static void main(String[] args) {

        int dif = 1;
        int numberOfItems  =50;
        for(int i=0; i<=numberOfItems; i++){
            dif += i;
            System.out.print((dif+i)+" ");
        }

    }

}
