import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Hero extends JButton {

    Image image;
    int backgrounX;
    ImgThread imgThread;
    private boolean isRightPos = true;

    public Hero(String path)  {
        setLayout(null);

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

        if (image != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            if(!isRightPos){
                g2d.scale(-1, 1);
                g2d.translate(-getWidth(), 0);
            }
            g2d.setColor(new Color(0, 0,0,0));
            g2d.drawImage(image, backgrounX, -40, 900, 400, this);
            g2d.dispose();
        } else {
            g.setColor(Color.RED);
            g.drawString("Не вдалося завантажити зображення!", 50, 50);
        }
    }

    public void stepRight() {
        setBounds(getX() + 100, getY(), getWidth(), getHeight());
    }

    public void stepLeft() {
        setBounds(getX() - 100, getY(), getWidth(), getHeight());
    }

    public void stepUp() {
        setBounds(getX(), getY() - 100, getWidth(), getHeight());
    }

    public void stepDown() {
        setBounds(getX(), getY() + 100, getWidth(), getHeight());
    }
}

