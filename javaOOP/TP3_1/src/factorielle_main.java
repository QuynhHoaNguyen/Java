import java.util.Scanner;
public class factorielle_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		factorielle fact = new factorielle();
		Scanner in = new Scanner(System.in);
		int n, k;
		System.out.print("Entrer n: ");
		n = in.nextInt();
		System.out.print("Entrer k: ");
		k= in.nextInt();
		
		double c;
		c = fact.valeur(n) / ((fact.valeur(n - k) * fact.valeur(k)));
		System.out.print("resultats: " + c);
		in.close();
	}

}
