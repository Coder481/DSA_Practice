package z_labWork.fileHandler.fileOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class C_Write1To10Numbers {

    public static void main(String[] args) {
        try {
            FileOutputStream fout = new FileOutputStream(
                    "C:\\EDrive\\Class Notes\\Sem5\\Java\\FileHandler\\Write1To10Numbers.txt"
            );

            for (int i=1; i<=10; i++){
                fout.write(String.valueOf(i).getBytes());
            }

            fout.flush();
            fout.close();
            System.out.println("Success");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
