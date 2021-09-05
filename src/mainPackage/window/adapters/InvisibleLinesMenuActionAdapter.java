package mainPackage.window.adapters;

import mainPackage.Main;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvisibleLinesMenuActionAdapter implements ActionListener {
    private JFrame frame;
    private final boolean mode;

    public InvisibleLinesMenuActionAdapter(JFrame frame, boolean mode) {
        this.frame = frame;
        this.mode = mode;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Main.getFigure().setDeleteInvisible(!mode);
        frame.getContentPane().repaint();
    }
}
