import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class UI extends JFrame implements KeyListener, ActionListener{

    private Hero hero;
    private JButton settings;

    UI () {
        setSize(1000, 700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        hero = new Hero("src/sd(1).png");
        hero.setBounds(100, 200, 95, 120);
        add(hero);

        hero.addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();

        settings = new JButton("Settings");
        settings.setBounds(10, 10, 100, 30);
        settings.addActionListener(this);
        add(settings);

        setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case 39:
                hero.stepRight();
                break;
            case 37:
                hero.stepLeft();
                break;
            case 38:
                hero.stepUp();
                break;
            case 40:
                hero.stepDown();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new UISetting(this){};
    }
}
