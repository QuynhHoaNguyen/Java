import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Transaction  {
    private String date;
    private String operation;
    private Double debit;
    private Double credit;

    Scanner input = new Scanner(System.in);

    public Transaction(){
        this.date = null;
        this.operation = null;
        this.debit = 0.00;
        this.credit = 0.00;
    }

    public Transaction(String date, String operation, Double debit, Double credit) {
        this.date = date;
        this.operation = operation;
        this.debit = debit;
        this.credit = credit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Double getDebit() {
        return debit;
    }

    public void setDebit(Double debit) {
        this.debit = debit;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public void creerUneOperation(BankAccount objAccount) {
        try {
            Calendar cal = Calendar.getInstance();
            setDate(cal.get(Calendar.DATE) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.YEAR));
            System.out.print("Ajoutez votre opération : ");
            String operation = input.nextLine();
            setOperation(operation);
            int choice ;
            System.out.println("Débit ou Crédit ( choisir [1,2] ) : \n 1 : Débit \n 2 : Crédit ");
            do {
                choice = Integer.parseInt(input.nextLine());
                if (choice < 1 || choice > 2) {
                    System.out.println("Entrer error ! Entrer une fois !");
                }
            } while (choice < 1 || choice > 2);
            switch (choice) {
                case 1:
                    System.out.println("Entrer le montant déduit : ");
                    setDebit(Double.parseDouble(input.nextLine()));
                    objAccount.retirer(debit);
                    break;
                case 2:
                    System.out.println("Entrer le montant ajouté : ");
                    setCredit(Double.parseDouble(input.nextLine()));
                    objAccount.deposer(credit);
                    break;
            }
        } catch (InputMismatchException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

}
