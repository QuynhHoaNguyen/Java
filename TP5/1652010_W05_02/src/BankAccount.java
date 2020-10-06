import java.io.Serializable;

public class BankAccount implements Serializable {
    private String nom_du_deposant;
    private String adresse_du_deposant;
    private String type_de_compte; //Type de compte (compte sur livret, compte d’épargne, compte à vue, compte titre)
    private double solde_en_compte;
    private String numero_de_telephone;
    private int nombre_des_transactions;
    private String numero_de_compte = "BA";

    public BankAccount() {
    }

    public BankAccount(String nom_du_deposant, String adresse_du_deposant, String type_de_compte, double solde_en_compte, String numero_de_telephone, int nombre_des_transactions) {
        this.nom_du_deposant = nom_du_deposant;
        this.adresse_du_deposant = adresse_du_deposant;
        this.type_de_compte = type_de_compte;
        this.solde_en_compte = solde_en_compte;
        this.numero_de_telephone = numero_de_telephone;
        this.nombre_des_transactions = nombre_des_transactions;
    }

    public String getNom_du_deposant() {
        return nom_du_deposant;
    }

    public void setNom_du_deposant(String nom_du_deposant) {
        this.nom_du_deposant = nom_du_deposant;
    }

    public String getAdresse_du_deposant() {
        return adresse_du_deposant;
    }

    public void setAdresse_du_deposant(String adresse_du_deposant) {
        this.adresse_du_deposant = adresse_du_deposant;
    }

    public String getType_de_compte() {
        return type_de_compte;
    }

    public void setType_de_compte(String type_de_compte) {
        this.type_de_compte = type_de_compte;
    }

    public double getSolde_en_compte() {
        return solde_en_compte;
    }

    public void setSolde_en_compte(double solde_en_compte) {
        this.solde_en_compte = solde_en_compte;
    }

    public String getNumero_de_telephone() {
        return numero_de_telephone;
    }

    public void setNumero_de_telephone(String numero_de_telephone) {
        this.numero_de_telephone = numero_de_telephone;
    }

    public int getNombre_des_transactions() {
        return nombre_des_transactions;
    }

    public void setNombre_des_transactions(int nombre_des_transactions) {
        this.nombre_des_transactions = nombre_des_transactions;
    }

    public String getNumero_de_compte() {
        return numero_de_compte;
    }

    public void setNumero_de_compte(String numero_de_compte) {
        this.numero_de_compte = numero_de_compte;
    }

    public void afficher_les_informations() {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Numéro de compte : " + getNumero_de_compte());
        System.out.println("Nom du déposant : " + getNom_du_deposant());
        System.out.println("Adresse du déposant : " + getAdresse_du_deposant());
        System.out.println("Type de compte : " + getType_de_compte());
        System.out.println("Numéro de téléphone : " + getNumero_de_telephone());
        System.out.println("Solde en compte : " + getSolde_en_compte());
        System.out.println("Nombre des transactions : " + getNombre_des_transactions());
        System.out.println("--------------------------------------------------------------------");
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "solde_en_compte=" + solde_en_compte +
                '}';
    }

    public void deposer(double montant) {
        if (montant > 0.00) {
            solde_en_compte = solde_en_compte + montant;
            nombre_des_transactions++;
        } else {
            System.out.println("Le montant du dépôt n'est pas valide.");
        }
    }

    public void retirer(double montantRetire) {
        if (montantRetire <= 0) {
            System.out.println("Compte retiré doit être positif");
        } else {
            if (solde_en_compte < montantRetire) {
                System.out.println("Solde insuffisant en compte pour retirer");
            } else {
                solde_en_compte = solde_en_compte - montantRetire;
                nombre_des_transactions++;
            }
        }
    }
}