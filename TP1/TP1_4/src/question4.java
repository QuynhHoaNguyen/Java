import java.util.Scanner;
public class question4 {
	public static void main(String[] args) {
		String s = args[0];
		Scanner input = new Scanner(System.in);
		s = input.nextLine();
		for (int i = 0; i < s.length(); i++) {
			
			char c = s.charAt(i);
			if (c >= 'a' && c <= 'm')
				c += 13;
			else if (c >= 'A' && c <= 'M')
				c += 13;
			else if (c >= 'n' && c <= 'z')
				c -= 13;
			else if (c >= 'N' && c <= 'Z')
				c -= 13;
			System.out.print(c);
		}
		System.out.println();
		input.close();
	}
}
