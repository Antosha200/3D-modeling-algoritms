package mainPackage.geometry;

import java.awt.Graphics2D;

public class Edge {
    private Vertex v1;
    private Vertex v2;

    public Edge(Vertex v1, Vertex v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public Edge(Edge edge) {
        this.v1 = new Vertex(edge.v1);
        this.v2 = new Vertex(edge.v2);
    }

    public void drawEdgeXY(Graphics2D graphics2D, int width, int height) {
        graphics2D.drawLine((int) v1.getX() + width / 2,
                -(int) v1.getY() + height / 2,
                (int) v2.getX() + width / 2,
                -(int) v2.getY() + height / 2);
    }

    public void drawEdgeXZ(Graphics2D graphics2D, int width, int height) {
        graphics2D.drawLine((int) v1.getX() + width / 2,
                -(int) v1.getZ() + height / 2,
                (int) v2.getX() + width / 2,
                -(int) v2.getZ() + height / 2);
    }

    public void drawEdgeYZ(Graphics2D graphics2D, int width, int height) {
        graphics2D.drawLine((int) v1.getZ() + width / 2,
                -(int) v1.getY() + height / 2,
                (int) v2.getZ() + width / 2,
                -(int) v2.getY() + height / 2);
    }

    public double getX1() {
        return  v1.getCoordinates()[0][0];
    }
    public double getX2() {
        return  v2.getCoordinates()[0][0];
    }

    public double getY1() {
        return  v1.getCoordinates()[0][1];
    }
    public double getY2() {
        return  v2.getCoordinates()[0][1];
    }

    public double getZ1() {
        return  v1.getCoordinates()[0][2];
    }
    public double getZ2() {
        return  v2.getCoordinates()[0][2];
    }

    public Vertex getV1() {
        return v1;
    }
    public void setV1(Vertex v1) {
        this.v1 = v1;
    }

    public Vertex getV2() {
        return v2;
    }
    public void setV2(Vertex v2) {
        this.v2 = v2;
    }
}
