package Search.AVL;

public class AVLutils {
    public static void L_Rotate(BitNode T) {
        // T的分身
        BitNode L = new BitNode();
        L.equal(T);
        // T的右孩子上位新跟结点
        T.equal(T.rchild);
        L.rchild = T.lchild;
        T.lchild = L;
    }

    public static void R_Rotate(BitNode T) {
        // T的分身
        BitNode L = new BitNode();
        L.equal(T);
        // T的右孩子上位新跟结点
        T.equal(T.lchild);
        L.lchild = T.rchild;
        T.rchild = L;
    }

    public static void LeftBalance(BitNode T){
        // 做平衡，T.bf=1，是在变化之前传进函数的
        BitNode L = T.lchild;
        // 检查同号或异号
        switch (L.BF){
            // 同号的情况
            case 1:
                // 右转T
                R_Rotate(T);
                T.BF = L.BF = 0;
                break;
            // 异号的情况，这里要考虑Lr的符号
            case -1:
                BitNode Lr = L.rchild;
                switch (Lr.BF){
                    // 插在了Lr的右边,此时新结点跟T走
                    case -1:
                        T.BF = 0;
                        L.BF = 1;
                        break;
                    // 插在了Lr的左边，此时新结点跟L走
                    case 1:
                        T.BF = -1;
                        L.BF = 0;
                        break;
                    case 0:
                        T.BF = L.BF = 0;
                        break;
                }
                // 根据规律可得以下固定内容
                Lr.BF = 0;
                L_Rotate(L);
                R_Rotate(T);
        }
    }

    public static void RightBalance(BitNode T){
        BitNode R = T.rchild;
        switch (R.BF){
            // 此时同号为负
            case -1:
                L_Rotate(T);
                T.BF = R.BF = 0;
            case 1:
                BitNode Rl = R.lchild;
                switch (Rl.BF){
                    case 0:
                        T.BF = R.BF = 0;
                    // 插在了左边，跟着T
                    case 1:
                        T.BF = 0;
                        R.BF = -1;
                    case -1:
                        T.BF = 1;
                        R.BF = 0;
                }
                Rl.BF = 0;
                R_Rotate(R);
                L_Rotate(T);
        }
    }

    // 通过比较来找位置
    public static boolean InsertAVL(BitNode T, BitNode f, int e, Status sta){



        // 不能存在说明找到要插入的位置了,假设只要插入了就变高
        // 其实就是个检查机制，有插入就检查
        if (T==null){

            // 父结点不为空
            if (e > f.getData()){
                f.rchild = new BitNode(e);
            } else {
                f.lchild = new BitNode(e);
            }
            System.out.println("插入结点：" + e);
            sta.taller = true;
            return true;
        } else {
            // f表示父结点，f和T都为空说明是根结点
            if (f==null && T.exist==false){
                T.setData(e);
                System.out.println("插入结点：" + e);
                return true;
            }

            if (e == T.getData()){
                System.out.println("重复了：" + e);
                sta.taller = false;
                return false;
            } else if (e > T.getData()){
                // 往右子树找
                // 如果插入失败，则跳过
                if (!InsertAVL(T.rchild, T, e, sta)){
                    return false;
                }
                // 插入成功后，检查高度
                if (sta.taller){
                    // 现在是插到了右边
                    switch (T.BF){
                        case 0:
                            // 插入打破了平衡，说明最高高度变了
                            T.BF = -1;
                            sta.taller = true;
                            break;
                        case 1:
                            // 左右变平衡，说明是在短的一边加的，所以最高高度不变
                            T.BF = 0;
                            sta.taller = false;
                            break;
                        case -1:
                            RightBalance(T);
                            sta.taller = false;
                            break;
                    }
                }
            } else {
                // 往左子树找
                if (!InsertAVL(T.lchild, T, e, sta)){
                    return false;
                }
                if (sta.taller){
                    switch (T.BF){
                        case 0:
                            // 插入打破了平衡，说明最高高度变了
                            sta.taller = true;
                            T.BF = 1;
                            break;
                        case -1:
                            // 左右变平衡，说明是在短的一边加的，所以最高高度不变
                            sta.taller = false;
                            T.BF = 0;
                            break;
                        case 1:
                            LeftBalance(T);
                            sta.taller = false;
                            break;
                    }
                }
            }
        }
        // 能走到这里就说明插入成功了，否则在前面就返回false了
        return true;
    }

    public static void TraverseTree(BitNode T){
        if (T!= null){
            TraverseTree(T.lchild);
            System.out.println(T.getData());
            TraverseTree(T.rchild);
        }
    }
}
