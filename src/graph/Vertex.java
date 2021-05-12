package graph;

public class Vertex{
    private int id;
    private Object info;
    private String color;

    public Vertex(int id, Object info, String color) {
        if (id < 0)
          throw new IllegalArgumentException("id of vertex must be non-negative");
        this.id = id;
        this.info = info;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0)
          throw new IllegalArgumentException("id of vertex must be non-negative");
        this.id = id;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "graph.Vertex{" +
                "id=" + id +
                ", info=" + info +
                ", color='" + color + '\'' +
                '}';
    }

}