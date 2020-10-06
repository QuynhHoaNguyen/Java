/*
Nom et prenom   :  Nguyen Thi Quynh Hoa
Code d'etudiant :  1752017
Classe          :  17VP
*/

public class Client {
    private String i_nom;
    private String i_adresse;
    private String i_prenom;

    Client(){
        this.i_nom = " ";
        this.i_prenom = " ";
        this.i_prenom = " ";
    }

    Client(String nom, String pre, String adresse){
        this.i_nom = nom;
        this.i_prenom = pre;
        this.i_adresse = adresse;
    }

    public String getI_nom() {
        return i_nom;
    }

    public void setI_nom(String i_nom) {
        this.i_nom = i_nom;
    }

    public String getI_prenom() {
        return i_prenom;
    }

    public void setI_prenom(String i_prenom) {
        this.i_prenom = i_prenom;
    }

    public String getI_adresse() {
        return i_adresse;
    }

    public void setI_adresse(String i_adresse) {
        this.i_adresse = i_adresse;
    }

    public String toString(){
        return "\nClient" + this.i_nom +  this.i_prenom +"\nL'adresse " + this.i_adresse;
    }
}

