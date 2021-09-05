package mainPackage.window;

import mainPackage.Main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class DrawingComponent extends JPanel {
    private final JFrame frame;

    public DrawingComponent(JFrame frame) {
        super();
        this.frame = frame;
        setBackground(Color.WHITE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Main.getFigure().drawFigure((Graphics2D) g, frame.getWidth(), frame.getHeight());
    }
}
