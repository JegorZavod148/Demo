import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Slider extends JPanel implements MouseMotionListener {

    private int stickCount = 5;
    private int stickX;
    private int currentValue;

    public Slider(int w, int h, int stickCount){
        setSize(w, h);
        this.stickCount = stickCount;
        stickX = getWidth()/2;
        addMouseMotionListener(this);
    }

    public void setStickCount(int stickCount){
        this.stickCount = stickCount;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.BLACK);
        g.drawLine(10, getHeight()/2, getWidth()-10, getHeight()/2);

        for (int i = 0; i <= stickCount; i++) {
            g.drawLine(10 + (getWidth()-20)/stickCount*i, getHeight()/2-10, 10 + (getWidth() - 20) / stickCount * i, getHeight()/2+10);
        }
        g.setColor(Color.RED);
        g.fillOval(stickX, getHeight()/2-10, 20, 20);

        g.setColor(Color.BLACK);
        g.drawString("Value: " + currentValue, 10, getHeight() - 2);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        stickX = e.getX();
        if(stickX<10) stickX = 10;
        if(stickX>getWidth()-10) stickX = getWidth()-10;

        int range = getWidth() - 20;
        int step = range / stickCount;
        currentValue = (stickX - 10 + step / 2) / step;

        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
