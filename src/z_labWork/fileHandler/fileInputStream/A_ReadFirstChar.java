package z_labWork.fileHandler.fileInputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class A_ReadFirstChar {

    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream(
                    "C:\\EDrive\\Class Notes\\Sem5\\Java\\FileHandler\\WriteCompleteString.txt"
            );

            int i = fin.read();
            System.out.println((char)i);

            fin.close();
            System.out.println("Success");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
