import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TFDDemo  implements ActionListener {
    JTextField jtf;
    JButton jbtnRev;
    JLabel jLabPrompt, jlabContents;
    TFDDemo(){
        JFrame jfrm = new JFrame("Use a Text Field");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(240, 120);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jtf = new JTextField(10);
        jtf.setActionCommand("myTF");
        JButton jbtnRev = new JButton("Reverse");
        jtf.addActionListener(this);
        jbtnRev.addActionListener(this);
        jLabPrompt = new JLabel(" Enter text: ");
        jlabContents = new JLabel("");
        jfrm.add(jLabPrompt);
        jfrm.add(jtf);
        jfrm.add(jbtnRev);
        jfrm.add(jlabContents);
        jfrm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Reverse")){
            String orgStr = jtf.getText();
            String resStr = "";
            for (int i = orgStr.length() - 1; i >= 0; i--)
                resStr += orgStr.charAt(i);
            jtf.setText(resStr);
        }else
            jlabContents.setText("you pressed ENTER." + "Test is: " + jtf.getText());
    }

    public  static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TFDDemo();
            }
        });
    }
}
