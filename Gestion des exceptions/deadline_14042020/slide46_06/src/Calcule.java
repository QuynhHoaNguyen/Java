import java.util.Scanner;

public class Calcule {

	public static void genException() {
		int a[] = { 4, 8, 16, 32, 64, 128, 256, 512 };
		int b[] = { 2, 0, 4, 4, 0, 8 };

		try {

			System.out.print("Enter the calculation you want to perform: ");
			Scanner in = new Scanner(System.in);
			char m = in.next().charAt(0);
			for (int i = 0; i < a.length; i++) {
				if((m != '+') &&  (m != '-') && (m != '*') && (m != '/') ) {
					throw new IllegalArgumentException("invalid values");
				}
				try {
					if (m == '+') {
						System.out.println(a[i] + " + " + b[i] + " is " + (a[i] + b[i]));
					}
					if (m == '-') {
						System.out.println(a[i] + " - " + b[i] + " is " + (a[i] - b[i]));
					}
					if (m == '*') {
						System.out.println(a[i] + " * " + b[i] + " is " + (a[i] * b[i]));
					}
					if (m == '/') {
						System.out.println(a[i] + " / " + b[i] + " is " + (a[i] / b[i]));
					}
					
				} catch (ArithmeticException exc) {
					System.out.println("Can't divide by Zero!");

				} catch (NullPointerException exc) {
					System.out.println("Invalid use of a null reference");
					throw exc;
				} 
				in.close();
			}

		} catch (ArrayIndexOutOfBoundsException exc) {
			System.out.println("No matching element found.");
			
		}catch (IllegalArgumentException exc) {
			System.out.println("invalid values");
		}
	}
}
