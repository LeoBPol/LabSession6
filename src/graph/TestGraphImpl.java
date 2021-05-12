package graph;

import graph.Edge;
import graph.EdgeKind;
import graph.Graph;
import graph.Vertex;

public class TestGraphImpl {
    public static void main(String[] args){
        /* VERTICES CREATION */
        Vertex v1 = new Vertex(1, "1", "Blue");
        Vertex v2 = new Vertex(2, "2", "Red");
        Vertex v3 = new Vertex(3, "3", "Yellow");
        Vertex v4 = new Vertex(4, "3", "Yellow");

        /* GRAPH CREATION */
        Graph graph = new IncidenceArrayGraph(new Vertex[]{v1, v2, v3, v4}, new Edge[0],10);

        graph.addEdge(v1, v2, EdgeKind.directed);
        graph.addEdge(v1, v2, EdgeKind.directed);
        graph.addEdge(v2, v1, EdgeKind.directed);
        graph.addEdge(v2, v3, EdgeKind.directed);
        graph.addEdge(v3, v1, EdgeKind.directed);
        graph.addEdge(v3, v2, EdgeKind.directed);

        System.out.println("V1 is connected with V3 : " + graph.isConnected(v1, v3));
    }
}