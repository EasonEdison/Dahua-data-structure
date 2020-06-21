package Graph.NodeAndCreat;

public class VertexList {
    public char data;
    public adjNode firstNode;
    public int weight;

    public VertexList(char data, int weight) {
        this.data = data;
        this.weight = weight;
        firstNode = null;
    }
}
