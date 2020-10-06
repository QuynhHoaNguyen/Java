import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.InputMismatchException;
import javax.swing.*;
import java.io.IOException;
import javax.tools.JavaFileObject;

class FindLargest extends Component implements ActionListener {
    JTextArea tarea = new JTextArea(30, 90);
    JButton submit = new JButton("Sumit");
    JButton clear = new JButton("Clear");
    JTextArea result = new JTextArea("Result", 5, 90);

    private JTextField filename = new JTextField(), dir = new JTextField();
    FindLargest() {
        JFrame jfrm = new JFrame("Find the largest and second largest");// Specify FlowLayout for the layout manager
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        jfrm.setResizable(false);// Give the frame an initial size.
        jfrm.setSize(1000, 750);//Terminate the program when the user closes th application.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Create the menu bar.
        JMenuBar jmb = new JMenuBar();// Create the File menu.
        JMenu jmFile = new JMenu("File");
        jmFile.setMnemonic(KeyEvent.VK_F);
        JMenuItem jmiOpen = new JMenuItem("Load File", KeyEvent.VK_O);
        jmiOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        JMenuItem jmiSave = new JMenuItem("Save File", KeyEvent.VK_S);
        jmiSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        JMenuItem jmiExit = new JMenuItem("Exit", KeyEvent.VK_E);
        jmiExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
        jmFile.add(jmiOpen);
        jmFile.add(jmiSave);
        jmFile.addSeparator();
        jmFile.add(jmiExit);
        jmb.add(jmFile);// Add the menu bar to the frame.
        jfrm.setJMenuBar(jmb);//Action listener of options
        jmiOpen.addActionListener(new Open());
        jmiSave.addActionListener(new Save());
        jmiExit.addActionListener(this);

        // Text area
        JPanel textPanel = new JPanel();
        textPanel.add(tarea);
        //scroll for text area
        JScrollPane scroll = new JScrollPane(tarea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        textPanel.add(scroll);
        mainPanel.add(textPanel);
        JPanel buttonPanel = new JPanel();
        submit.setPreferredSize(new Dimension(100, 30));
        clear.setPreferredSize(new Dimension(100, 30));
        clear.addActionListener(new Clear());
        submit.addActionListener(new Submit());
        buttonPanel.add(result);
        buttonPanel.add(submit);
        buttonPanel.add(clear);
        mainPanel.add(buttonPanel);
        // Display the frame.
        jfrm.add(mainPanel);
        jfrm.setVisible(true);
    }@Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    class Submit implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                String text = tarea.getText();
                String[] nums = text.split("\n");
                float max = Integer.parseInt(nums[0]);
                float second = Integer.parseInt(nums[0]);

                for (int i = 1; i < nums.length; i++){
                    if (second < Float.parseFloat(nums[i])){
                        second = Float.parseFloat(nums[i]);
                    }
                    if (max < Float.parseFloat(nums[i])){
                        second = max;
                        max = Integer.parseInt(nums[i]);
                    }
                    result.setText("The largest number is " + max + "\n" + "The second largest number is " + second);
                }
            } catch (NumberFormatException ex) {
                result.setText("Inputs must be numbers");
            }
        }
    }

    class Clear implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            tarea.setText("");
        }
    }

    class Save implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int actionDialog = fileChooser.showOpenDialog(FindLargest.this);
            if (actionDialog != JFileChooser.APPROVE_OPTION) {
                return;
            }
            File fileName = new File(fileChooser.getSelectedFile() + ".txt");
            BufferedWriter outFile = null;
            try {
                outFile = new BufferedWriter(new FileWriter(fileName));
                tarea.write(outFile);
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

    class Open implements ActionListener  {
        @Override
        public void actionPerformed(ActionEvent e) {
            result.setText("");
            JFileChooser fileChooser = new JFileChooser();
            int result_1 = fileChooser.showOpenDialog(FindLargest.this);
            if (result_1 == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                if(selectedFile.exists()){
                try {
                    BufferedReader input = new BufferedReader(new InputStreamReader(
                            new FileInputStream(selectedFile)));
                    tarea.read(input, "READING FILE :-)");
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                } catch (Exception er) {
                    er.printStackTrace();
                }}
                else{
                    result.setText("This file doesn't exist");
                }
            }
        }
    }

    public static void main(String args[]) {
        // Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() { new FindLargest(); }
        });
    }
}