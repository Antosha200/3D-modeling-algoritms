package mainPackage.window.dialogWindow;

import mainPackage.Main;
import mainPackage.geometry.Figure;

import static java.lang.Math.toRadians;
import static java.lang.Math.toDegrees;

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

public class SetPerspectiveParametersDialog extends JDialog {
    private JTextField dTextField;
    private JTextField roTextField;
    private JTextField fiTextField;
    private JTextField tetaTextField;

    private JFrame frame;

    public SetPerspectiveParametersDialog(JFrame frame) {
        super(frame, "Set Perspective Parameters", true);
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
            double d = 0, ro = 0, fi = 0, teta = 0;
            try {
                d = Double.parseDouble(dTextField.getText());
                ro = Double.parseDouble(roTextField.getText());
                fi = Double.parseDouble(fiTextField.getText());
                teta = Double.parseDouble(tetaTextField.getText());
            } catch (Exception ignored) {
                return;
            }
            Figure figure = Main.getFigure();
            figure.setPerspective(d, ro, toRadians(fi), toRadians(teta));
            frame.getContentPane().repaint();
            this.dispose();
        };
    }

    private JPanel createTextFields() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(new JLabel("d:"));
        dTextField = new JTextField(Double.toString(Main.getFigure().getD()));
        panel.add(dTextField);
        panel.add(new JLabel("ro:"));
        roTextField = new JTextField(Double.toString(Main.getFigure().getRo()));
        panel.add(roTextField);
        panel.add(new JLabel("fi:"));
        fiTextField = new JTextField(Double.toString(toDegrees(Main.getFigure().getFi())));
        panel.add(fiTextField);
        panel.add(new JLabel("teta:"));
        tetaTextField = new JTextField(Double.toString(toDegrees(Main.getFigure().getTeta())));
        panel.add(tetaTextField);
        return panel;
    }
}
