package mainPackage.geometry;

import static java.lang.Math.sin;
import static java.lang.Math.cos;

public class GeometricOperations {

    public static void transit(Vertex vertex, double dx, double dy, double dz) {
        vertex.setCoordinates(multiplyByMatrix(vertex.getCoordinates(), createTransitMatr(dx, dy, dz)));
    }

    public static void scale(Vertex vertex, double sx, double sy, double sz) {
        vertex.setCoordinates(multiplyByMatrix(vertex.getCoordinates(), createScaleMatr(sx, sy, sz)));
    }

    public static void rotate(Vertex vertex, double angleX, double angleY, double angleZ) {
        vertex.setCoordinates(multiplyByMatrix(vertex.getCoordinates(), createRotateMatr(angleX, angleY, angleZ)));
    }

    public static void perspective(Vertex vertex, double d, double ro, double fi, double teta) {
        vertex.setCoordinates(multiplyByMatrix(vertex.getCoordinates(), createViewMatr(ro, fi, teta)));
        vertex.setCoordinates(new double[][]{{-vertex.getY(), vertex.getX(), vertex.getZ(), 1}});
        double z = vertex.getZ();
        if ((z < 0.1) && (z >= 0))
            vertex.setCoordinates(new double[][]{{vertex.getX(), vertex.getY(), 0.1, 1}});
        if ((z > -0.1) && (z <= 0))
            vertex.setCoordinates(new double[][]{{vertex.getX(), vertex.getY(), -0.1, 1}});
        vertex.setCoordinates(multiplyByMatrix(vertex.getCoordinates(), createPerspectiveMatr(d)));
        vertex.setCoordinates(new double[][]{{vertex.getX() / vertex.getLast(), vertex.getY() / vertex.getLast(),
                vertex.getZ(), 1}});
    }

    public static void oblique(Vertex vertex, double l, double a) {
        vertex.setCoordinates(multiplyByMatrix(vertex.getCoordinates(), createObliqueMatr(l, a)));
    }

    public static void axonometric(Vertex vertex, double psi, double fi) {
        vertex.setCoordinates(multiplyByMatrix(vertex.getCoordinates(), createRotateMatr(0, psi, 0)));
        vertex.setCoordinates(multiplyByMatrix(vertex.getCoordinates(), createRotateMatr(fi, 0, 0)));
    }

    private static double[][] createTransitMatr(double dx, double dy, double dz) {
        return new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {dx, dy, dz, 1}};
    }

    private static double[][] createScaleMatr(double sx, double sy, double sz) {
        return new double[][]{
                {sx, 0, 0, 0},
                {0, sy, 0, 0},
                {0, 0, sz, 0},
                {0, 0, 0, 1}};
    }

    private static double[][] createRotateMatr(double angleX, double angleY, double angleZ) {
        double[][] ROx = {
                {1.0, 0, 0, 0},
                {0, cos(angleX), sin(angleX), 0},
                {0, -sin(angleX), cos(angleX), 0},
                {0, 0, 0, 1.0}};
        double[][] ROy = {
                {cos(angleY), 0, -sin(angleY), 0},
                {0, 1.0, 0, 0},
                {sin(angleY), 0, cos(angleY), 0},
                {0, 0, 0, 1.0}};
        double[][] ROz = {
                {cos(angleZ), sin(angleZ), 0, 0},
                {-sin(angleZ), cos(angleZ), 0, 0},
                {0, 0, 1.0, 0},
                {0, 0, 0, 1.0}};
        return multiplyByMatrix(multiplyByMatrix(ROx, ROy), ROz);
    }

    private static double[][] createPerspectiveMatr(double d) {
        return new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 1 / d},
                {0, 0, 0, 0}};
    }

    private static double[][] createViewMatr(double ro, double fi, double teta) {
        return new double[][]{
                {-sin(teta), -cos(fi) * cos(teta), -sin(fi) * cos(teta), 0},
                {cos(teta), -cos(fi) * sin(teta), -sin(fi) * sin(teta), 0},
                {0, sin(fi), cos(fi), 0},
                {0, 0, ro, 1}};
    }

    private static double[][] createObliqueMatr(double l, double a) {
        return new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {l * cos(a), l * sin(a), 1, 0},
                {0, 0, 0, 1}};
    }

    private static double[][] createAxonometricMatr(double psi, double fi) {
        return new double[][]{
                {cos(psi), sin(fi) * sin(psi), 0, 0},
                {0, cos(fi), 0, 0},
                {sin(psi), -sin(fi) * cos(psi), 1, 0},
                {0, 0, 0, 1}};
    }

    private static double[][] multiplyByMatrix(double[][] m1, double[][] m2) {
        int m1ColLength = m1[0].length; // m1 columns length
        //int m2RowLength = m2.length;    // m2 rows length
        //if (m1ColLength != m2RowLength) return null; // matrix multiplication is not possible
        int mRRowLength = m1.length;    // m result rows length
        int mRColLength = m2[0].length; // m result columns length
        double[][] mResult = new double[mRRowLength][mRColLength];
        for (int i = 0; i < mRRowLength; i++) {         // rows from m1
            for (int j = 0; j < mRColLength; j++) {     // columns from m2
                for (int k = 0; k < m1ColLength; k++) { // columns from m1
                    mResult[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return mResult;
    }
}
