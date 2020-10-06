import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class FindMax implements ActionListener {
    JLabel jlab;

    FindMax() {
// Create a new JFrame container.
        JFrame jfrm = new JFrame("Find Max");
        Container pane = jfrm.getContentPane();
// Specify FlowLayout for the layout manager.
        jfrm.setLayout(new FlowLayout());
// Give the frame an initial size.
        jfrm.setSize(220, 200);
//Terminate the program when the user closes the application.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Create a label that will display the menu selection.
        jlab = new JLabel();
// Create the menu bar.
        JMenuBar jmb = new JMenuBar();
        JMenu jmFile = new JMenu("File");
        jmFile.setMnemonic(KeyEvent.VK_F);
        JMenuItem jmiLoad = new JMenuItem("Load", KeyEvent.VK_L);
        jmiLoad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,

                InputEvent.CTRL_DOWN_MASK));

        JMenuItem jmiClose = new JMenuItem("Close", KeyEvent.VK_C);
        jmiClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,

                InputEvent.CTRL_DOWN_MASK));

        JMenuItem jmiSave = new JMenuItem("Save", KeyEvent.VK_S);
        jmiSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,

                InputEvent.CTRL_DOWN_MASK));

        jmFile.add(jmiLoad);
        jmFile.add(jmiSave);
        jmFile.add(jmiClose);
        jmFile.addSeparator();
        jmb.add(jmFile);

        jmiLoad.addActionListener(this);
        jmiClose.addActionListener(this);
        jmiSave.addActionListener(this);

        JTextArea jtArea = new JTextArea();
        jtArea.setBounds(20,50,380,400);

        JButton jbtSubmit = new JButton("Submit");
        JButton jbtClear = new JButton("Clear");
        pane.add(jbtSubmit, BorderLayout.PAGE_END);
        pane.add(jbtClear, BorderLayout.PAGE_END);


        // Add the label to the content pane.
        jfrm.add(jlab);
// Add the menu bar to the frame.
        jfrm.setJMenuBar(jmb);
        jfrm.add(jtArea);

        jfrm.add(jbtSubmit);
        jfrm.add(jbtClear);
// Display the frame.
        jfrm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comStr = e.getActionCommand();
// If user chooses Exit, then exit the program.
        if (comStr.equals("Close")) System.exit(0);
    }

    public static void main(String args[]) {
// Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() { new FindMax(); }
        });
    }
}
