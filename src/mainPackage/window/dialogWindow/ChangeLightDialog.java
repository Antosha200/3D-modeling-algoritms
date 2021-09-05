package mainPackage.window.dialogWindow;

import mainPackage.Main;
import mainPackage.geometry.Figure;
import mainPackage.geometry.Vertex;

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

public class ChangeLightDialog extends JDialog {
    private JTextField xTextField;
    private JTextField yTextField;
    private JTextField zTextField;
    private JTextField diffusedIntensivityTextField;
    private JTextField diffusedKTextField;
    private JTextField ambientIntensivityTextField;
    private JTextField ambientKTextField;

    private JFrame frame;

    public ChangeLightDialog(JFrame frame) {
        super(frame, "Change Light", true);
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
            double x = 0, y = 0, z = 0, id = 0, kd = 0, ia = 0, ka = 0;
            try {
                x = Double.parseDouble(xTextField.getText());
                y = Double.parseDouble(yTextField.getText());
                z = Double.parseDouble(zTextField.getText());
                id = Double.parseDouble(diffusedIntensivityTextField.getText());
                kd = Double.parseDouble(diffusedKTextField.getText());
                if (kd > 1 || kd < 0) return;
                ia = Double.parseDouble(ambientIntensivityTextField.getText());
                ka = Double.parseDouble(ambientKTextField.getText());
                if (ka > 1 || ka < 0) return;
            } catch (Exception ignored) {
                return;
            }
            Figure figure = Main.getFigure();
            figure.setLight(new Vertex(x, y, z));
            figure.setDiffusedLightIntensivity(id);
            figure.setDiffusedLightK(kd);
            figure.setAmbientLightIntensivity(ia);
            figure.setAmbientLightK(ka);
            frame.getContentPane().repaint();
            this.dispose();
        };
    }

    private JPanel createTextFields() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(new JLabel("x:"));
        xTextField = new JTextField(Double.toString(Main.getFigure().getLight().getX()));
        panel.add(xTextField);
        panel.add(new JLabel("y:"));
        yTextField = new JTextField(Double.toString(Main.getFigure().getLight().getY()));
        panel.add(yTextField);
        panel.add(new JLabel("z:"));
        zTextField = new JTextField(Double.toString(Main.getFigure().getLight().getZ()));
        panel.add(zTextField);
        panel.add(new JLabel("Id:"));
        diffusedIntensivityTextField = new JTextField(Double.toString(Main.getFigure().getDiffusedLightIntensivity()));
        panel.add(diffusedIntensivityTextField);
        panel.add(new JLabel("Kd:"));
        diffusedKTextField = new JTextField(Double.toString(Main.getFigure().getDiffusedLightK()));
        panel.add(diffusedKTextField);
        panel.add(new JLabel("Ia:"));
        ambientIntensivityTextField = new JTextField(Double.toString(Main.getFigure().getAmbientLightIntensivity()));
        panel.add(ambientIntensivityTextField);
        panel.add(new JLabel("Ka:"));
        ambientKTextField = new JTextField(Double.toString(Main.getFigure().getAmbientLightK()));
        panel.add(ambientKTextField);
        return panel;
    }
}
