import java.util.Scanner;
public class BankAccount {
    private String i_nom;
    private String i_adresse;
    private String i_typeDeCompte;
    private double i_solde;
    private double i_numTelephone;
    private int i_nomTransactions;

    BankAccount(){
        this.i_nom = "Hoa";
        this.i_adresse = "Huế";
        this.i_typeDeCompte = "Compte titre";
        this.i_solde = 999999211;
        this.i_numTelephone = 363618286;
        this.i_nomTransactions = 110;
    }

    public String getI_nom() {
        return i_nom;
    }

    public void setI_nom(String i_nom) {
        this.i_nom = i_nom;
    }

    public String getI_adresse() {
        return i_adresse;
    }

    public void setI_adresse(String i_adresse) {
        this.i_adresse = i_adresse;
    }

    public String getI_typeDeCompte() {
        return i_typeDeCompte;
    }

    public void setI_typeDeCompte(String i_typeDeCompte) {
        this.i_typeDeCompte = i_typeDeCompte;
    }

    public double getI_solde() {
        return i_solde;
    }

    public void setI_solde(double i_solde) {
        this.i_solde = i_solde;
    }

    public double getI_numTelephone() {
        return i_numTelephone;
    }

    public void setI_numTelephone(double i_numTelephone) {
        this.i_numTelephone = i_numTelephone;
    }

    public int getI_nomTransactions() {
        return i_nomTransactions;
    }

    public void setI_nomTransactions(int i_nomTransactions) {
        this.i_nomTransactions = i_nomTransactions;
    }

    public String toString(){
        return "Nom: " + this.getI_nom() + "\nAdresse: " + this.getI_adresse() + "\nType de compte: " + this.getI_typeDeCompte() + "\nSolde: " + this.getI_solde() + "\nNumero de telethone:" + this.getI_numTelephone() + "\nLe nombre des transaction:" + this.getI_nomTransactions();
    }

    public double Transaction(double soTien){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n == 1){
            return 1; // Gui Tien
        }
        else{
            return 0; //Rut Tien
        }
    }
    public void Depose(double soTienGui){
        if(Transaction(soTienGui) == 1){
        this.i_solde += soTienGui;}
    }

    public void Retirer(double soTienRut){
        if(Transaction(soTienRut) == 0){
        this.i_solde -= soTienRut;}
    }

}
