import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.time.LocalDate.*;

public class Time extends JFrame {
    private JLabel jlbClock;
    private JLabel jlbDate;
    Time(){
        setTitle("la date et l'heure actuelles");
        jlbClock = new JLabel();
        jlbDate = new JLabel();
        jlbClock.setBounds(20, 20, 80, 20);
        jlbDate.setBounds(20, 40, 100, 100);
        add(jlbDate);
        add(jlbClock);

        setSize(400, 200);
        setLayout(null);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
        setVisible(true);
        try {
            while (true) {
                Calendar calendar = Calendar.getInstance();
                String d = String.valueOf(java.time.LocalDate.now());
                String hour = (calendar.getTime().getHours() > 9) ?
                        "" + calendar.getTime().getHours() + ""
                        : "0" + calendar.getTime().getHours();
                String minute = (calendar.getTime().getMinutes() > 9) ?
                        "" + calendar.getTime().getMinutes() + ""
                        : "0" + calendar.getTime().getMinutes();
                String second = (calendar.getTime().getSeconds() > 9) ?
                        "" + calendar.getTime().getSeconds() + ""
                        : "0" + calendar.getTime().getSeconds();
                jlbClock.setText("Heure: " + hour + ":" + minute + ":" + second);
                jlbDate.setText("Date: " + d);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new Time();

    }
    }

