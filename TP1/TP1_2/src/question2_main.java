import java.util.Scanner;
public class question2_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		question2 quest = new question2();
		int dec;
		Scanner in = new Scanner(System.in);
		
		System.out.println("enter the decimal to be converted: ");
		dec = in.nextInt();
		System.out.println("The binary of the given number is:" + quest.DecToBinary(dec));
		System.out.println("The octal of the given number is: " + quest.DecToOct(dec));
		System.out.println("The hexadecimal of the given number is: ");
		quest.DecToHex(dec);
		in.close();
	}

}
