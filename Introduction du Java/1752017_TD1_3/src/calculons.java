import java.util.Scanner;

public class calculons {
	public static void main(String[] args) {
		double numbre;
		Scanner inp = new Scanner(System.in);
		System.out.println("un numbre: ");
		numbre = inp.nextDouble();
		System.out.println("numbre: " + numbre);
		double _racineCarree;
		_racineCarree  = Math.sqrt(numbre);
		System.out.println("la racine carrée: " + _racineCarree);
		double num_arrondi;
		num_arrondi = Math.round(_racineCarree * 1000) / 1000;
		System.out.println("numbre d'arrondi: " + num_arrondi);
		double erreur_darrondi;
		erreur_darrondi = _racineCarree - num_arrondi;
		System.out.println("l'erreur d'arrondi: " + erreur_darrondi);
		inp.close();
	}
}
