package mainPackage.window.dialogWindow;

import mainPackage.Main;
import mainPackage.geometry.Figure;

import static java.lang.Math.toRadians;

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

public class SetObliqueParametersDialog extends JDialog {
    private JTextField lTextField;
    private JTextField aTextField;

    private JFrame frame;

    public SetObliqueParametersDialog(JFrame frame) {
        super(frame, "Set Oblique Parameters", true);
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
            double l = 0, a = 0;
            try {
                l = Double.parseDouble(lTextField.getText());
                a = Double.parseDouble(aTextField.getText());
            } catch (Exception ignored) {
                return;
            }
            Figure figure = Main.getFigure();
            figure.setOblique(l, toRadians(a));
            frame.getContentPane().repaint();
            this.dispose();
        };
    }

    private JPanel createTextFields() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(new JLabel("l:"));
        lTextField = new JTextField("0.5");
        panel.add(lTextField);
        panel.add(new JLabel("ro:"));
        aTextField = new JTextField("45");
        panel.add(aTextField);
        return panel;
    }
}
