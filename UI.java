import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class UI extends JFrame implements KeyListener, ActionListener {

    private Hero hero;
    private JButton settings;

    UI () {
        setSize(1000, 700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addKeyListener(this);

        settings = new JButton("Settings");
        settings.setBounds(10, 10, 100, 30);
        settings.addActionListener(this);
        add(settings);

        hero = new Hero("src/SPRITE.png");
        hero.setBounds(100, 200, 100, 120);
        add(hero);

        setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_D: // Код клавіші 'D'
                hero.stepRight();
                break;
            case KeyEvent.VK_A: // Код клавіші 'A'
                hero.stepLeft();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UISetting uiSetting = new UISetting(this);
    }
}
