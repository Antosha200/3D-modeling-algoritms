package mainPackage;

import mainPackage.geometry.Figure;
import mainPackage.geometry.MyFigure;
import mainPackage.window.MainFrame;

public class Main {
    private static Figure figure;

    public static void main(String[] args) {
        figure = new MyFigure(300, 200, 100, 50, 100);
        new MainFrame("3D");
    }

    public static Figure getFigure() {
        return figure;
    }
}
