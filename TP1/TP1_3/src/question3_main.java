import java.util.Scanner;
public class question3_main {

	public static void main(String[] args) throws java.io.IOException {
		// TODO Auto-generated method stub
		//Scanner in = new Scanner(System.in);
		question3 quest = new question3();
		
		String a;
		String b;		
		
		
		System.out.println("Enter two binary numbers.");
		Scanner in = new Scanner(System.in);
		System.out.print("The fist number: ");
		a = in.nextLine();
		System.out.print("The second number: ");
		b = in.nextLine();
		//in.close();
		quest.output(a, b);
		int aa = Integer.parseInt(a);
		int bb = Integer.parseInt(b);
		
		System.out.println("\n Calcul: ");
		quest.showMenu();
		System.out.println("\n Choose one: ");
		
		int choose;
		choose = in.nextInt();
		switch (choose) {
		case 1:
			System.out.println("Sum is: " + quest.add(a, b));
			break;
		case 2:
			System.out.println(quest.sub(aa, bb));
			break;
		case 3:
			System.out.println(quest.mutiply(aa, bb));
			break;
		case 4:
			System.out.println(quest.divide(a, b));
			break;
		default:
			System.out.println("Selection not found");
			break;
		}
		in.close();

	}

}
