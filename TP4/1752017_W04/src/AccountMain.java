import java.io.IOException;

public class AccountMain {
    public static void main() throws IOException {

        Account Acc = new Account();
        System.out.println(Acc.numDeCompteUnique());
        System.out.println(Acc.InputToString());
        Acc.ShowInfoListAccount();
        Acc.OutputCompte();
    }

}
