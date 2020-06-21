package Graph.KeyPath;


public class KeyPath {
    public static void main(String[] args) {
        aovNode[] verList = new aovNode[10];
        int[][] edgeList = new int[13][3];
        InitKeyPath(verList, edgeList);
        CreateAdjList(verList, edgeList);
        // 栈存放排序，这里要用到从后往前的方法，所以用栈来存储
        int[] stack = new int[10];
        // 记录各个活动最早开始时间的数组
        int[] evt = new int[10];
        // 用新的拓扑排序来初始化上面两个数组
        // top为stack数组的top
        int top = TopologySave(verList, stack, evt);
        keyPath(stack, top, evt, verList);
    }

    private static void keyPath(int[] stack, int top, int[] evt, aovNode[] verList) {
        int len = verList.length;
        // 先求一波最晚时间
        int[] ltv = new int[len];
        // 初始化为最大时间
        for (int i = 0; i < len; i++) {
            ltv[i] = evt[len-1];
        }
        // 从后往前
        while (top != 0){
            int gettop = stack[--top];
            // 对邻接点下手
            for (adjWNode e=verList[gettop].firstedge; e!=null; e=e.next){
                // 更新时间，越晚越好
                // 邻接点 - 路径时间 最小，为了保证所有任务都能完成
                if (ltv[e.data] - e.weight < ltv[gettop]){
                    ltv[gettop] = ltv[e.data] - e.weight;
                }
            }
        }
        // 最早和最晚都有了，遍历比较就行了
        // 这样可得到关键点
        for (int i = 0; i < len; i++) {
            if (evt[i] == ltv[i]){
                System.out.println(i);
            }
        }
        System.out.println("---------");

        // 这样可得到路径
        for (int i = 0; i < len; i++) {
            for (adjWNode e=verList[i].firstedge; e!=null; e=e.next){
                if (evt[i] == ltv[e.data]-e.weight){
                    System.out.println(i + "->" + e.data);
                }
            }
        }

    }

    private static int TopologySave(aovNode[] verList, int[] stack2, int[] evt) {
        int len = verList.length;
        int[] stack = new int[len];
        int count = 0;
        int top = 0;
        int top2 = 0;
        for (int i = 0; i < len; i++) {
            if (verList[i].in == 0){
                stack[top++] = i;
            }
        }
        // 初始化evt
        for (int i = 0; i < len; i++) {
            evt[i] = 0;
        }
        while(top!=0){
            int gettop = stack[--top];
            count++;
            // 存起来
            stack2[top2++] = gettop;
            for (adjWNode e=verList[gettop].firstedge; e!=null; e=e.next){
                if((--verList[e.data].in)==0){
                    stack[top++] = e.data;
                }
                // 这里还得记下最早时间
                // e.weight就是从gettop到e.data需要的时间
                if (evt[gettop] + e.weight > evt[e.data]){
                    evt[e.data] = evt[gettop] + e.weight;
                }
            }
        }
        if (count == len){
            System.out.println("无环");
        } else {
            System.out.println("有环");
        }
        return top2;
    }

    private static void CreateAdjList(aovNode[] verList, int[][] edgeList) {
        for (int i=0; i< edgeList.length; i++){
            int s = edgeList[i][0];
            int e = edgeList[i][1];
            adjWNode node = new adjWNode(e, edgeList[i][2]);
            node.next = verList[s].firstedge;
            verList[s].firstedge = node;
        }
    }

    private static void InitKeyPath(aovNode[] verList, int[][] edgeList) {
        verList[0] = new aovNode(0,0);
        verList[1] = new aovNode(1,1);
        verList[2] = new aovNode(1,2);
        verList[3] = new aovNode(2,3);
        verList[4] = new aovNode(2,4);
        verList[5] = new aovNode(1,5);
        verList[6] = new aovNode(1,6);
        verList[7] = new aovNode(2,7);
        verList[8] = new aovNode(1,8);
        verList[9] = new aovNode(2,9);

        edgeList[0][0] = 0;
        edgeList[0][1] = 1;
        edgeList[0][2] = 3;
        edgeList[1][0] = 0;
        edgeList[1][1] = 2;
        edgeList[1][2] = 4;
        edgeList[2][0] = 1;
        edgeList[2][1] = 3;
        edgeList[2][2] = 5;
        edgeList[3][0] = 1;
        edgeList[3][1] = 4;
        edgeList[3][2] = 6;
        edgeList[4][0] = 2;
        edgeList[4][1] = 3;
        edgeList[4][2] = 8;
        edgeList[5][0] = 2;
        edgeList[5][1] = 5;
        edgeList[5][2] = 7;
        edgeList[6][0] = 3;
        edgeList[6][1] = 4;
        edgeList[6][2] = 3;
        edgeList[7][0] = 4;
        edgeList[7][1] = 6;
        edgeList[7][2] = 9;
        edgeList[8][0] = 4;
        edgeList[8][1] = 7;
        edgeList[8][2] = 4;
        edgeList[9][0] = 5;
        edgeList[9][1] = 7;
        edgeList[9][2] = 6;
        edgeList[10][0] = 6;
        edgeList[10][1] = 9;
        edgeList[10][2] = 2;
        edgeList[11][0] = 7;
        edgeList[11][1] = 8;
        edgeList[11][2] = 5;
        edgeList[12][0] = 8;
        edgeList[12][1] = 9;
        edgeList[12][2] = 3;
    }
}
