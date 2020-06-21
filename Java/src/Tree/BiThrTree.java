package Tree;

import java.util.Scanner;

class BitThrNode
{
    public Object data;
    public BitThrNode lchild, rchild;
    public int ltag, rtag;

    public BitThrNode() {
        data = null;
        ltag = 0;
        rtag = 0;
        lchild = null;
        rchild = null;
    }

    public BitThrNode(Boolean b) {
        data = null;
        ltag = 0;
        rtag = 0;
        lchild = new BitThrNode();
        rchild = new BitThrNode();
    }
}

public class BiThrTree {
    private static int pos;
    // 注意初始化个对象，不然在判断pre.lchild的时候会报空指针异常
    private static BitThrNode pre = new BitThrNode(Boolean.TRUE);


    public static void main(String[] args) {
        String string = "AB#D##C##";
        BitThrNode bitThrNode = new BitThrNode();
        pos = 0;
        create(bitThrNode,string);
        // 创造头结点
        BitThrNode head = new BitThrNode();
        // 头结点的常见需要在线索化的前面
        getHeadNode(bitThrNode, head);
        System.out.println("-----------线索二叉树----------");
        InThread(bitThrNode);

        head.ltag = 0;
        head.lchild = bitThrNode;
        head.rchild.rtag = 1;
        head.rchild.rchild = head;
        // 线索二叉树的遍历
        System.out.println("-----------线索二叉树遍历----------");
        InOrderTra(head);
    }

    private static void getHeadNode(BitThrNode thrNode, BitThrNode head) {
        if (thrNode.data != null){
            getHeadNode(thrNode.lchild, head);
            head.rchild = thrNode;
            getHeadNode(thrNode.rchild, head);
        }
    }

    private static void InOrderTra(BitThrNode head) {
        // 根结点
        BitThrNode p = head.lchild;
        // 为头结点，说明到头了
        while (p != head){
            // 一直向下找左孩子到底, 左孩子不可能是中序的最后一个点，所以这里不用判断
            // 又跑过头了,因此加了null判断
            while (p.ltag == 0 && p.data!=null) {
                // 测试用
                // System.out.println(p.data);
                // System.out.println(p.ltag);
                p = p.lchild;
            }
            // 打印了这个点
            System.out.println("data: " + p.data + " ltag: " + p.ltag
            + " rtag: " + p.rtag);
            // 然后看此时有没有右孩子，有就进入右孩子，没有就通过后继指针跳跃
            // 在这里卡死了，最后一个的右孩子和head的右孩子在无限循环
            // 没加大括号坏事了，跟python搞混了
            while (p.rtag == 1 && p.rchild!=head) {
                p = p.rchild;
                System.out.println("data: " + p.data + " ltag: " + p.ltag
                        + " rtag: " + p.rtag);
            }

            // 现在有右孩子了，可以继续正常遍历
            // if (p!=head) {
            p = p.rchild;
                // System.out.println("结尾是：" + p.data);

        }

    }

    private static void create(BitThrNode bitThrNode, String str){
        char ch = str.charAt(pos++);
        if (ch=='#')
            bitThrNode.data = null;
        else
        {   // 这边的创建是有问题的，即使不存在左右孩子，b.lchild和b.rchild也不会为null
            // 需要通过判断b.data来直到是不是没有结点
            bitThrNode.data = ch;
            bitThrNode.lchild = new BitThrNode();
            bitThrNode.rchild = new BitThrNode();
            // 前序遍历法，会顺着左孩子一直向下，当到头的时候，会处理右孩子
            // 处理完了之后在往上一层，处理上一层的右孩子
            create(bitThrNode.lchild, str);
            create(bitThrNode.rchild, str);
        }
    }



    private static void show(BitThrNode bitThrNode){
        if(bitThrNode.data != null){
            // 前序遍历
            System.out.println(bitThrNode.data);
            show(bitThrNode.lchild);
            show(bitThrNode.rchild);
        }

    }

    private static void InThread(BitThrNode bitThrNode){
        // 根据data来判断是否为空，而不是根据bitThrNode本身
        if (bitThrNode.data != null){
            // 中序遍历的方法来线索化

            InThread(bitThrNode.lchild);
            // 当前结点负责前驱的建立
            // 当该结点为第一个结点时，前驱为null
            if (bitThrNode.lchild.data == null){
                bitThrNode.ltag = 1;
                bitThrNode.lchild = pre;
            }
            // 前一个结点建立后驱
            if (pre.rchild.data == null){
                pre.rtag = 1;
                pre.rchild = bitThrNode;
            }
            // 这块是没错的
            // System.out.println("data " + bitThrNode.data + " ltag " + bitThrNode.ltag
            // + " rtag " + bitThrNode.rtag);
            // System.out.println("pre data " + pre.data + " ltag " + pre.ltag
            //         + " rtag " + pre.rtag);
            pre = bitThrNode;
            InThread(bitThrNode.rchild);

        }
    }
}

