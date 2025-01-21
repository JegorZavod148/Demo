import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UISetting extends JFrame implements ActionListener {

    private UI ui;
    private Label label;

    public UISetting(UI ui) {
        this.ui = ui;
        setTitle("UI Setting");
        setSize(400, 300);
        setLayout(new FlowLayout());

        JButton button = new JButton("GRAY");
        add(button);
        button.addActionListener(this);

        JButton button1 = new JButton("Вказати назву");
        add(button1);
        button1.addActionListener(this);

        JButton button2 = new JButton("Змінити розмір");
        button2.addActionListener(this);
        add(button2);

        JButton button3 = new JButton("WHITE");
        button3.addActionListener(this);
        add(button3);

        label = new Label("ВІКНО АНІМАЦІЇ");
        label.setBackground(Color.WHITE);
        label.setBounds(200, 10, 100, 30);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("GRAY")){
            ui.getContentPane().setBackground(Color.GRAY);
        }
        if (e.getActionCommand().equals("Вказати назву")){
            ui.getContentPane().add(label);
        }
        if (e.getActionCommand().equals("Змінити розмір")) {
            ui.setSize(800, 600);
        }
        if (e.getActionCommand().equals("WHITE")) {
            ui.getContentPane().setBackground(Color.WHITE);
        }
    }
}
