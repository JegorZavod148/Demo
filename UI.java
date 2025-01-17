import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class UI extends JFrame implements KeyListener {

    private Hero hero;

    UI (){
        setSize(1000, 700);
        setLayout(null);
        addKeyListener(this);
        setFocusable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        hero = new Hero("src/SPRITE.png");
        hero.setBounds(150, 250, 200, 100);

        add(hero);
        setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case 68:
                hero.stepRight();
                break;
            case 65:
                hero.stepLeft();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
