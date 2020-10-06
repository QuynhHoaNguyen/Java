/*
Nom et prenom   :  Nguyen Thi Quynh Hoa
Code d'etudiant :  1752017
Classe          :  17VP
*/

public class Article {
    private String i_nom;
    private String i_description;
    private  double i_poidsExpedition;
    private double i_prix;

    Article(){
        this.i_nom = "HP Pavilion 14-ce1000nf PC Ultraportable";
        this.i_description = "HP Pavilion 14-ce1000nf PC siêu di động 14 '' FHD IPS Argent (Intel Core i5, RAM 8 GB, SSD 256 GB, AZERTY, Windows 10)";
        this.i_poidsExpedition = 1.59;
        this.i_prix = 699.0;
    }

    Article(String nom, String des, double poids, double prix){
        this.i_nom = nom;
        this.i_description = des;
        this.i_poidsExpedition = poids;
        this.i_prix = prix;
    }


    public String getI_description() {
        return i_description;
    }

    public void setI_description(String i_description) {
        this.i_description = i_description;
    }

    public String getI_nom() {
        return i_nom;
    }

    public void setI_nom(String i_nom) {
        this.i_nom = i_nom;
    }

    public double getI_poidsExpedition() {
        return i_poidsExpedition;
    }

    public void setI_poidsExpedition(double i_poidsExpedition) {
        this.i_poidsExpedition = i_poidsExpedition;
    }

    public double getI_prix() {
        return i_prix;
    }

    public void setI_prix(double i_prix) {
        this.i_prix = i_prix;
    }

    public String toString(){
        return "\nNom de l'article" + this.i_nom + "\nDescription" + this.i_description +"\nPoids d'expidition " + this.i_poidsExpedition +"\nPrix"+ this.i_prix;
    }
}
