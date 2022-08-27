package z_labWork.fileHandler.fileOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class A_WriteSpecificByte {

    public static void main(String[] args) {
        try {
            FileOutputStream fout = new FileOutputStream(
                    "C:\\EDrive\\Class Notes\\Sem5\\Java\\FileHandler\\WriteSpecificByte.txt"
            );

            fout.write(65);
            fout.flush();
            fout.close();
            System.out.println("Success");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
