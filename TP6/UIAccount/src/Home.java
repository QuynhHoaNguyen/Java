import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;

class Home extends Component implements ActionListener {

    JFrame jfrm;
    JPanel jpMain;
    JPanel jpnTrans = new JPanel();
    JPanel jpnButton = new JPanel();
    JPanel jpnShow = new JPanel();
    JTextArea jtareaShow = new JTextArea("", 30, 100);
    Home() throws IOException {
        //JLabel jlbTrans; // nhan vao de xem giao dich
        //JLabel jlbNdeCompte, jlbNomEtPre, jlbAdresse, jlbTypeDeCompte, jlbtele; //thong tin khach hang
        //JLabel jlbEdit, jlbAdd;
        //JLabel jlbDate, jlbOperation, jlbSolde, jlbDebit, jlbCredir, jlbTotal, jlbSoldeFinal; // thong tin giao dich

        jfrm = new JFrame("Bank Account");
        jpMain = new JPanel();
        JMenuBar jmb = new JMenuBar();
        JMenu jmAccount = new JMenu("Account");
        //jmAccount.setMnemonic(KeyEvent.VK_F);

        jfrm.setResizable(false);
        jfrm.setSize(1000, 750);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //ImageIcon createImageIcon;
        JMenuItem jmiOpen = new JMenuItem("Load File", KeyEvent.VK_O);
        jmiOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,  InputEvent.CTRL_DOWN_MASK));
        JMenuItem jmiSave = new JMenuItem("Save File", KeyEvent.VK_S);
        jmiSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        JMenuItem jmiExit = new JMenuItem("Exit", KeyEvent.VK_E);
        jmiExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
        jmAccount.add(jmiOpen);
        jmAccount.add(jmiSave);
        jmAccount.addSeparator();
        jmAccount.add(jmiExit);
        jmb.add(jmAccount);

        jmiOpen.addActionListener(new Open());
        jmiSave.addActionListener(new Save());
        jmiExit.addActionListener(this);

        String[] columnNames = {"Numero de compte", "Nom et prenom", "Adresse", "type de compte", "Numero de telephone"};


        JButton jbTrans = new JButton("Cliquez ici pour voir la transaction.");
        jbTrans.addActionListener(new Trans());

        ImageIcon iAdd, iEdit;
        BufferedImage imageAdd, imageEdit;
        imageAdd = ImageIO.read(new File("image/iconAdd.png"));
        imageEdit = ImageIO.read(new File("image/iconEdittt.png"));

        iAdd = new ImageIcon(imageAdd.getScaledInstance(30,30,imageAdd.SCALE_SMOOTH));
        iEdit = new ImageIcon(imageEdit.getScaledInstance(30,30,imageAdd.SCALE_SMOOTH));

        JButton jbAdd = new JButton(iAdd);
        //jbAdd.setBounds(275,180,10,20);
        jbAdd.addActionListener(new Add());

        JButton jbEdit = new JButton(iEdit);
        //jbEdit.setBounds(180,175,10,20);
        jbEdit.addActionListener(new Edit());



        jpnTrans.add(jbTrans);
        jpnShow.add(jtareaShow);
        jpnButton.add(jbAdd);
        jpnButton.add(jbEdit);

        jpMain.add(jmb);
        jpMain.add(jbTrans);
        jpMain.add(jpnShow);
        jpMain.add(jpnButton);

        jfrm.setJMenuBar(jmb);
        jfrm.add(jpMain);
        jfrm.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String comStr = e.getActionCommand();
        if (comStr.equals("Exit")) System.exit(0);
    }

    class Trans implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Transaction trans = new Transaction();
        }
    }
    class Open implements ActionListener  {
        @Override
        public void actionPerformed(ActionEvent e) {
            jtareaShow.setText("");
            JFileChooser fileChooser = new JFileChooser();
            int result_1 = fileChooser.showOpenDialog(Home.this);
            if (result_1 == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                if(selectedFile.exists()){
                    try {
                        BufferedReader input = new BufferedReader(new InputStreamReader(
                                new FileInputStream(selectedFile)));
                        jtareaShow.read(input, "READING FILE :-)");
                        System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                    } catch (Exception er) {
                        er.printStackTrace();
                    }}
                else{
                    jtareaShow.setText("This file doesn't exist");
                }
            }
        }
    }

    class Save implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int actionDialog = fileChooser.showOpenDialog(Home.this);
            if (actionDialog != JFileChooser.APPROVE_OPTION) {
                return;
            }
            File fileName = new File(fileChooser.getSelectedFile() + ".txt");
            BufferedWriter outFile = null;
            try {
                outFile = new BufferedWriter(new FileWriter(fileName));
                jtareaShow.write(outFile);
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                if (outFile != null) {
                    try {
                        outFile.close();
                    } catch (IOException er) {
                        // one of the few times that I think that it's OK
                        // to leave this blank
                    }
                }
            }
        }
    }

    private class Add implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AddAccount addaccount = new AddAccount();
        }
    }

    private class Edit implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            EditAccount editaccount = new EditAccount();
        }
    }



    public static void main(String args[]) {
        // Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Home();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }



}
