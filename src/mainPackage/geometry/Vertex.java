package mainPackage.geometry;

public class Vertex {
    private double[][] coordinates;
    private double[][] oldCoordinates;

    public Vertex(double x, double y, double z) {
        oldCoordinates = new double[][]{{x, y, z, 1}};
        coordinates = oldCoordinates;
    }

    public Vertex(double[][] coordinates) {
        this.coordinates = coordinates;
        this.oldCoordinates = coordinates;
    }

    public Vertex(Vertex vertex) {
        coordinates = vertex.coordinates;
        oldCoordinates = vertex.oldCoordinates;
    }

    public void resetCoordinates() {
        coordinates = oldCoordinates;
    }

    public double[][] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[][] coordinates) {
        this.coordinates = coordinates;
    }

    public void setX(double x) {
        coordinates[0][0] = x;
    }

    public void setY(double y) {
        coordinates[0][1] = y;
    }

    public void setZ(double z) {
        coordinates[0][2] = z;
    }

    public double getX() {
        return coordinates[0][0];
    }

    public double getY() {
        return coordinates[0][1];
    }

    public double getZ() {
        return coordinates[0][2];
    }

    public double getLast() {
        return coordinates[0][3];
    }
}
