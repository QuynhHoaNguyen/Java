/*
Nom et prenom   :  Nguyen Thi Quynh Hoa
Code d'etudiant :  1752017
Classe          :  17VP
*/

import java.util.Date;

public class Commande {
    private Date i_date;
    private TypeEtat etat;

    Commande(){

    }

    public void calTotal(){
        // Tinh toan tong so tien phai tra cho mot mat hang
    }

    public void calPoidsTotal(){
        //tinh tong so tien phai tra cho mot commande
    }

    public void calMontantPaye(){
        //tinh toan tong so tien mà nguoi dung tra cho mot mat hang
    }

    public Date getI_date() {
        return i_date;
    }

    public void setI_date(Date i_date) {
        this.i_date = i_date;
    }

    public TypeEtat getEtat() {
        return etat;
    }

    public void setEtat(TypeEtat etat) {
        this.etat = etat;
    }
}
