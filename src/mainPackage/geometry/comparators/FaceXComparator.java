package mainPackage.geometry.comparators;

import mainPackage.geometry.Face;
import mainPackage.geometry.Vertex;

import java.util.Comparator;

public class FaceXComparator implements Comparator<Face> {
    @Override
    public int compare(Face o1, Face o2) {
        int x1 = 0, x2 = 0;
        int n = 0;
        for (Vertex v : o1.getVertices()) {
            x1 += v.getX();
            n++;
        }
        x1 = x1 / n;
        n = 0;
        for (Vertex v : o2.getVertices()) {
            x2 += v.getX();
            n++;
        }
        x2 = x2 / n;
        return x2 - x1;
    }
}
