package mainPackage.window.adapters;

import mainPackage.Main;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LightMenuActionAdapter implements ActionListener {
    private JFrame frame;
    private final boolean mode;

    public LightMenuActionAdapter(JFrame frame, boolean mode) {
        this.frame = frame;
        this.mode = mode;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Main.getFigure().setLightOn(mode);
        frame.getContentPane().repaint();
    }
}
