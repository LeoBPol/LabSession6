public abstract class Edge{
    private int id;
    private String color;
    private double value;
    private Vertex[] ends;

    public Edge(int id, String color, double value, Vertex[] ends) {
        this.id = id;
        this.color = color;
        this.value = value;
        this.ends = ends;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Vertex[] getEnds() {
        return ends;
    }

    public void setEnds(Vertex[] ends) {
        this.ends = ends;
    }
}