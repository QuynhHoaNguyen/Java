import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Count extends JFrame{

    private JLabel labelSoKyTu;
    private JButton btnKetQua;
    private JTextArea textArea;

    public Count() {
        setTitle("Java Swing - Number of words and Number of characters");


        labelSoKyTu = new JLabel("Number of characters:");

        labelSoKyTu.setBounds(150, 20, 150, 25);

        textArea = new JTextArea();
        textArea.setBounds(20, 50, 380, 220);
        btnKetQua = new JButton("Count");
        btnKetQua.setBounds(20, 280, 80, 25);


        add(labelSoKyTu);
        add(textArea);
        add(btnKetQua);

        // thiết lập bố cục (layout)
        setLayout(null);
        // thiết lập kích thước jframe
        setSize(450, 400);
        // hiển thị jframe
        setVisible(true);
    }


    public JLabel getLabelSoKyTu() {
        return labelSoKyTu;
    }

    public void setLabelSoKyTu(JLabel labelSoKyTu) {
        this.labelSoKyTu = labelSoKyTu;
    }

    public JButton getBtnKetQua() {
        return btnKetQua;
    }

    public void setBtnKetQua(JButton btnKetQua) {
        this.btnKetQua = btnKetQua;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

}
