import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Accounts {
    ArrayList<BankAccount> listAccount;
    Scanner input;
    File file = new File("MyAccount.txt");
    private int code = 1000;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Accounts() {
        listAccount = new ArrayList<>();
        input = new Scanner(System.in);
        if (!(file.exists())) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else if (file.length() == 0) {
            System.out.println("Fichier vide / Empty file");
        } else {
            chargerDesComptesBancaires();
        }
    }


    private void genererUnNumeroDeCompte(BankAccount account) {
        account.setNumero_de_compte(account.getNumero_de_compte() + (getCode() + (listAccount.size() - 1)));
    }

    /// TP 5 : QUESTION 1 : 1. Charger des comptes bancaires à partir d'un fichier.
    public void chargerDesComptesBancaires() {
        try {
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream(file));
            if (obj.available() != -1) {
                listAccount = (ArrayList<BankAccount>) obj.readObject();
            }
            obj.close();
            System.out.println("Charger des comptes bancaires avec succès. ");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void ajoutezNouveauCompte(BankAccount objAccount) {
        try {
            creerUncompte(objAccount);
            listAccount.add(objAccount);
            genererUnNumeroDeCompte(objAccount);
            System.out.println("--------------------------------");
            System.out.println("COMPTE CRÉÉ AVEC SUCCÈS. ");
            System.out.println("--------------------------------");
            String choice;
            System.out.println("Voulez-vous enregistrer le compte dans un fichier? ");
                System.out.print("Entrer Y ou N : ");
                choice = input.nextLine();
            if((choice.equalsIgnoreCase("y")) || (choice.equalsIgnoreCase("Y"))){
                sauvegarderDesComptesBancaires();
            }else{
                System.out.println("--------------------------------");
                System.out.println("VOTRE COMPTE N'A PAS ÉTÉ SAUVEGARDÉ.́");
                System.out.println("NOTÉ : Si vous avez oublié d'enregistrer le compte nouvellement créé, vous pouvez le faire à nouveau en sélectionnant l'option 4");
                System.out.println("--------------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /// TP 5 : QUESTION 1 : 2. Sauvegarder des comptes bancaires dans un fichier.
    public void sauvegarderDesComptesBancaires() {
        try {
            ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(file));
            obj.writeObject(listAccount);
            obj.flush();
            obj.close();
            System.out.println("--------------------------------");
            System.out.println("COMPTE SAUVEGARDÉ AVEC SUCCÈS. ");
            System.out.println("--------------------------------");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    /// TP 5 : QUESTION 1 : 3. Imprimez les informations personnelles d'un compte bancaire dans un fichier
    public void imprimezLesInfosPersonnelles() {
        try {
            String numeroDeCompte;
            System.out.println("Le numéro de compte que vous souhaitez imprimer dans un fichier ( EX : BA1000 ) : ");
            numeroDeCompte = input.nextLine();
            String nomDeFichier = "PERSON_" + numeroDeCompte + ".txt";
            boolean check = false;
            for (BankAccount account : listAccount) {
                if (account.getNumero_de_compte().equalsIgnoreCase(numeroDeCompte)) {
                    File fil = new File(nomDeFichier);
                    OutputStream outputStream = new FileOutputStream(fil);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                    outputStreamWriter.write("Numéro de compte    : " + account.getNumero_de_compte());
                    outputStreamWriter.write("\nNom et prénom       : " + account.getNom_du_deposant());
                    outputStreamWriter.write("\nAdresse             : " + account.getAdresse_du_deposant());
                    outputStreamWriter.write("\nType de compte      : " + account.getType_de_compte());
                    outputStreamWriter.write("\nNuméro de téléphone : " + account.getNumero_de_telephone());
                    outputStreamWriter.flush();
                    outputStreamWriter.close();
                    System.out.println("--------------------------------");
                    System.out.println("COMPTE IMPRIMÉ AVEC SUCCÈS. \nFILENAME : " + nomDeFichier);
                    System.out.println("--------------------------------");
                    check = true;
                }
            }
            if(check==false){
                System.out.println("--------------------------------");
                System.out.println("ERROR : COMPTE NON TROUVÉ.");
                System.out.println("--------------------------------");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deposerA() {
        try {
            String numeroDeCompte;
            double montant;
            System.out.println("Numéro de compte : ");
            numeroDeCompte = input.nextLine();
            System.out.print("Entrez le montant à déposer: ");
            montant = Double.parseDouble(input.nextLine());;
            boolean check = false;
            for (BankAccount account : listAccount) {
                if (account.getNumero_de_compte().equalsIgnoreCase(numeroDeCompte)) {
                    check = true;
                    account.deposer(montant);
                    ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(file));
                    obj.writeObject(listAccount);
                    obj.flush();
                    obj.close();
                }
            }
            if(check==false){
                System.out.println("--------------------------------");
                System.out.println("ERROR : COMPTE NON TROUVÉ.");
                System.out.println("--------------------------------");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void retirerDe() {
        try {
            String numeroDeCompte;
            Double montantRetire;
            boolean check = false;
            System.out.println("Numéro de compte : ");
            numeroDeCompte = input.nextLine();
            System.out.println("Le montant à retirer : ");
            montantRetire = Double.parseDouble(input.nextLine());
            for (BankAccount account : listAccount) {
                if (account.getNumero_de_compte().equalsIgnoreCase(numeroDeCompte)) {
                    check = true;
                    account.retirer(montantRetire);
                    ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(file));
                    obj.writeObject(listAccount);
                    obj.flush();
                    obj.close();
                }
            }
            if(check==false){
                System.out.println("--------------------------------");
                System.out.println("ERROR : COMPTE NON TROUVÉ.");
                System.out.println("--------------------------------");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void afficher_informations_tout_deposant() {
        for (BankAccount account : listAccount) {
            account.afficher_les_informations();
        }
    }

    public void chercherUnElement() {
        try{
            System.out.println("Entrez les informations de compte que vous souhaitez rechercher.");
            System.out.print("\n + Le nom : ");
            String nom = input.nextLine();
            System.out.print("\n + Le numéro de téléphone : ");
            String numeroDeTelephone = input.nextLine();
            System.out.print("\n + Le numéro de compte : ");
            String numeroDeCompte = input.nextLine();
            boolean check = false;
            for (BankAccount account : listAccount) {
                if (account.getNom_du_deposant().equalsIgnoreCase(nom) && account.getNumero_de_telephone().equalsIgnoreCase(numeroDeTelephone) && account.getNumero_de_compte().equalsIgnoreCase(numeroDeCompte)) {
                    account.afficher_les_informations();
                }
                check = true;
            }
            if(!check){
                System.out.println("--------------------------------");
                System.out.println("ERROR : COMPTE NON TROUVÉ.");
                System.out.println("--------------------------------");
            }
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public void creerUncompte(BankAccount account) {
        try {
            System.out.println("Entrer  Nom du déposant : ");
            account.setNom_du_deposant(input.nextLine());
            System.out.println("Enter Adresse du déposant : ");
            account.setAdresse_du_deposant(input.nextLine());
            int choice ;
            System.out.println("Type de compte ( Entrer [1-3] ) : \n 1 : compte sur livret \n 2 : Compte d’épargne \n 3 : Compte titre"); //compte sur livret, compte d’épargne, compte à vue, compte titre

            do {
                choice = Integer.parseInt(input.nextLine());
                if(choice<1 || choice >3) {
                    System.out.println("Entrer error ! Entrer une fois !");
                }
            }while (choice<1 || choice >3);
            switch(choice) {
                case 1:
                    account.setType_de_compte("Compte sur livret");
                    break;
                case 2:
                    account.setType_de_compte("Compte d’épargne");
                    break;
                case 3:
                    account.setType_de_compte("Compte titre");
                    break;
            }
            System.out.println("Enter Numéro de téléphone : ");
            account.setNumero_de_telephone(input.nextLine());
            System.out.println("Enter Solde en compte : ");
            account.setSolde_en_compte(Double.parseDouble(input.nextLine()));
            System.out.println("Enter Nombre des transactions : ");
            account.setNombre_des_transactions(Integer.parseInt(input.nextLine()));
        } catch (InputMismatchException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

    //////Modifiez un compte bancaire.
    public void modifiezUnCompte() {
        try {
            System.out.println("Entrez le numéro de compte que vous souhaitez modifier : ");
            String numeroDeCompte = input.nextLine();
            boolean check = false;
            for (BankAccount account : listAccount) {
                if (account.getNumero_de_compte().equalsIgnoreCase(numeroDeCompte)) {
                    System.out.println("Retapez les informations que vous souhaitez modifier ( EX : BA1000 ) : ");
                    creerUncompte(account);
                    System.out.println("--------------------------------");
                    System.out.println("COMPTE MODIFIÉ AVEC SUCCÈS.");
                    System.out.println("--------------------------------");
                    check = true;
                }
            }
            if(!check){
                System.out.println("--------------------------------");
                System.out.println("ERROR : COMPTE NON TROUVÉ.");
                System.out.println("--------------------------------");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    ///// TP 5 : QUESTION 1 : 4 . Imprimez des transactions d'un compte bancaire dans un fichier

    public void imprimezDesTransactions() {
        try {
            System.out.println("Le numéro de compte que vous souhaitez imprimer dans un fichier ( EX : BA1000 ) : ");
            String numeroDeCompte = input.nextLine();
            String nomDeFichier = "TRANS_" + numeroDeCompte + ".txt";
            boolean check = false;
            Transaction trans = new Transaction();
            for (BankAccount account : listAccount) {
                if (account.getNumero_de_compte().equalsIgnoreCase(numeroDeCompte)) {
                    double soldeInital = account.getSolde_en_compte();
                    trans.creerUneOperation(account);
                    double soldeFinal = account.getSolde_en_compte();
                    Formatter output = new Formatter(nomDeFichier);

                    output.format("\tNuméro de compte : %s" +
                                    "\n\tNom et prénom : %s" +
                                    "\nDate \t\t\t\tOpération \t\t\t\tDébit \t\t\tCrédit" +
                                    "\n--------------------------------------------------------------------------------------------------------" +
                                    "\nSold initial                                                                                    %f" +
                                    "\n--------------------------------------------------------------------------------------------------------" +
                                    "\n%s \t\t|\t%s \t\t\t|\t%f \t|\t%f" +
                                    "\n--------------------------------------------------------------------------------------------------------" +
                                    "\nTotal des opérations                                    " +
                                    "\n--------------------------------------------------------------------------------------------------------" +
                                    "\nSolde final                                                                                     %f",
                            account.getNumero_de_compte(), account.getNom_du_deposant(), soldeInital, trans.getDate(),
                            trans.getOperation(), trans.getDebit(), trans.getCredit(), soldeFinal);
                    output.flush();
                    output.close();
                    System.out.println("COMPTE IMPRIMMÉ AVEC SUCCÈS. FILENAME : " + nomDeFichier);
                    check = true;
                }
            }
            if (!check) {
                System.out.println("--------------------------------");
                System.out.println("ERROR : COMPTE NON TROUVÉ.");
                System.out.println("--------------------------------");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}