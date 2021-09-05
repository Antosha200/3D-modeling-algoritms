package mainPackage.geometry;

import mainPackage.Main;

import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Polygon;
import java.awt.Color;

public class Face {
    private Vertex[] vertices;
    private Edge[] edges;

    public Face(Vertex... vertices) {
        this.vertices = vertices;
    }

    public Face(Face f) {
        Vertex[] vert = f.vertices;
        Edge[] edg = f.edges;
        vertices = new Vertex[vert.length];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Vertex(vert[i]);
        }
        edges = new Edge[edg.length];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new Edge(edg[i]);
        }
    }

    public void drawFaceXY(Graphics2D graphics2D, Vector light, int width, int height) {
        Vector nVect = new Vector(vertices[0], vertices[1], vertices[2]);
        if (nVect.cos(new Vector(0, 0, -1)) >= 0) {
            graphics2D.setStroke(new BasicStroke(1));

            int[] y = new int[vertices.length];
            int[] x = new int[vertices.length];
            for (int i = 0; i < vertices.length; i++) {
                y[i] = -(int) vertices[i].getY() + height / 2;
                x[i] = (int) vertices[i].getX() + width / 2;
            }
            Polygon p = new Polygon(x, y, x.length);
            if (light != null) {
                int clr = createLight(nVect.cos(light));
                graphics2D.setColor(new Color(clr, clr, clr));
            } else
                graphics2D.setColor(Color.WHITE);
            graphics2D.fillPolygon(p);
            drawEdgesXY(graphics2D, width, height);
        }
    }

    public void drawFaceXZ(Graphics2D graphics2D, Vector light, int width, int height) {
        Vector nVect = new Vector(vertices[0], vertices[1], vertices[2]);
        if (nVect.cos(new Vector(0, -1, 0)) >= 0) {
            graphics2D.setStroke(new BasicStroke(1));

            int[] z = new int[vertices.length];
            int[] x = new int[vertices.length];
            for (int i = 0; i < vertices.length; i++) {
                z[i] = -(int) vertices[i].getZ() + height / 2;
                x[i] = (int) vertices[i].getX() + width / 2;
            }
            Polygon p = new Polygon(x, z, x.length);
            if (light != null) {
                int clr = createLight(nVect.cos(light));
                graphics2D.setColor(new Color(clr, clr, clr));
            } else
                graphics2D.setColor(Color.WHITE);
            graphics2D.fillPolygon(p);
            drawEdgesXZ(graphics2D, width, height);
        }
    }

    public void drawFaceYZ(Graphics2D graphics2D, Vector light, int width, int height) {
        Vector nVect = new Vector(vertices[0], vertices[1], vertices[2]);
        if (nVect.cos(new Vector(-1, 0, 0)) >= 0) {
            graphics2D.setStroke(new BasicStroke(1));

            int[] y = new int[vertices.length];
            int[] z = new int[vertices.length];
            for (int i = 0; i < vertices.length; i++) {
                y[i] = -(int) vertices[i].getY() + height / 2;
                z[i] = (int) vertices[i].getZ() + width / 2;
            }
            Polygon p = new Polygon(z, y, z.length);
            if (light != null) {
                int clr = createLight(nVect.cos(light));
                graphics2D.setColor(new Color(clr, clr, clr));
            } else
                graphics2D.setColor(Color.WHITE);
            graphics2D.fillPolygon(p);
            drawEdgesYZ(graphics2D, width, height);
        }
    }

    public void drawEdgesXY(Graphics2D graphics2D, int width, int height) {
        graphics2D.setStroke(new BasicStroke(2));
        graphics2D.setColor(Color.BLACK);
        for (Edge edge : edges) {
            edge.drawEdgeXY(graphics2D, width, height);
        }
    }

    public void drawEdgesXZ(Graphics2D graphics2D, int width, int height) {
        graphics2D.setStroke(new BasicStroke(2));
        graphics2D.setColor(Color.BLACK);
        for (Edge edge : edges) {
            edge.drawEdgeXZ(graphics2D, width, height);
        }
    }

    public void drawEdgesYZ(Graphics2D graphics2D, int width, int height) {
        graphics2D.setStroke(new BasicStroke(2));
        graphics2D.setColor(Color.BLACK);
        for (Edge edge : edges) {
            edge.drawEdgeYZ(graphics2D, width, height);
        }
    }

    private int createLight(double cos) {
        int clr = (int) (Main.getFigure().getAmbientLight() +
                cos * Main.getFigure().getDiffisedLight());
        if (clr > 255) clr = 255;
        if (clr < 0) clr = 0;
        return clr;
    }

    public Vertex[] getVertices() {
        return vertices;
    }

    public Edge[] getEdges() {
        return edges;
    }

    public void setEdges(Edge[] edges) {
        this.edges = edges;
    }
}
