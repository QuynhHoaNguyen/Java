import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Transaction  {
    private String i_date;
    private String i_operation;
    private Double i_debit;
    private Double i_credit;

    Scanner in = new Scanner(System.in);

    public Transaction(){
        this.i_date = "";
        this.i_operation = "";
        this.i_debit = 19.5;
        this.i_credit = 23.7;
    }

    public Transaction(String date, String operation, Double debit, Double credit) {
        this.i_date = date;
        this.i_operation = operation;
        this.i_debit = debit;
        this.i_credit = credit;
    }

    public String geti_date() {
        return i_date;
    }

    public void seti_date(String date) {
        this.i_date = date;
    }

    public String geti_Operation() {
        return i_operation;
    }

    public void seti_Operation(String operation) {
        this.i_operation = operation;
    }

    public Double geti_Debit() {
        return i_debit;
    }

    public void seti_Debit(Double debit) {
        this.i_debit = debit;
    }

    public Double geti_Credit() {
        return i_credit;
    }

    public void seti_Credit(Double credit) {
        this.i_credit = credit;
    }

    public void crOperation(BankAccount BA) {
        try {
            Calendar cal = Calendar.getInstance();
            seti_date(cal.get(Calendar.DATE) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.YEAR));
            System.out.print("Ajoutez votre operation: ");
            String operation = in.nextLine();
            seti_Operation(operation);
            int choice ;
            System.out.println("\n 1: Debit \n 2: Credit ");
            do {
                choice = Integer.parseInt(in.nextLine());
                if (choice < 1 || choice > 2) {
                    System.out.println("Entrer 1 ou 2, svp!");
                }
            } while (choice < 1 || choice > 2);
            switch (choice) {
                case 1:
                    System.out.println("Entrer le montant deduit: ");
                    seti_Debit(Double.parseDouble(in.nextLine()));
                    BA.retirer(i_debit);
                    break;
                case 2:
                    System.out.println("Entrer le montant ajoute: ");
                    seti_Credit(Double.parseDouble(in.nextLine()));
                    BA.deposer(i_credit);
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println(e);
        }
    }

}
