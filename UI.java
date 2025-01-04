import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI extends JFrame implements MouseMotionListener {

    private Label label = new Label();
    private int x = 0;
    private int y = 0;
    private Color currentColor = Color.BLACK;
    private int brushSize = 2;

    UI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 700);
        addMouseMotionListener(this);
        setLayout(null);

        label.setBounds(20,20,200,100);
        add(label);

        JButton button = new JButton();
        button.setText("ERASE");
        button.setBounds(100, 150, 100, 50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Graphics g = getGraphics();

                g.setColor(Color.WHITE);
                g.fillRect(0, 0, 500, 700);
            }
        });
        add(button);

        JButton colorButton = new JButton("COLOR");
        colorButton.setBounds(100, 220, 100, 50);
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentColor = JColorChooser.showDialog(null, "Choose a color", currentColor);
                if (currentColor == null) {
                    currentColor = Color.BLACK;
                }
            }
        });
        add(colorButton);

        JButton sizeButton = new JButton("BRUSH SIZE");
        sizeButton.setBounds(100, 290, 100, 50);
        sizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Введіть розмір кисті:");
                    int newSize = Integer.parseInt(input);
                    if (newSize > 0 && newSize <= 20) {
                        brushSize = newSize;
                    } else {
                        JOptionPane.showMessageDialog(null, "Ти сліпий? Написано від 1 до 20");
                    }
            }
        });
        add(sizeButton);


        setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent e){
        label.setText("X: "+e.getX()+" Y: "+e.getY());
        Graphics g = getGraphics();

        g.drawLine(x, y, e.getX(), e.getY());
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e){

    }

}
