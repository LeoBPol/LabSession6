package graph;

public class TestGraph {

    public static void main(String[] args){
        Vertex v1 = new Vertex(-1, "Test", "blue");
        Vertex v2 = new Vertex(12, "Test", "blue");
        Edge e = new UndirectedEdge(-1, "blue", 2.5, new Vertex[]{v1, v2});

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(e);
    }
}
