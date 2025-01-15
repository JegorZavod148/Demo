import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sekundomer extends JFrame {

    private JLabel label;
    private JButton start, stop, reset;
    private Timer timer;
    private int time = 0;

    public Sekundomer() {

        setTitle("Секундомір");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        label = new JLabel(formatTime(time));
        add(label);

        start = new JButton("Start");
        stop = new JButton("Stop");
        reset = new JButton("Reset");

        add(start);
        add(stop);
        add(reset);

        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                time++;
                label.setText(formatTime(time));
            }
        });

        start.addActionListener(e -> timer.start());
        stop.addActionListener(e -> timer.stop());
        reset.addActionListener(e -> {
            timer.stop();
            time = 0;
            label.setText(formatTime(time));
        });

        setVisible(true);
    }

    private String formatTime(int seconds) {
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        return String.format("%02d:%02d", minutes, remainingSeconds);
    }
}
