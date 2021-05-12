            package graph;

import graph.*;

public class IncidenceArrayGraph implements Graph{

    private Vertex[] vertices;
    private Edge[] edges;
    private Edge[][] connectedEdges;

    public IncidenceArrayGraph(Vertex[] vertices, Edge[] edges, int maxOfVertices){
        int sizeOfVerticesTab = maxOfVertices;
        try{
          if(maxOfVertices < 1){
            throw new IllegalArgumentException();
          }
        }
        catch (IllegalArgumentException e){
          sizeOfVerticesTab = 5; // default value
        }
        this.vertices = new Vertex[sizeOfVerticesTab];
        this.edges = new Edge[sizeOfVerticesTab*(sizeOfVerticesTab-1)];
        this.connectedEdges = new Edge[sizeOfVerticesTab][sizeOfVerticesTab*(sizeOfVerticesTab-1)];
        System.arraycopy(vertices, 0, this.vertices, 0, vertices.length);
        System.arraycopy(edges, 0, this.edges, 0, edges.length);
    }

    public int nbOfVertices() {
        int nbVertices = 0;
        Vertex vertex = this.vertices[0];
        while(vertex != null){
            nbVertices++;
            vertex = this.vertices[nbVertices];
        }
        return nbVertices;
    }

    public int nbOfEdges() {
        int nbOfEdges = 0;
        Edge edge = this.edges[0];
        while(edge != null){
            nbOfEdges++;
            edge = this.edges[nbOfEdges];
        }
        return nbOfEdges;
    }

    public void addVertex(Vertex v){
        try{
          if(this.nbOfVertices() >= this.vertices.length){
            throw new GraphOverflowException("Graph is full");
          }
          this.vertices[this.nbOfVertices()+1] = v;
        }
        catch (GraphOverflowException e){
          System.out.println("Can't add vertex. Graph is full");
        }
    }

    public void addEdge(Vertex v1, Vertex v2, EdgeKind edgeKind){

        try{
          if((this.nbOfEdges()+this.nbOfEdges()) >= this.vertices.length*2){
            throw new GraphOverflowException("Graph is full");
          }
          Edge edge;
          if(edgeKind == EdgeKind.undirected){
              edge = new DirectedEdge(this.nbOfEdges() + 1, "blue", 1.0, new Vertex[]{v1, v2},0);
          } else {
              edge = new UndirectedEdge(this.nbOfEdges() + 1, "blue", 1.0, new Vertex[]{v1, v2});
          }
          this.edges[this.nbOfEdges()+1] = edge;

          int numVertex1 = this.getPositionOfVertices(v1);
          int numVertex2 = this.getPositionOfVertices(v2);
          this.connectedEdges[numVertex1][numVertex2] = edge;
          this.connectedEdges[numVertex2][numVertex1] = edge;
        }
        catch (IllegalArgumentException e){
          System.out.println("Invalid edge type");
        }
        catch (GraphOverflowException e){
          System.out.println("Can't add edge. Graph is full");
        }   
        
    }

    private int getPositionOfVertices(Vertex v){
        int nbOfVertices = 0;
        Vertex returnedVertex = this.vertices[0];
        while(nbOfVertices < this.vertices.length && returnedVertex.getId() != v.getId()){
            nbOfVertices++;
            returnedVertex = this.vertices[nbOfVertices];
        }
        if (returnedVertex.getId() != v.getId()){
            nbOfVertices = -1;
        }
        return nbOfVertices;
    }

    public boolean isConnected(Vertex v1, Vertex v2){
        if (v1.getId()==v2.getId()){
            return true;
        }

        int etat[] = new int[this.vertices.length];
        for (int i = 0; i < this.vertices.length; i++){
            etat[i]=0;
        }

        int current = getPositionOfVertices(v1);
        etat[getPositionOfVertices(v1)]=1;

        while (current != -1){
            if(etat[getPositionOfVertices(v2)]==1){
                return true;
            }

            for (int i = 0; i < this.vertices.length; i++){
                if(this.connectedEdges[current][i]!=null && etat[i]==0){
                    etat[i]=1;
                }
            }

            etat[current]=2;

            for (int i = 0; i < this.vertices.length; i++){
                if(etat[i]==1){
                    current = i;
                    break;
                }
                else{
                    current = -1;
                }
            }
        }
        return false;
    }

    public boolean isConnected(){
        boolean isConnected = true;
        Vertex v1 = this.vertices[0];
        int i = 1;
        while(isConnected && i < this.nbOfVertices()){
            isConnected = this.isConnected(v1, this.vertices[i]);
            i++;
        }
        return isConnected;
    }

    public Edge[] getEdges(){
        return this.edges;
    }

    public Edge[] getEdges(Vertex v1, Vertex v2){
        int nbEdges = 0;
        Edge[] edges = new Edge[this.connectedEdges[this.getPositionOfVertices(v1)].length];
        for(Edge e : connectedEdges[this.getPositionOfVertices(v1)]){
            Vertex connectedVertex = this.otherEdge(v1, e);
            if (connectedVertex.getId() == v2.getId()){
                edges[nbEdges] = e;
                nbEdges++;
            }
        }
        return edges;
    }

    private Vertex otherEdge(Vertex v1, Edge e){
        Vertex connectedVertex;
        if (v1.getId() == e.getEnds()[0].getId()){
            connectedVertex = e.getEnds()[1];
        } else {
            connectedVertex = e.getEnds()[0];
        }
        return connectedVertex;
    }

    public Vertex[] getVertices(){
        return this.vertices;
    }

    public Edge[] getNeighborEdges(Vertex v1){
        return connectedEdges[this.getPositionOfVertices(v1)];
    }
}