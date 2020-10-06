import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        try {
            int choice;
            Scanner in = new Scanner(System.in);
            Accounts accounts = new Accounts();
            BankAccount bankaccount = new BankAccount();

            do {
                System.out.println("1. Chargez les données des comptes bancaires à partir d'un fichier.");
                System.out.println("2. Ajoutez un nouveau compte bancaire.");
                System.out.println("3. Modifiez un compte bancaire.");
                System.out.println("4. Sauvegardez les comptes bancaires de votre programme dans un fichier.");
                System.out.println("5. Imprimez les informations personnelles d'un compte bancaire dans un fichier.");
                System.out.println("6. Imprimez des transactions d'un compte bancaire dans un fichier.");
                System.out.println("7. Quittez.");
                System.out.print("Entrez la sélection: ");

                choice = Integer.parseInt(in.nextLine());

                switch (choice) {
                    case 1:
                        accounts.chargerDesComptes();
                        break;
                    case 2:
                        accounts.NouveauCompte(bankaccount);
                        break;
                    case 3:
                        accounts.modifiezUnCompte();
                        break;
                    case 4:
                        accounts.sauvegarderDesComptes();
                        break;
                    case 5:
                        accounts.InfosPersonnelles();
                        break;
                    case 6:
                        accounts.imprimezDesTransactions();
                        break;
                    case 7:
                        System.exit(0);
                        break;
                }
            } while (true);
            //in.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
