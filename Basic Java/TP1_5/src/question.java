import java.util.Scanner;

public class question {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int i;
		System.out.print("Input: ");
		i = input.nextInt();
		switch (i) {
		case 1:
			System.out.println("Un.");
			break;
		case 2:
			System.out.println("Deux.");
			break;
		case 3:
			System.out.println("Trois.");
			break;
		case 4:
			System.out.println("Quatre.");
			break;
		case 5:
			System.out.println("Cinq.");
			break;
		case 6:
			System.out.println("Six.");
			break;
		case 7:
			System.out.println("Sept.");
			break;
		case 8:
			System.out.println("Huit.");
			break;
		case 9:
			System.out.println("Neuf.");
			break;
		default:
			System.out.println("Autre.");
			break;
		}
		input.close();

	}

}
