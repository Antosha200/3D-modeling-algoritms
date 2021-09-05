package mainPackage.window.dialogWindow;

import mainPackage.Main;
import mainPackage.geometry.MyFigure;

import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class ChangeFigureSizeDialog extends JDialog {
    private JTextField aTextField;
    private JTextField bTextField;
    private JTextField cTextField;
    private JTextField a1TextField;
    private JTextField c1TextField;

    private JFrame frame;

    public ChangeFigureSizeDialog(JFrame frame) {
        super(frame, "Change Figure Size", true);
        this.frame = frame;

        Container container = getContentPane();
        container.setLayout(new GridLayout(2, 1, 0, 0));

        container.add(createTextFields());
        container.add(createOkButton());

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private JPanel createOkButton() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton okButton = new JButton("Ok");
        okButton.addActionListener(createOkActionListener());
        panel.add(okButton);
        return panel;
    }

    private ActionListener createOkActionListener() {
        return e -> {
            double a = 0, b = 0, c = 0, a1 = 0, c1 = 0;
            try {
                a = Double.parseDouble(aTextField.getText());
                b = Double.parseDouble(bTextField.getText());
                c = Double.parseDouble(cTextField.getText());
                a1 = Double.parseDouble(a1TextField.getText());
                c1 = Double.parseDouble(c1TextField.getText());
                if (a <= 0 || b <= 0 || c <= 0 || a1 <= 0 || c1 <= 0) return;
            } catch (Exception ignored) {
                return;
            }
            MyFigure figure = (MyFigure) Main.getFigure();
            figure.changeFigureSize(a, b, c, a1, c1);
            frame.getContentPane().repaint();
            this.dispose();
        };
    }

    private JPanel createTextFields() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(new JLabel("a:"));
        aTextField = new JTextField("200");
        panel.add(aTextField);
        panel.add(new JLabel("b:"));
        bTextField = new JTextField("200");
        panel.add(bTextField);
        panel.add(new JLabel("c:"));
        cTextField = new JTextField("200");
        panel.add(cTextField);
        panel.add(new JLabel("a1:"));
        a1TextField = new JTextField("100");
        panel.add(a1TextField);
        panel.add(new JLabel("c1:"));
        c1TextField = new JTextField("100");
        panel.add(c1TextField);
        return panel;
    }
}
