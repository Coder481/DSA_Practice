package z_labWork.fileHandler.fileInputStream;

import java.io.FileInputStream;
import java.io.IOException;

public class B_ReadCompleteString {

    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream(
                    "C:\\EDrive\\Class Notes\\Sem5\\Java\\FileHandler\\WriteCompleteString.txt"
            );

            StringBuilder s = new StringBuilder();
            int i ;
            while ((i = fin.read()) != -1){
                s.append((char) i);
            }
            System.out.println(s);

            fin.close();
            System.out.println("Success");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
