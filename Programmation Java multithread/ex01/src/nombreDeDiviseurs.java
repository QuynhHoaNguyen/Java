import java.io.IOException;
import java.util.*;

public class nombreDeDiviseurs {

    public static void main(String[] args) throws IOException {
	// write your code here
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Entrez un entier: ");
            int numbre = in.nextInt();
            int count = 0;
            for (int i = 1; i <= numbre / 2; i++) {
                int result = numbre % i;
                if (result == 0) {
                    count++;
                    System.out.print(i + " ");
                }
            }
            System.out.printf("\nle nombre de diviseurs of %d is %d.", numbre, count);
        }catch(ArithmeticException e){
            System.out.println("Error: divide by 0");
        }


    }
}
