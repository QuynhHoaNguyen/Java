import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAccount implements ActionListener {

    JFrame jfrm;
    JPanel jpMain;
    JButton jbback;
    AddAccount(){
        jfrm = new JFrame("Add Bank Account");
        jpMain = new JPanel();
        jbback = new JButton("Back");
        jbback.addActionListener(new Transaction.Back());
        jfrm.setResizable(false);
        jfrm.setSize(1000, 750);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        jfrm.add(jpMain);
        jpMain.add(jbback);
        jfrm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comStr = e.getActionCommand();
        if (comStr.equals("Exit")) System.exit(0);
    }
}
