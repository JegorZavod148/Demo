import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {

    private JLabel label;
    private JButton button;

    View(){
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        label = new JLabel("BIDEN");
        label.setBounds(200, 0, 300, 100);
        label.setForeground(Color.GREEN);
        label.setFont(new Font("Arial", Font.BOLD, 60));
        add(label);

        button = new JButton("ВИБОРИ");
        button.setBounds(200, 150, 200, 50);
        button.setForeground(Color.GREEN);
        button.setBackground(Color.BLACK);
        add(button);

        setVisible(true);
    }

    public void setActionListener(ActionListener listener){
        button.addActionListener(listener);
    }

    public void setText(String text){
        label.setText(text);
    }
}
