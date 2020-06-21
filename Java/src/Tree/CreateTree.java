package Tree;

import java.util.Scanner;

public class CreateTree {
    public static void main(String[] args) {
        BitNode bitNode = new BitNode();
        create(bitNode);
        show(bitNode);
    }

    private static void create(BitNode bitNode){
        System.out.println("输入：");
        char ch = new Scanner(System.in).next().charAt(0);
        if (ch=='#')
            bitNode.data = null;
        else
        {
            bitNode.data = ch;
            bitNode.lchild = new BitNode();
            bitNode.rchild = new BitNode();
            // 前序遍历法，会顺着左孩子一直向下，当到头的时候，会处理右孩子
            // 处理完了之后在往上一层，处理上一层的右孩子
            create(bitNode.lchild);
            create(bitNode.rchild);
        }
    }



    private static void show(BitNode bitNode){
        if(bitNode.data != null){
            // 前序遍历
            System.out.println(bitNode.data);
            show(bitNode.lchild);
            show(bitNode.rchild);
        }

    }
}

class BitNode
{
    public Object data;
    public BitNode lchild, rchild;

    public BitNode() {
    }
}