package Search.AVL;

public class BitNode {
    public int BF;
    public BitNode lchild, rchild;
    private int data;
    public boolean exist=false;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        exist = true;
        this.data = data;
    }



    public BitNode() {
        lchild = rchild = null;
    }

    public BitNode(int data) {
        exist = true;
        this.data = data;
        lchild = rchild = null;
    }

    public void equal(BitNode bitNode){
        if (bitNode!=null)
        {
            exist = bitNode.exist;
            data = bitNode.data;
            BF = bitNode.BF;
            lchild = bitNode.lchild;
            rchild = bitNode.rchild;
        } else {
            exist = false;
        }
    }
}
