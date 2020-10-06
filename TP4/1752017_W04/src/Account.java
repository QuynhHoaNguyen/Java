import java.util.Scanner;
//import java.util.ArrayList;
public class Account {
    //ArrayList<String> listAccount = new ArrayList<>();
    BankAccount BAccount = new BankAccount();
    public int i_IntnumDeCompte = 999;

    Account(){
        this.i_IntnumDeCompte = 999;
    }
    Scanner in = new Scanner(System.in);
    // 1
    public String numDeCompteUnique(){
        double soTienGui = in.nextDouble();
        if(BAccount.Transaction(soTienGui) == 1) {
            this.i_IntnumDeCompte += 1;
            return "BA" + this.i_IntnumDeCompte;
        }
        else{
            return "XX";
        }
        }
//2

    public String InputToString(){
        System.out.println("Nom: ");
        String nom = in.nextLine();

        System.out.println("\nAdress: ");
        String adresse = in.nextLine();

        System.out.println("\\nType de compte:");
        String typeDeCompte = in.nextLine();

        System.out.println("\nSolde: ");
        Double solde = in.nextDouble();

        System.out.println("\\nNumero de telethone: ");
        Double numTele = in.nextDouble();

        return "Nom:" + nom + "\nAdresse: " + adresse + "\nType de compte: " + typeDeCompte + "\nSolde: " + solde + "\nNumero de telethone:" + numTele;
    }

    public void ShowInfoListAccount(){
        int nombreDeDeposants = in.nextInt();
        for(int i = 0; i< nombreDeDeposants;i++){
            System.out.println(i + ": " + InputToString());
        }
    }
//3
    public void OutputCompte(){
        int index = in.nextInt();
        int nombreDeDeposants = in.nextInt() ;
        for(int i = 0;i<nombreDeDeposants;i++){
            if(index == i){
                System.out.println(i + ": " + InputToString());
            }
        }
    }

}
