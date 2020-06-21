package Graph.TopologySort;

import Graph.NodeAndCreat.adjNode;

public class TopologySort {
    public static void main(String[] args) {
        // 14个顶点
        int len = 6;
        aovNode[] verList = new aovNode[len+1];
        // 这里是有向边, 七条边
        int[][] edgeList = new int[8][2];
        InitTopoplogy(verList, edgeList);
        CrateAdjList(verList, edgeList);
        Sort(verList, edgeList);
    }

    private static void Sort(aovNode[] verList, int[][] edgeList) {
        int len = verList.length;
        // 做一个栈存放入度为0的点
        int[] stack = new int[len];
        int top = 0;
        int count = 0;
        int ver = 0;
        adjNode e = null;
        for (int i = 1; i < len; i++) {
            if (verList[i].in == 0){
                stack[top++] = i;
            }
        }
        // 开始遍历，对点进行处理
        while (top != 0){
            // 在这里打印
            ver = stack[--top];
            System.out.println(ver + "->");
            count++;
            // 对该点的邻接点进行处理
            for (e = verList[ver].firstedge; e!=null; e=e.next){
                // 如果邻接点的入度-1为0的话，就入栈
                if ((--verList[e.data].in) == 0){
                    stack[top++] = e.data;
                }
            }
        }
        // 如果能输出所有点，说明无环
        if (count == len-1){
            System.out.println("无环");
        } else {
            System.out.println("有环");
        }
    }

    private static void CrateAdjList(aovNode[] verList, int[][] edgeList) {
        int len = edgeList.length;
        for (int i = 1; i < len; i++) {
            int s = edgeList[i][0];
            int t = edgeList[i][1];
            adjNode adj = new adjNode();
            adj.data = t;
            adj.next = verList[s].firstedge;
            verList[s].firstedge = adj;
        }
    }

    private static void InitTopoplogy(aovNode[] verList, int[][] edgeList) {
        // 初始化顶点的值和入度
        verList[1] = new aovNode(0,1);
        verList[2] = new aovNode(1,2);
        verList[3] = new aovNode(2,3);
        verList[4] = new aovNode(2,4);
        verList[5] = new aovNode(2,5);
        verList[6] = new aovNode(0,6);
        // 初始化边
        edgeList[1][0] = 1;
        edgeList[1][1] = 2;
        edgeList[2][0] = 1;
        edgeList[2][1] = 3;
        edgeList[3][0] = 2;
        edgeList[3][1] = 5;
        edgeList[4][0] = 3;
        edgeList[4][1] = 4;
        edgeList[5][0] = 5;
        edgeList[5][1] = 3;
        edgeList[6][0] = 5;
        edgeList[6][1] = 4;
        edgeList[7][0] = 6;
        edgeList[7][1] = 5;
    }
}
