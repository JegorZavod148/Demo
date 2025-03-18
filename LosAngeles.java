import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class LosAngeles extends JFrame implements KeyListener {

    private JLabel slot1, slot2, slot3;
    private JButton spin;
    private Timer timer1, timer2, timer3;
    private Random random = new Random();
    private JButton button;
    private Timer timer;
    private boolean isRed = true;
    private JButton win;

    LosAngeles() {
        setTitle("Los Angeles Casino");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        addKeyListener(this);
        setFocusable(true);

        button = new JButton("CASINO");
        button.setPreferredSize(new Dimension(300, 100));
        button.setBackground(Color.GREEN);
        button.setForeground(Color.BLUE);
        button.setFont(new Font("Arial", Font.BOLD, 40));
        add(button, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(1, 3, 10, 10));
        slot1 = createLabel();
        slot2 = createLabel();
        slot3 = createLabel();
        panel.add(slot1);
        panel.add(slot2);
        panel.add(slot3);
        add(panel, BorderLayout.CENTER);

        spin = new JButton(">!SPIN!<");
        spin.setPreferredSize(new Dimension(300, 80));
        spin.setBackground(Color.YELLOW);
        spin.setForeground(Color.RED);
        spin.setFont(new Font("Arial", Font.BOLD, 40));
        spin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });
        add(spin, BorderLayout.SOUTH);

        win = new JButton("WIN!!!!!");
        win.setBackground(Color.YELLOW);
        win.setForeground(Color.RED);
        win.setFont(new Font("Arial", Font.BOLD, 70));
        win.addKeyListener(this);

        setVisible(true);
    }

    public JLabel createLabel() {
        JLabel label = new JLabel("0", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 60));
        label.setOpaque(true);
        label.setBackground(Color.WHITE);
        return label;
    }

    public void start() {
        spin.setEnabled(false);

        timer1 = createTimer(slot1, 50, 2000);
        timer2 = createTimer(slot2, 50, 3000);
        timer3 = createTimer(slot3, 50, 4000);
        timer1.start();
        timer2.start();
        timer3.start();

        Spinblink();
    }

    public Timer createTimer(JLabel label, int speed, int duration) {
        Timer timer = new Timer(speed, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(String.valueOf(random.nextInt(10)));
            }
        });

        new Timer(duration, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                if (Integer.parseInt(slot1.getText()) == 7 &&
                        Integer.parseInt(slot2.getText()) == 7 &&
                        Integer.parseInt(slot3.getText()) == 7) {
                    add(win, BorderLayout.CENTER);
                    winBlink();
                }
                spin.setEnabled(true);
            }
        }).
                start();

        return timer;
    }

    public void Spinblink() {
        timer = new Timer(100, new ActionListener() {
            int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (count >= 40) {
                    timer.stop();
                }

                if (isRed) {
                    spin.setBackground(Color.RED);
                    spin.setForeground(Color.YELLOW);
                } else {
                    spin.setBackground(Color.YELLOW);
                    spin.setForeground(Color.RED);
                }
                isRed = !isRed;
                count++;
            }
        });

        timer.start();
    }

    public void winBlink() {
        timer = new Timer(100, new ActionListener() {
            int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (count >= 40) {
                    timer.stop();
                }

                if (isRed) {
                    win.setBackground(Color.RED);
                    win.setForeground(Color.YELLOW);
                } else {
                    win.setBackground(Color.YELLOW);
                    win.setForeground(Color.RED);
                }
                isRed = !isRed;
                count++;
            }
        });

        timer.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            add(win, BorderLayout.CENTER);
            winBlink();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
