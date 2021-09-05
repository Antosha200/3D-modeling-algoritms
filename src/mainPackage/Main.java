package mainPackage;

import mainPackage.geometry.Figure;
import mainPackage.geometry.MyFigure;
import mainPackage.window.MainFrame;

public class Main {
    private static Figure figure;

    public static void main(String[] args) {
        figure = new MyFigure(200, 200, 200, 100, 100);
        new MainFrame("3D");
    }

    public static Figure getFigure() {
        return figure;
    }
}
