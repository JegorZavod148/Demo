import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.model = model;
        this.view = view;
        view.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.setText(model.getText());
    }
}
