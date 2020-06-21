package Search.AVL;

public class main {
    public static void main(String[] args) {
        int[] a = {62, 58, 88, 47, 73, 99, 35, 52, 93, 37};
        BitNode T = new BitNode();
        Status sta = new Status(false);
        for (int i = 0; i < a.length; i++) {
            AVLutils.InsertAVL(T, null, a[i], sta);
        }
        System.out.println("中序遍历-------------");
        AVLutils.TraverseTree(T);
    }
}
