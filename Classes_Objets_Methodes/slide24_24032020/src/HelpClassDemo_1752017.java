public class HelpClassDemo_1752017 {
	public static void main(String args[]) throws java.io.IOException {
		Help_1752017 helpClass = new Help_1752017();
		char ignore, answer = 'q';
		int choice;
		do {
			helpClass.showMenu();
			choice = (char) System.in.read();
			do {
				ignore = (char) System.in.read();
			} while (ignore != '\n');
			if (choice == answer) {
				System.out.println("Exit program");
				break;
			}
			int real_choice = choice - 48;
			if (helpClass.isValid(real_choice) == true) {
				System.out.println("***right***");
				helpClass.helpOn(real_choice);
			} else
				System.out.println("Selection not found");
		} while (true);

	}
}
