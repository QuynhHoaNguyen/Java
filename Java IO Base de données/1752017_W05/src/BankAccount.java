import java.io.Serializable;

public class BankAccount implements Serializable {
    private String i_nom;
    private String i_adresse;
    private String i_numTelephone;
    private String i_typeDeCompte;
    private double i_solde;
    private int i_noDeTrans;
    private String i_noDeCompte = "BA";

    public BankAccount() {
        this.i_nom = "Hoa";
        this.i_adresse = "Hue";
        this.i_numTelephone = "0363618286";
        this.i_typeDeCompte = "Compte titre";
        this.i_solde = 123999015;
        this.i_noDeTrans = 134981;
        this.i_noDeCompte = "BA";
    }

    public BankAccount(String nom, String adresse, String tele, String type, double solde, int trans, String compte) {
        this.i_nom = nom;
        this.i_adresse = adresse;
        this.i_numTelephone = tele;
        this.i_typeDeCompte = type;
        this.i_solde = solde;
        this.i_noDeTrans = trans;
        this.i_noDeCompte = compte;
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

    public String geti_numTelephone() {
        return i_numTelephone;
    }

    public void seti_numTelephone(String i_telephone) {
        this.i_numTelephone = i_telephone;
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

    public int getI_noDeTrans() {
        return i_noDeTrans;
    }

    public void setI_noDeTrans(int i_noDeTrans) {
        this.i_noDeTrans = i_noDeTrans;
    }

    public String getI_noDeCompte() {
        return i_noDeCompte;
    }

    public void setI_noDeCompte(String i_noDeCompte) {
        this.i_noDeCompte = i_noDeCompte;
    }

    public void afficherLesInfor() {
        System.out.println("\n");
        System.out.println("Numero de compte: " + getI_noDeCompte());
        System.out.println("Nom et prenom: " + getI_nom());
        System.out.println("Adresse: " + getI_adresse());
        System.out.println("Type de compte: " + getI_typeDeCompte());
        System.out.println("Numero de telephone: " + geti_numTelephone());
        System.out.println("Solde en compte: " + getI_solde());
        System.out.println("Nombre des transactions: " + getI_noDeTrans());
        System.out.println("\n");

    }

    public  String toString(){
        return "Solde = " + i_solde;
    }
    public void deposer(double montant) {
        if (montant > 0.00) {
            i_solde = i_solde + montant;
            i_noDeTrans++;
        } else {
            System.out.println("Vous devez deposer plus.");
        }
    }

    public void retirer(double montant) {
        if (montant <= 0) {
            System.out.println("Le compte de retrait doit etre superieur a zero");
        } else {
            if (i_solde < montant) {
                System.out.println("Solde insuffisant en compte pour retirer");
            } else {
                i_solde = i_solde - montant;
                i_noDeTrans++;
            }
        }
    }
}