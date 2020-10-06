package MyDateTime;

//import java.util.Scanner;

public class Question5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyDate date = new MyDate();
		MyDate d1 = new MyDate(28, 12, 2019);
		MyDate d2 = new MyDate(10, 04, 2020);
		System.out.println("Le jour 1: " + d1);
		System.out.println("Le jour 2: " + d2 + "\n");
		

		System.out.println("2. Comparez deux objets MyDate");
		if (date.comparez(d1, d2) == 1) {
			System.out.println("Le jour 1 est avant le jour 2.\n");
		}
		if (date.comparez(d1, d2) == -1) {
			System.out.println("Le jour 1 est après le jour 2.\n");
		}
		if (date.comparez(d1, d2) == 0) {
			System.out.println("Est un jour.\n");
		}
		
		System.out.println("3. Vérifiez si une date est valide.");
		if(date.checkDate(d1) == false) {
			System.out.println("La date n'est pas valide.\n");
		}
		else {
			System.out.println("valide.\n");
		}
		
		System.out.println("4. Calculez la distance entre deux dates générées à partir de MyDate.");
		System.out.println("La distance entre les deux dates est " + date.distance(d1, d2) + " jours.\n");
		
		System.out.println("6. Affichage de la date");
		System.out.println(date.toString("02/11/1998"));
		System.out.println(date.toString("01/10/97"));
		System.out.println(date.toString("3030-12-24"));
		
	}

}
