import java.awt.event.*;

public class CountController implements ActionListener {
    private Count view;

    public CountController(Count view) {
        this.view = view;
        view.getBtnKetQua().addActionListener(this);
        view.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.getLabelSoKyTu().setText("Number of characters: "
                + view.getTextArea().getText().length());
    }

}
