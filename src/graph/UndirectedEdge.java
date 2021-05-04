package graph;

public class UndirectedEdge extends Edge{

    public UndirectedEdge(int id, String color, double value, Vertex[] ends) {
        super(id,color,value,ends);
    }

    public Vertex[] getEnds() {
        return super.getEnds();
    }

    public String toString() {
        return super.toString();
    }
}