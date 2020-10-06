import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SwingUtilities;


public class FileChooser extends JPanel implements ActionListener {
    static private final String newline = "\n";
    JButton jbtLoad, jbtSave, jbtClose;
    JTextArea text;
    JFileChooser fc;

    public FileChooser() {
        super(new BorderLayout());

        //Create the log first, because the action listeners
        //need to refer to it.
        text = new JTextArea(5,20);
        text.setMargin(new Insets(5,5,5,5));
        text.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(text);

        //Create a file chooser
        fc = new JFileChooser();


        jbtLoad = new JButton("Load File");
        jbtLoad.addActionListener(this);

        //Create the save button.  We use the image from the JLF
        //Graphics Repository (but we extracted it from the jar).
        jbtSave = new JButton("Save File");
        jbtSave.addActionListener(this);

        jbtClose = new JButton("Close");
        jbtClose.addActionListener(this);

        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(jbtLoad);
        buttonPanel.add(jbtSave);
        buttonPanel.add(jbtClose);



        //Add the buttons and the log to this panel.
        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the action command from the menu selection.
        String comStr = e.getActionCommand();
        // If user chooses Exit, then exit the program.
        if (comStr.equals("Close")) System.exit(0);
        //Handle open button action.
        if (e.getSource() == jbtLoad) {
            int returnVal = fc.showOpenDialog(FileChooser.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would open the file.
                text.append("Opening: " + file.getName() + "." + newline);
            } else {
                text.append("Open command cancelled by user." + newline);
            }
            text.setCaretPosition(text.getDocument().getLength());

            //Handle save button action.
        } else if (e.getSource() == jbtSave) {
            int returnVal = fc.showSaveDialog(FileChooser.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would save the file.
                text.append("Saving: " + file.getName() + "." + newline);
            } else {
                text.append("Save command cancelled by user." + newline);
            }
            text.setCaretPosition(text.getDocument().getLength());

        }
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("FileChooserDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new FileChooser());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }
}
