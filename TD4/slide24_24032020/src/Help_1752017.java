
public class Help_1752017 {
	void helpOn(int what) throws java.io.IOException {
		// Afficher les informations d'aide en fonction du choixd'un utilisateur
		switch (what) {
		case 1:
			System.out.println("The if: \n if(condition) statement; \t \n else statement;");
			break;
		case 2:
			System.out.println(
					"The switch: \n switch(expression){ \n \t case constant; \n \t statement squence \n \t break; \n \t // ... \n }");
			break;
		case 3:
			System.out.println("The for: \n for(init; condition; teration){ \n \t statement; \n");
			break;
		case 4:
			System.out.println("The while: \n while(condition) statement; \n");
			break;
		case 5:
			System.out.println("The do ... while:\n do{ \n    statement; \n}while (condition); \n");
			break;
		case 6:
			System.out.println(
					"The break: \n for(init; condition; teration){ \n    if(condition) break; \n    statement; \n } \n statement; \n }");
			break;
		case 7:
			System.out.println(
					"The continue: \n for(init; condition; teration){ \n    if(condition) continue; \n    statement; \n } \n statement; \n }");
			break;
		}
	}

	void showMenu() {
		// Afficher l'option de menu
		System.out.println("\n\nHelp on: ");
		System.out.println("1. if: ");
		System.out.println("2. switch: ");
		System.out.println("3. for: ");
		System.out.println("4. while: ");
		System.out.println("5. do ... while ");
		System.out.println("6. break: ");
		System.out.println("7. continue: ");
		System.out.println("Choose one (q to quit): ");
	}

	boolean isValid(int choice) throws java.io.IOException {
		// Vérifier une réponse valide
		if ((choice > 0) & (choice < 8))
			return true;
		else
			return false;
	}
}
