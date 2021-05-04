package graph;

public class DirectedEdge extends Edge{

    private int source;

    public DirectedEdge(int id, String color, double value, Vertex[] ends, int source) {
        super(id,color,value,ends);
        this.source = source;
    }

    public Vertex getSource() {
        return super.getEnds()[this.source];
    }

    public Vertex getSink() {
        return super.getEnds()[1-this.source];
    }

    public String toString() {
        return super.toString() + ", source=" + source;
    }
}