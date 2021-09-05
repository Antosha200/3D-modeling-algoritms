package mainPackage.geometry;

public class MyFigure extends Figure {
    private Face[] faces;
    private Vertex[] vertices;
    private double a, b, c, a1, c1;

    public MyFigure(double a, double b, double c, double a1, double c1) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.a1 = a1;
        this.c1 = c1;
        buildVertices();
        buildFaces();
        buildEdges();
    }

    @Override
    public void buildVertices() {
        vertices = new Vertex[]{
                new Vertex(-a / 2, -b / 2, -c / 2),
                new Vertex(-a / 2, b / 2, -c / 2),
                new Vertex(a / 2, b / 2, -c / 2),
                new Vertex(a / 2, -b / 2, -c / 2),
                new Vertex(a / 2, -b / 2, c / 2),
                new Vertex(a / 2, b / 2, c / 2),
                new Vertex(-a / 2, b / 2, c / 2),
                new Vertex(-a / 2, -b / 2, c / 2),
                new Vertex(a1 / 2, -b / 2, -c1 / 2),
                new Vertex(a1 / 2, b / 2, -c1 / 2),
                new Vertex(-a1 / 2, b / 2, -c1 / 2),
                new Vertex(-a1 / 2, -b / 2, -c1 / 2),
                new Vertex(-a1 / 2, -b / 2, c1 / 2),
                new Vertex(-a1 / 2, b / 2, c1 / 2),
                new Vertex(a1 / 2, b / 2, c1 / 2),
                new Vertex(a1 / 2, -b / 2, c1 / 2)
        };
        Vertex center = new Vertex(0, 0, 0);
        super.setVertices(vertices);
        super.setCenter(center);
    }

    @Override
    public void buildFaces() {
        faces = new Face[]{
                new Face(vertices[0], vertices[1], vertices[2], vertices[3]),
                new Face(vertices[4], vertices[5], vertices[6], vertices[7]),
                new Face(vertices[8], vertices[9], vertices[10], vertices[11]),
                new Face(vertices[12], vertices[13], vertices[14], vertices[15]),
                new Face(vertices[3], vertices[2], vertices[5], vertices[4]),
                new Face(vertices[7], vertices[6], vertices[1], vertices[0]),
                new Face(vertices[15], vertices[14], vertices[9], vertices[8]),
                new Face(vertices[11], vertices[10], vertices[13], vertices[12]),
                new Face(vertices[1], vertices[6], vertices[13], vertices[10]),
                new Face(vertices[6], vertices[5], vertices[14], vertices[13]),
                new Face(vertices[5], vertices[2], vertices[9], vertices[14]),
                new Face(vertices[2], vertices[1], vertices[10], vertices[9]),
                new Face(vertices[0], vertices[11], vertices[12], vertices[7]),
                new Face(vertices[7], vertices[12], vertices[15], vertices[4]),
                new Face(vertices[4], vertices[15], vertices[8], vertices[3]),
                new Face(vertices[3], vertices[8], vertices[11], vertices[0])
        };
        super.setFaces(faces);
    }

    @Override
    public void buildEdges() {
        faces[0].setEdges(new Edge[]{
                new Edge(vertices[0], vertices[1]),
                new Edge(vertices[1], vertices[2]),
                new Edge(vertices[2], vertices[3]),
                new Edge(vertices[3], vertices[0])
        });
        faces[1].setEdges(new Edge[]{
                new Edge(vertices[4], vertices[5]),
                new Edge(vertices[5], vertices[6]),
                new Edge(vertices[6], vertices[7]),
                new Edge(vertices[7], vertices[4])
        });
        faces[2].setEdges(new Edge[]{
                new Edge(vertices[8], vertices[9]),
                new Edge(vertices[9], vertices[10]),
                new Edge(vertices[10], vertices[11]),
                new Edge(vertices[11], vertices[8])
        });
        faces[3].setEdges(new Edge[]{
                new Edge(vertices[12], vertices[13]),
                new Edge(vertices[13], vertices[14]),
                new Edge(vertices[14], vertices[15]),
                new Edge(vertices[15], vertices[12])
        });
        faces[4].setEdges(new Edge[]{
                new Edge(vertices[3], vertices[2]),
                new Edge(vertices[2], vertices[5]),
                new Edge(vertices[5], vertices[4]),
                new Edge(vertices[4], vertices[3])
        });
        faces[5].setEdges(new Edge[]{
                new Edge(vertices[7], vertices[6]),
                new Edge(vertices[6], vertices[1]),
                new Edge(vertices[1], vertices[0]),
                new Edge(vertices[0], vertices[7])
        });
        faces[6].setEdges(new Edge[]{
                new Edge(vertices[15], vertices[14]),
                new Edge(vertices[14], vertices[9]),
                new Edge(vertices[9], vertices[8]),
                new Edge(vertices[8], vertices[15])
        });
        faces[7].setEdges(new Edge[]{
                new Edge(vertices[11], vertices[10]),
                new Edge(vertices[10], vertices[13]),
                new Edge(vertices[13], vertices[12]),
                new Edge(vertices[12], vertices[11])
        });
        faces[8].setEdges(new Edge[]{
                new Edge(vertices[1], vertices[6]),
                new Edge(vertices[13], vertices[10])
        });
        faces[9].setEdges(new Edge[]{
                new Edge(vertices[6], vertices[5]),
                new Edge(vertices[14], vertices[13])
        });
        faces[10].setEdges(new Edge[]{
                new Edge(vertices[5], vertices[2]),
                new Edge(vertices[9], vertices[14])
        });
        faces[11].setEdges(new Edge[]{
                new Edge(vertices[2], vertices[1]),
                new Edge(vertices[10], vertices[9])
        });
        faces[12].setEdges(new Edge[]{
                new Edge(vertices[0], vertices[7]),
                new Edge(vertices[12], vertices[11])
        });
        faces[13].setEdges(new Edge[]{
                new Edge(vertices[7], vertices[4]),
                new Edge(vertices[15], vertices[12])
        });
        faces[14].setEdges(new Edge[]{
                new Edge(vertices[4], vertices[3]),
                new Edge(vertices[8], vertices[15])
        });
        faces[15].setEdges(new Edge[]{
                new Edge(vertices[3], vertices[0]),
                new Edge(vertices[11], vertices[8])
        });
    }

    public void changeFigureSize(double a, double b, double c, double a1, double c1) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.a1 = a1;
        this.c1 = c1;
        buildVertices();
        buildFaces();
        buildEdges();
    }
}
