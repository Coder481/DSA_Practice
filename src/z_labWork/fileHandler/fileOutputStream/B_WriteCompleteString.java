package z_labWork.fileHandler.fileOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class B_WriteCompleteString {

    public static void main(String[] args) {
        try {
            FileOutputStream fout = new FileOutputStream(
                    "C:\\EDrive\\Class Notes\\Sem5\\Java\\FileHandler\\WriteCompleteString.txt"
            );

            String s = "My Name Is Hrithik Sharma";
            fout.write(s.getBytes());
            fout.flush();
            fout.close();
            System.out.println("Success");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
