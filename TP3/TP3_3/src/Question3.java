import java.util.Scanner;

public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nomInverse numInv = new nomInverse();
		
		Scanner in = new Scanner(System.in);
		System.out.print("Entrer un nentier non negatif: ");
		numInv.num = in.nextInt();
		if (numInv.num < 0) {
			System.out.println("\nUn entier non negatif, svp!");
		} else {
			System.out.print("\nNombre inverse est: ");
			numInv.sortie(numInv.num);
		}
		in.close();
	}
}
