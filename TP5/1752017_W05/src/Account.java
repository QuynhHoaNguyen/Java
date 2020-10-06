import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

class Accounts {
    ArrayList<BankAccount> listAccount;
    Scanner in;
    File file = new File("Account.txt");
    private int code = 1000;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Accounts() {
        listAccount = new ArrayList<>();
        in = new Scanner(System.in);
        if (!(file.exists())) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e);
            }
        } else if (file.length() == 0) {
            System.out.println("Empty file");
        } else {
            chargerDesComptes();
        }
    }
    private void genererUnNumero(BankAccount bankaccount) {
        bankaccount.setI_noDeCompte(bankaccount.getI_noDeCompte() + (getCode() + listAccount.size() - 1));
    }

    /*1*/

    //1
    public void chargerDesComptes()  {
        try{
            ObjectInputStream objIS = new ObjectInputStream(new FileInputStream(file));
            if (objIS.available() != -1) {
                listAccount = (ArrayList<BankAccount>) objIS.readObject();
            }
            objIS.close();
            System.out.println("SUCCES. ");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void NouveauCompte(BankAccount bankaccount) {
        try {
            creerUncompte(bankaccount);
            listAccount.add(bankaccount);
            genererUnNumero(bankaccount);
            System.out.println(" \nSUCCES.\n ");
            String choice;
            System.out.println(" Enregistrer le compte? ");
            System.out.print(" Oui ou Non: ");
            choice = in.nextLine();
            if((choice.equalsIgnoreCase("oui")) || (choice.equalsIgnoreCase("Oui")) || (choice.equalsIgnoreCase("OUI"))){
                sauvegarderDesComptes();
            }else{
                System.out.println("\nvotre compte n'a pas ete sauvegarde.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //2
    public void sauvegarderDesComptes() {
        try {
            ObjectOutputStream objOS = new ObjectOutputStream(new FileOutputStream(file));
            objOS.writeObject(listAccount);
            objOS.flush();
            objOS.close();
            System.out.println(" \nSUCCES.\n ");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //3
    public void InfosPersonnelles() {
        try {
            String numeroDeCompte;
            System.out.println("Le numero de compte: ");
            numeroDeCompte = in.nextLine();
            String nomFichier = numeroDeCompte + ".txt";
            boolean flag = false;
            for (BankAccount account : listAccount) {
                if (account.getI_noDeCompte().equalsIgnoreCase(numeroDeCompte)) {
                    File fil = new File(nomFichier);
                    OutputStream outputStream = new FileOutputStream(fil);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                    outputStreamWriter.write("Numero de compte    : " + account.getI_noDeCompte());
                    outputStreamWriter.write("\nNom et prenom       : " + account.getI_nom());
                    outputStreamWriter.write("\nAdresse             : " + account.getI_adresse());
                    outputStreamWriter.write("\nType de compte      : " + account.getI_typeDeCompte());
                    outputStreamWriter.write("\nNumero de telephone : " + account.geti_numTelephone());
                    outputStreamWriter.flush();
                    outputStreamWriter.close();
                    System.out.println(" SUCCES " + nomFichier + "\n");
                    flag = true;
                }
            }
            if(flag == false){
                System.out.println("\nerror : compte non trouve.\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void retirerDeX() {
        try {
            String numeroDeCompte;
            Double montantRetire;
            boolean flag = false;
            System.out.println("Numero de compte : ");
            numeroDeCompte = in.nextLine();
            System.out.println("Le montant a retirer : ");
            montantRetire = Double.parseDouble(in.nextLine());
            for (BankAccount account : listAccount) {
                if (account.getI_noDeCompte().equalsIgnoreCase(numeroDeCompte)) {
                    flag = true;
                    account.retirer(montantRetire);
                    ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(file));
                    obj.writeObject(listAccount);
                    obj.flush();
                    obj.close();
                }
            }
            if(flag == false){
                System.out.println("error : compte non trouve.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deposerA() {
        try {
            String numeroDeCompte;
            double montant;
            System.out.println("Numero de compte: ");
            numeroDeCompte = in.nextLine();
            System.out.print("Entrez le montant: ");
            montant = Double.parseDouble(in.nextLine());;
            boolean flag = false;
            for (BankAccount account : listAccount) {
                if (account.getI_noDeCompte().equalsIgnoreCase(numeroDeCompte)) {
                    flag = true;
                    account.deposer(montant);
                    ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(file));
                    obj.writeObject(listAccount);
                    obj.flush();
                    obj.close();
                }
            }
            if(flag == false){
                System.out.println("error : compte non trouve.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void creerUncompte(BankAccount account) {
        try {
            System.out.println("Nom et prenom: ");
            account.setI_nom(in.nextLine());
            System.out.println("Adresse: ");
            account.setI_adresse(in.nextLine());
            int choice ;
            System.out.println("\n 1: Compte sur livret.\n2: Compte d’epargne.\n3: Compte titre.");
            do {
                choice = Integer.parseInt(in.nextLine());
                if(choice < 1 || choice > 3) {
                    System.out.println("Entrer 1 ou 2 ou 3, svp!");
                }
            }while (choice < 1 || choice > 3);
            switch(choice) {
                case 1:
                    account.setI_typeDeCompte("Compte sur livret.");
                    break;
                case 2:
                    account.setI_typeDeCompte("Compte d’epargne.");
                    break;
                case 3:
                    account.setI_typeDeCompte("Compte titre.");
                    break;
            }
            System.out.println("Numero de telephone: ");
            account.seti_numTelephone(in.nextLine());
            System.out.println("Solde en compte: ");
            account.setI_solde(Double.parseDouble(in.nextLine()));
            System.out.println("Nombre des transactions: ");
            account.setI_noDeTrans(Integer.parseInt(in.nextLine()));
        } catch (InputMismatchException e) {
            System.out.println(e);
        }
    }

    public void afficherInformationsAll() {
        for (BankAccount account : listAccount) {
            account.afficherLesInfor();
        }
    }

    public void chercherUnElement() {
        try{
            System.out.println("Entrez les informations: ");
            System.out.print("\n + Le nom et prenom: ");
            String nom = in.nextLine();
            System.out.print("\n + Le numero de telephone : ");
            String numeroDeTelephone = in.nextLine();
            System.out.print("\n + Le numero de compte : ");
            String numeroDeCompte = in.nextLine();
            boolean flag = false;
            for (BankAccount account : listAccount) {
                if (account.getI_nom().equalsIgnoreCase(nom) && account.geti_numTelephone().equalsIgnoreCase(numeroDeTelephone) && account.getI_noDeCompte().equalsIgnoreCase(numeroDeCompte)) {
                    account.afficherLesInfor();
                }
                flag = true;
            }
            if(!flag){
                System.out.println("error : compte non trouve.");
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public void modifiezUnCompte() {
        try {
            System.out.println("Entrez le numero de compte: ");
            String numeroDeCompte = in.nextLine();
            boolean flag = false;
            for (BankAccount account : listAccount) {
                if (account.getI_noDeCompte().equalsIgnoreCase(numeroDeCompte)) {
                    System.out.println("Retapez les informations: ");
                    creerUncompte(account);
                    System.out.println("SUCCES.");
                    flag = true;
                }
            }
            if(!flag){
                System.out.println("error : compte non trouve.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //4
    public void imprimezDesTransactions() {
            try {
                System.out.println("Le numero de compte: ");
                String numeroDeCompte = in.nextLine();
                String nomDeFichier = "transactionDe" + numeroDeCompte + ".txt";
                boolean flag = false;
                Transaction trans = new Transaction();
                for (BankAccount account : listAccount) {
                    if (account.getI_noDeCompte().equalsIgnoreCase(numeroDeCompte)) {
                        double soldeinitial = account.getI_solde();
                        trans.crOperation(account);
                        double soldeFinal = account.getI_solde();
                        Formatter output = new Formatter(nomDeFichier);

                        output.format("\tNuméro de compte : %s" +
                                        "\n\tNom et prénom : %s" +
                                        "\nDate \t\t\t\tOpération \t\t\t\tDebit \t\t\tCredit" +
                                        "\n--------------------------------------------------------------------------------------------------------" +
                                        "\nSold initial                                                                                    %f" +
                                        "\n--------------------------------------------------------------------------------------------------------" +
                                        "\n%s \t\t|\t%s \t\t\t|\t%f \t|\t%f" +
                                        "\n--------------------------------------------------------------------------------------------------------" +
                                        "\nTotal des opérations                                    " +
                                        "\n--------------------------------------------------------------------------------------------------------" +
                                        "\nSolde final                                                                                     %f",
                                account.getI_noDeCompte(), account.getI_nom(), soldeinitial, trans.geti_date(),
                                trans.geti_Operation(), trans.geti_Debit(), trans.geti_Credit(), soldeFinal);
                        output.flush();
                        output.close();
                        System.out.println("SUCCES." + nomDeFichier);
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("\nerror : compte non trouve.\n");
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        }
}
