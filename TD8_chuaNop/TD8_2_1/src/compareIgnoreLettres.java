import java.io.*;
public class compareIgnoreLettres {
    public static void main(String args[]) throws IOException{
        int data, data2;
        try (
                FileInputStream fin = new FileInputStream("file1.txt");
                FileInputStream fin2 = new FileInputStream("file1.txt");)
        {
            do {
                data = fin.read();
                data2 = fin2.read();
                if((65 < data && data < 90 && 97 < data && data < 122) && (65 < data2 && data2 < 90 && 97 < data2 && data2 < 122)){
                    data = 32;
                    data2 = 32;
                }
                if(data == -1 || data2 == -1 || data != data2){
                    System.out.println("The content of the two files is different"); break;
                }
                else if (data == -1 && data2 == -1){
                    System.out.println("The content of the two files is the same"); break;
                }
            }while ((data != -1) && (data2 != -1));
        } catch (FileNotFoundException e){
            System.out.println("FileNotFoundException");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
