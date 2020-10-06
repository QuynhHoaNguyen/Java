import javax.swing.*;

public class CountMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Count view = new Count();
                new CountController(view);
            }
        });

    }
}
