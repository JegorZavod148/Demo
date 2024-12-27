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

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(Color.WHITE);

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
            button.setBackground(Color.DARK_GRAY);
            button.setForeground(Color.GREEN);
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);

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
            case "x^2" -> {
                sign = "x^2";
                num = Integer.parseInt(textField.getText());
                textField.setText("");
            }
            case "=" -> {
                switch (sign){
                    case "*" -> textField.setText(String.valueOf(num * Integer.parseInt(textField.getText())));
                    case "/" -> textField.setText(String.valueOf(num / Integer.parseInt(textField.getText())));
                    case "-" -> textField.setText(String.valueOf(num - Integer.parseInt(textField.getText())));
                    case "+" -> textField.setText(String.valueOf(num + Integer.parseInt(textField.getText())));
                    case "x^2" -> textField.setText(String.valueOf(num * num));
                    case "√" -> textField.setText(String.valueOf(Math.sqrt(num)));
                }
            }
            case "del" -> {
                textField.setText("");
                sign = "";
                num = 0;
            }
            case "√"->{
                sign = "√";
                num = Integer.parseInt(textField.getText());
                textField.setText("");
            }
        }
    }
}
