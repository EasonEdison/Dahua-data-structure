package Graph.KeyPath;

public class adjWNode {
    int data;
    int weight;
    adjWNode next;

    public adjWNode(int data, int weight) {
        this.data = data;
        this.weight = weight;
    }
}

class aovNode{
    public int in;
    public int data;
    public adjWNode firstedge;


    public aovNode(int in, int data) {
        this.in = in;
        this.data = data;
    }
}
