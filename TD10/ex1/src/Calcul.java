import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class Calcul implements ItemListener {
    JCheckBox jcbAdd, jcbSub, jcbMul, jcbDiv, jcbMod;
    JLabel jlabSelected, jlabChanged;
    JTextField jtf1, jtf2;

    JLabel jLabPrompt1, jLabPrompt2, jlabContents;
    Calcul(){
        JFrame jFrame = new JFrame("Calcul");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(400,240);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jtf1 = new JTextField(10);
        jtf1.setActionCommand("My calcul");
        jtf2 = new JTextField(10);
        jtf2.setActionCommand("My calcul2");
/*
        jlst = new JList<String>(cal);
        jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jscrlp = new JScrollPane(jlst);
        jscrlp.setPreferredSize(new Dimension(50, 80));
        jlab = new JLabel("Please choose a calculation");
        jlst.addListSelectionListener(this);

        JButton jbtnResult = new JButton("Result");
        jtf1.addActionListener(this);
        jtf2.addActionListener(this);
        jbtnResult.addActionListener(this);*/

        jlabSelected = new JLabel("");
        jlabChanged = new JLabel("");
        jcbAdd = new JCheckBox("+");
        jcbSub = new JCheckBox("-");
        jcbMul = new JCheckBox("x");
        jcbDiv = new JCheckBox("/");
        jcbMod = new JCheckBox("%");
        jcbAdd.addItemListener(this);
        jcbSub.addItemListener(this);
        jcbMul.addItemListener(this);
        jcbDiv.addItemListener(this);
        jcbMod.addItemListener(this);

        jLabPrompt1 = new JLabel("Enter num1: ");
        jLabPrompt2 = new JLabel("Enter num2: ");
        jlabContents = new JLabel("");


        jFrame.add(jLabPrompt1);
        jFrame.add(jtf1);
        //jFrame.add(jscrlp);
        jFrame.add(jLabPrompt2);
        jFrame.add(jtf2);
        /*
        jFrame.add(jbtnAdd);
        jFrame.add(jbtnSub);
        jFrame.add(jbtnDiv);
        jFrame.add(jbtnMul);
        jFrame.add(jbtnMod);

        jFrame.add(jbtnResult);*/
        jFrame.add(jcbAdd);
        jFrame.add(jcbSub);
        jFrame.add(jcbMul);
        jFrame.add(jcbDiv);
        jFrame.add(jcbMod);
        jFrame.add(jlabContents);
        jFrame.add(jlabSelected);
        jFrame.add(jlabChanged);
        jFrame.setVisible(true);
        }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String str = "";
        JCheckBox cb = (JCheckBox) e.getItem();
        if (cb.isSelected())
            jlabChanged.setText(cb.getText() +

                    " was just selected.");

        else jlabChanged.setText(cb.getText() +

                " was just cleared.");
        int a = Integer.parseInt(jtf1.getText());
        int b = Integer.parseInt(jtf2.getText());
        int c ;
        if(jcbAdd.isSelected()) {c = a + b;jlabSelected.setText("Result: " + c);}
        if(jcbSub.isSelected()) {c = a - b;jlabSelected.setText("Result: " + c);}
        if(jcbAdd.isSelected()) {c = a * b;jlabSelected.setText("Result: " + c);}
        if(jcbAdd.isSelected()) {c = a / b;jlabSelected.setText("Result: " + c);}
        if(jcbAdd.isSelected()) {c = a % b;jlabSelected.setText("Result: " + c);}
        //String t = String.valueOf(c);
        //jlabSelected.setText("Result: " + c);

    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calcul();
            }
        });
    }



}
