import java.util.Scanner;

public class Help_1752017 {
	public static void main(String[] args) throws java.io.IOException {
		String i;
		Scanner inp = new Scanner(System.in);
		System.out.println(
				"Help on: \n \t 1. if \n \t 2. swich \n \t 3. for \n\t 4. while \n\t 5. do ... while \n\t 6. break \n\t 7. continue \n Choose one (q to quit) :");
		i = inp.nextLine();
		switch (i) {
		case "1":
			System.out.println("The if: \n if(condition) statement; \t \n else statement;");
			break;
		case "2":
			System.out.println(
					"The switch: \n switch(expression){ \n \t case constant; \n \t statement squence \n \t break; \n \t // ... \n }");
			break;
		case "3":
			System.out.println("The for: \n for(init; condition; teration){ \n \t statement; \n");
			break;
		case "4":
			System.out.println("The while: \n while(condition) statement; \n");
			break;
		case "5":
			System.out.println("The do ... while:\n do{ \n    statement; \n}while (condition); \n");
			break;
		case "6":
			System.out.println(
					"The break: \n for(init; condition; teration){ \n    if(condition) break; \n    statement; \n } \n statement; \n }");
			break;
		case "7":
			System.out.println(
					"The continue: \n for(init; condition; teration){ \n    if(condition) continue; \n    statement; \n } \n statement; \n }");
			break;
		case "q":
			System.out.println("Quit!!!");
			break;
		default:
			System.out.println("Selection not found");
			break;
		}
		inp.close();
	}
}
