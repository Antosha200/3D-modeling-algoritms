package mainPackage.window.adapters;

import mainPackage.Main;
import mainPackage.window.dialogWindow.SetAxonometricParametersDialog;
import mainPackage.window.dialogWindow.SetObliqueParametersDialog;
import mainPackage.window.dialogWindow.SetPerspectiveParametersDialog;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectionsActionAdapter implements ActionListener {
    private JFrame frame;
    private final byte mode;

    public ProjectionsActionAdapter(JFrame frame, byte mode) {
        this.frame = frame;
        this.mode = mode;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Main.getFigure().setProjectionMode(mode);
        switch (mode) {
            case 0:
                Main.getFigure().setProjectionPlane(mode);
                break;
            case 1:
                Main.getFigure().setProjectionPlane(mode);
                break;
            case 2:
                Main.getFigure().setProjectionPlane(mode);
                break;
            case 3:
                SetAxonometricParametersDialog axonometricParametersDialog = new SetAxonometricParametersDialog(frame);
                axonometricParametersDialog.setVisible(true);
                break;
            case 4:
                SetObliqueParametersDialog obliqueParametersDialog = new SetObliqueParametersDialog(frame);
                obliqueParametersDialog.setVisible(true);
                break;
            case 5:
                SetPerspectiveParametersDialog perspectiveParametersDialog = new SetPerspectiveParametersDialog(frame);
                perspectiveParametersDialog.setVisible(true);
                break;
        }
        frame.getContentPane().repaint();
    }
}
