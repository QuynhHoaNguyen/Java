import java.io.*;
import java.util.*;

public class ShowIndex {
    public static void main(String args[]) throws IOException {
        int data, data2;
        int d;
        try (
                FileInputStream fin = new FileInputStream("file1.txt");
                FileInputStream fin2 = new FileInputStream("file2.txt");
                ) {
                do {
                    data = fin.read();
                    data2 = fin2.read();
                    if (data != -1 && data2 != -1){
                        System.out.println("The content of the two files is the same"); break;
                    }
                    else if(data == -1 || data2 == -1 || data != data2){

                    }

                    System.out.println(data + " " + data2);
                }while ((data != -1) && (data2 != -1));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
