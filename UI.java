import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame implements ActionListener {

    private JTextField textField = new JTextField();
    private String sign;
    private int num;

    public UI() {
        setTitle("Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textField.setFont(new Font("TimesNewRoman", Font.PLAIN, 24));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        textField.setBackground(Color.DARK_GRAY);
        textField.setForeground(Color.GREEN);
        add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));
        panel.setBackground(Color.WHITE);

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "+/-", "0", "=", "+",
                "del", "%", "√", "x^2"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("TimesNewRoman", Font.BOLD, 18));
            button.setBackground(Color.DARK_GRAY);
            button.setForeground(Color.GREEN);
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER); // Додаємо панель із кнопками в центр

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        switch (e.getActionCommand()){
            case "7" -> textField.setText(textField.getText()+"7");
            case "4" -> textField.setText(textField.getText()+"4");
            case "1" -> textField.setText(textField.getText()+"1");
            case "8" -> textField.setText(textField.getText()+"8");
            case "5" -> textField.setText(textField.getText()+"5");
            case "2" -> textField.setText(textField.getText()+"2");
            case "9" -> textField.setText(textField.getText()+"9");
            case "6" -> textField.setText(textField.getText()+"6");
            case "3" -> textField.setText(textField.getText()+"3");
            case "0" -> textField.setText(textField.getText()+"0");
            case "-" -> {
                sign = "-";
                num = Integer.parseInt(textField.getText());
                textField.setText("");
            }
            case "+" -> {
                sign = "+";
                num = Integer.parseInt(textField.getText());
                textField.setText("");
            }
            case "/" -> {
                sign = "/";
                num = Integer.parseInt(textField.getText());
                textField.setText("");
            }
            case "*" -> {
                sign = "*";
                num = Integer.parseInt(textField.getText());
                textField.setText("");
            }
            case "=" -> {
                switch (sign){
                    case "*" -> textField.setText(String.valueOf(num * Integer.parseInt(textField.getText())));
                    case "/" -> textField.setText(String.valueOf(num / Integer.parseInt(textField.getText())));
                    case "-" -> textField.setText(String.valueOf(num - Integer.parseInt(textField.getText())));
                    case "+" -> textField.setText(String.valueOf(num + Integer.parseInt(textField.getText())));
                }
            }
        }
    }
}
