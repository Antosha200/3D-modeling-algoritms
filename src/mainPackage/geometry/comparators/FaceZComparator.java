package mainPackage.geometry.comparators;

import mainPackage.geometry.Face;
import mainPackage.geometry.Vertex;

import java.util.Comparator;

public class FaceZComparator implements Comparator<Face> {
    @Override
    public int compare(Face o1, Face o2) {
        int z1 = 0, z2 = 0;
        int n = 0;
        for (Vertex v : o1.getVertices()) {
            z1 += v.getZ();
            n++;
        }
        z1 = z1 / n;
        n = 0;
        for (Vertex v : o2.getVertices()) {
            z2 += v.getZ();
            n++;
        }
        z2 = z2 / n;
        return z2 - z1;
    }
}
