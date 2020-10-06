
import java.util.*; //thu vien dung lop Scanner

public class bt1 {
	public static void main(String[] args) {
		String nom, prenom, adresse;
		int date, month, year; 
		Scanner inp = new Scanner(System.in);
		System.out.println("Nom: ");
		nom = inp.nextLine();
		System.out.println("Prenom: ");
		prenom = inp.nextLine();
		System.out.println("Adresse: ");
		adresse = inp.nextLine();
		System.out.println("date: ");
		date = inp.nextInt();
		System.out.println("month: ");
		month = inp.nextInt();
		System.out.println("year: ");
		year = inp.nextInt();
		
		System.out.printf("Nom: %s \n", nom);
		System.out.printf("Prenom: %s \n", prenom);
		System.out.printf("Adresse: %s \n", adresse);
		System.out.printf("Date: %d \n", date);
		System.out.printf("Month: %d \n", month);
		System.out.printf("Year: %d \n", year);
		
		inp.close();
	}
}

