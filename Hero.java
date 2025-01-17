import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Hero extends JButton implements ActionListener {

    private Image image;
    int backgroundX;
    private ImgThread imgThread;
    private int pointX = 0;
    private boolean isRightPos = true;

    public Hero(String path)  {
        setLayout(null);
        addActionListener(this);

        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        imgThread = new ImgThread(this);
        imgThread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        if(image != null){
            Graphics2D g2d = (Graphics2D) g.create();
            if(!isRightPos){
                g2d.scale(-1, 1);
                g2d.translate(-getWidth(), 0);
            }
            g.drawImage(image, backgroundX, -40, 400, 200, this);
        } else {
            g.setColor(Color.RED);
            g.drawString("Не вдалося завантажити зображення!", 50, 50);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        backgroundX = -100;
        repaint();
    }

    public void stepRight() {
        isRightPos = true;
        setBounds(getX() + 100, getY(), getWidth(), getHeight());
        repaint();
    }

    public void stepLeft() {
        isRightPos = false;
        setBounds(getX() - 100, getY(), getWidth(), getHeight());
        repaint();
    }
}