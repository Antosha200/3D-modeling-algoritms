package mainPackage.geometry;

import mainPackage.geometry.comparators.FaceXComparator;
import mainPackage.geometry.comparators.FaceYComparator;
import mainPackage.geometry.comparators.FaceZComparator;

import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.util.Arrays;

public abstract class Figure {
    private Face[] faces;
    private Vertex[] vertices;
    private Vertex center;
    private Vertex light = new Vertex(300, 300, -200);
    private double diffusedLightIntensivity = 255;
    private double diffusedLightK = 0.5;
    private double ambientLightIntensivity = 255;
    private double ambientLightK = 0.5;
    private double d = 200, ro = 100, fi = 0, teta = 0;
    private boolean isLightOn = false;
    private boolean isDeleteInvisible = false;
    private byte projectionMode = 0b0;
    private byte projectionPlane = 0b0;

    public abstract void buildVertices();

    public abstract void buildFaces();

    public abstract void buildEdges();

    public void drawFigure(Graphics2D graphics2D, int width, int height) {
        Face[] facesCopy = new Face[faces.length];
        for (int i = 0; i < facesCopy.length; i++)
            facesCopy[i] = new Face(faces[i]);
        switch (projectionMode) {
            case 3:
                axonometric(facesCopy);
                break;
            case 4:
                oblique(facesCopy);
                break;
            case 5:
                perspective(facesCopy);
                break;
        }
        if (isDeleteInvisible) {
            graphics2D.setStroke(new BasicStroke(1));
            Vector light = null;
            if (isLightOn)
                light = new Vector(this.light.getX() - center.getX(),
                        this.light.getY() - center.getY(),
                        this.light.getZ() - center.getZ());
            switch (projectionMode) {
                case 1:
                    Arrays.sort(facesCopy, new FaceYComparator());
                    for (Face face : facesCopy)
                        face.drawFaceXZ(graphics2D, light, width, height);
                    break;
                case 2:
                    Arrays.sort(facesCopy, new FaceXComparator());
                    for (Face face : facesCopy)
                        face.drawFaceYZ(graphics2D, light, width, height);
                    break;
                default:
                    Arrays.sort(facesCopy, new FaceZComparator());
                    for (Face face : facesCopy)
                        face.drawFaceXY(graphics2D, light, width, height);
                    break;
            }
        } else
            switch (projectionMode) {
                case 1:
                    for (Face face : facesCopy)
                        face.drawEdgesXZ(graphics2D, width, height);
                    break;
                case 2:
                    for (Face face : facesCopy)
                        face.drawEdgesYZ(graphics2D, width, height);
                    break;
                default:
                    for (Face face : facesCopy)
                        face.drawEdgesXY(graphics2D, width, height);
                    break;
            }
    }

    public void rotate(double angleX, double angleY, double angleZ) {
        for (Vertex v : vertices) {
            GeometricOperations.rotate(v, angleX, angleY, angleZ);
        }
        GeometricOperations.rotate(center, angleX, angleY, angleZ);
    }

    public void transit(double dx, double dy, double dz) {
        for (Vertex v : vertices) {
            GeometricOperations.transit(v, dx, dy, dz);
        }
        GeometricOperations.transit(center, dx, dy, dz);
    }

    public void scale(double sx, double sy, double sz) {
        for (Vertex v : vertices) {
            GeometricOperations.scale(v, sx, sy, sz);
        }
        GeometricOperations.scale(center, sx, sy, sz);
    }

    private void perspective(Face[] faces) {
        for (Face face : faces) {
            for (Vertex vertex : face.getVertices())
                GeometricOperations.perspective(vertex, d, ro, fi, teta);
            for (Edge edge : face.getEdges()) {
                GeometricOperations.perspective(edge.getV1(), d, ro, fi, teta);
                GeometricOperations.perspective(edge.getV2(), d, ro, fi, teta);
            }
        }
    }

    private void oblique(Face[] faces) {
        for (Face face : faces) {
            for (Vertex vertex : face.getVertices())
                GeometricOperations.oblique(vertex, d, ro);
            for (Edge edge : face.getEdges()) {
                GeometricOperations.oblique(edge.getV1(), d, ro);
                GeometricOperations.oblique(edge.getV2(), d, ro);
            }
        }
    }

    private void axonometric(Face[] faces) {
        for (Face face : faces) {
            for (Vertex vertex : face.getVertices())
                GeometricOperations.axonometric(vertex, teta, fi);
            for (Edge edge : face.getEdges()) {
                GeometricOperations.axonometric(edge.getV1(), teta, fi);
                GeometricOperations.axonometric(edge.getV2(), teta, fi);
            }
        }
    }

    public void reset() {
        for (Vertex v : vertices) {
            v.resetCoordinates();
        }
        center.resetCoordinates();
    }

    public Face[] getFaces() {
        return faces;
    }

    public void setFaces(Face[] faces) {
        this.faces = faces;
    }

    public Vertex[] getVertices() {
        return vertices;
    }

    public void setVertices(Vertex[] vertices) {
        this.vertices = vertices;
    }

    public Vertex getCenter() {
        return center;
    }

    public void setCenter(Vertex center) {
        this.center = center;
    }

    public Vertex getLight() {
        return light;
    }

    public void setLight(Vertex light) {
        this.light = light;
    }

    public double getDiffusedLightIntensivity() {
        return diffusedLightIntensivity;
    }

    public void setDiffusedLightIntensivity(double diffusedLightIntensivity) {
        this.diffusedLightIntensivity = diffusedLightIntensivity;
    }

    public double getDiffusedLightK() {
        return diffusedLightK;
    }

    public void setDiffusedLightK(double diffusedLightK) {
        this.diffusedLightK = diffusedLightK;
    }

    public double getDiffisedLight() {
        return diffusedLightIntensivity * diffusedLightK;
    }

    public double getAmbientLightIntensivity() {
        return ambientLightIntensivity;
    }

    public void setAmbientLightIntensivity(double ambientLightIntensivity) {
        this.ambientLightIntensivity = ambientLightIntensivity;
    }

    public double getAmbientLightK() {
        return ambientLightK;
    }

    public void setAmbientLightK(double ambientLightK) {
        this.ambientLightK = ambientLightK;
    }

    public double getAmbientLight() {
        return ambientLightIntensivity * ambientLightK;
    }

    public void setPerspective(double d, double ro, double fi, double teta) {
        this.d = d;
        this.ro = ro;
        this.fi = fi;
        this.teta = teta;
    }

    public double getD() {
        return d;
    }

    public double getRo() {
        return ro;
    }

    public double getFi() {
        return fi;
    }

    public double getTeta() {
        return teta;
    }

    public void setOblique(double l, double a) {
        this.d = l;
        this.ro = a;
    }

    public void setAxonometric(double psi, double fi) {
        this.teta = psi;
        this.fi = fi;
    }

    public void setLightOn(boolean lightOn) {
        isLightOn = lightOn;
    }

    public void setDeleteInvisible(boolean deleteInvisible) {
        isDeleteInvisible = deleteInvisible;
    }

    public void setProjectionMode(byte projectionMode) {
        this.projectionMode = projectionMode;
    }

    public void setProjectionPlane(byte projectionPlane) {
        this.projectionPlane = projectionPlane;
    }
}