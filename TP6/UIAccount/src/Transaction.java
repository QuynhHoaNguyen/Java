import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Transaction implements ActionListener {
    JFrame jfrm;
    JPanel jpMain;
    JButton jbback;
    Transaction(){
        jfrm = new JFrame("Transaction");
        jpMain = new JPanel();
        jbback = new JButton("Back");
        jbback.addActionListener(new Back());
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

    public static class Back implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Home backhome = new Home();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
