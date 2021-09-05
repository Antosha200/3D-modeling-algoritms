package mainPackage.geometry;

public class Vector {
    private double coordinates[];

    public Vector(double x, double y, double z) {
        coordinates = new double[]{x, y, z};
    }

    public Vector(Vertex v1, Vertex v2, Vertex v3) {
        double i1 = v2.getX() - v1.getX();
        double i2 = v3.getX() - v1.getX();
        double j1 = v2.getY() - v1.getY();
        double j2 = v3.getY() - v1.getY();
        double k1 = v2.getZ() - v1.getZ();
        double k2 = v3.getZ() - v1.getZ();

        double x = j1 * k2 - k1 * j2;
        double y = k1 * i2 - i1 * k2;
        double z = i1 * j2 - j1 * i2;

        coordinates = new double[]{x, y, z};
    }

    public double cos(Vector v) {
        double len1 = Math.sqrt(this.coordinates[0] * this.coordinates[0]
                + this.coordinates[1] * this.coordinates[1] + this.coordinates[2] * this.coordinates[2]);
        double len2 = Math.sqrt(v.coordinates[0] * v.coordinates[0]
                + v.coordinates[1] * v.coordinates[1] + v.coordinates[2] * v.coordinates[2]);
        double scalar = this.coordinates[0] * v.coordinates[0] + this.coordinates[1] * v.coordinates[1]
                + this.coordinates[2] * v.coordinates[2];
        return scalar / (len1 * len2);
    }
}
