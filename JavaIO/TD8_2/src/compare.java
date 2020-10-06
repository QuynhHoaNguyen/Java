import java.io.*;
public class compare {
    public static void main(String args[]) throws FileNotFoundException, IOException{
        int data;
        try (
                FileInputStream fin = new FileInputStream("file1.txt");)
        {
            do {
                data = fin.read();
                if(data == -1 || data != data){
                    System.out.println("The content of the two files is different"); break;
                }
                else if (data == -1 && data == -1){
                    System.out.println("The content of the two files is the same"); break;
                }
            }while ((data != -1) && (data != -1));
        } catch (FileNotFoundException e){
            System.out.println("FileNotFoundException");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
