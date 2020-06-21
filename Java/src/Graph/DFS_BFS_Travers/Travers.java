package Graph.DFS_BFS_Travers;

import Graph.NodeAndCreat.VertexList;
import Graph.NodeAndCreat.adjNode;
import Graph.NodeAndCreat.utils;

class Queue{
    private int top;
    private int[] list;

    public Queue(int max) {
        this.top = 0;
        this.list = new int[max];
    }

    public void push(int idx){
        list[top++] = idx;
    }

    public int pop(){
        top--;
        return list[top];
    }

    public int Empty(){
        if (top==0){
            return 1;
        }
        else {
            return 0;
        }
    }
}

public class Travers {
    public static void main(String[] args) {
        // 手动邻接矩阵
        // 手动邻接表
        VertexList[] vertexList = new VertexList[10];
        int[][] edgeList = new int[16][3];
        // 初始化
        int[][] edgeMat = new int[10][10];
        utils.InitVerAjd(vertexList, edgeList);
        // 创建邻接表
        utils.CreateAdjList(vertexList, edgeList);
        // 测试创建是否正确
        // System.out.println(vertexList[3].data);
        // System.out.println(vertexList[3].firstNode.data);
        // System.out.println(vertexList[3].firstNode.next.data);
        // System.out.println(vertexList[3].firstNode.next.next.data);

        // 创建邻接矩阵
        CreateAdjMat(edgeList, edgeMat);

        // 邻接矩阵的深度遍历
        System.out.println("邻接矩阵的深度遍历------------");
        TraverMatDFS(vertexList, edgeMat);

        // 邻接表的深度遍历
        System.out.println("邻接表的深度遍历------------");
        TraverListDFS(vertexList, edgeList);

        // 邻接矩阵的广度遍历
        System.out.println("邻接矩阵的广度遍历------------");
        TraverMatBFS(vertexList, edgeMat);

        // 邻接表的广度遍历
        System.out.println("邻接表的广度遍历------------");
        TraverListBFS(vertexList, edgeList);

    }

    private static void TraverListBFS(VertexList[] vertexList, int[][] edgeList) {
        int len = vertexList.length;
        int[] visit = new int[len];
        for (int i = 1; i < len; i++) {
            visit[i] = 0;
        }
        Queue que = new Queue(len - 1);
        for (int i = 1; i < len; i++) {
            if (visit[i] == 0) {
                que.push(i);
                visit[i] = 1;
                System.out.println(vertexList[i].data);
                while (que.Empty() == 1) {
                    int idx = que.pop();
                    adjNode q = vertexList[idx].firstNode;

                    // 顺着邻接表做广度
                    while (q != null) {
                        if (visit[q.data] == 0) {
                            // 邻接入栈
                            que.push(q.data);
                            visit[q.data] = 1;
                            System.out.println(vertexList[q.data].data);
                        }
                        q = q.next;
                    }

                }

            }
        }

    }

    private static void TraverMatBFS(VertexList[] vertexList, int[][] edgeMat) {
        int len = vertexList.length;
        int[] visit = new int[len];
        for (int i = 1; i < len; i++) {
            visit[i] = 0;
        }
        Queue que = new Queue(len - 1);
        for (int i = 1; i < len; i++) {
            if (visit[i] == 0) {
                que.push(i);
                visit[i] = 1;
                System.out.println(vertexList[i].data);
                // 栈里有就一直找
                while (que.Empty() == 0) {
                    int idx = que.pop();
                    // 并不是从这里标记是否看见，入栈的时候才能标记
                    // 从i的邻接点下手，没见过的都入栈

                    for (int i1 = 1; i1 < len; i1++) {
                        // 没见过且有邻接
                        if (visit[i1] == 0 && edgeMat[idx][i1] == 1) {
                            // 打印且入栈
                            System.out.println(vertexList[i1].data);
                            que.push(i1);
                            visit[i1] = 1;
                        }
                    }
                }
            }
        }
    }

    private static void TraverListDFS(VertexList[] vertexList, int[][] edgeList) {
        int len = vertexList.length;
        int[] visit = new int[len];
        for (int i = 1; i < len; i++) {
            visit[i] = 0;
        }
        for (int i = 1; i < len; i++) {
            if (visit[i] == 0) {
                DFSList(vertexList, visit, i);
            }
        }
    }

    private static void DFSList(VertexList[] vertexList, int[] visit, int idx) {
        visit[idx] = 1;
        System.out.println(vertexList[idx].data);
        // 往后找
        adjNode p = vertexList[idx].firstNode;
        while (p != null) {
            if (visit[p.data] == 0) {
                DFSList(vertexList, visit, p.data);
            }
            p = p.next;
        }

    }

    // 深度优先邻接矩阵用
    private static void DFSMat(VertexList[] vertexList, int[][] edgeMat, int[] visit, int idx) {
        int len = edgeMat.length;
        // 这两个在循环的外面，每次调用DFS会打印一个
        // 打印和控制都在循环外面进行
        visit[idx] = 1;
        System.out.println(vertexList[idx].data);

        for (int i = 1; i < len; i++) {
            if (edgeMat[idx][i] == 1 && visit[i] == 0) {
                DFSMat(vertexList, edgeMat, visit, i);
            }
        }
    }

    // 深度优先邻接矩阵遍历
    private static void TraverMatDFS(VertexList[] vertexList, int[][] edgeMat) {
        int len = vertexList.length;
        int[] visit = new int[len];
        for (int i = 0; i < len; i++) {
            visit[i] = 0;
        }
        for (int i = 1; i < len; i++) {
            if (visit[i] == 0) {
                DFSMat(vertexList, edgeMat, visit, i);
            }

        }
    }

    public static void CreateAdjMat(int[][] edgeList, int[][] edgeMat) {
        int len0 = edgeMat.length;
        for (int i = 0; i < len0; i++) {
            for (int i1 = 0; i1 < len0; i1++) {
                edgeMat[i][i1] = 0;
            }
        }
        int len = edgeList.length;
        for (int i = 0; i < len; i++) {
            int s = edgeList[i][0];
            int e = edgeList[i][1];
            edgeMat[s][e] = 1;
            edgeMat[e][s] = 1;
        }
    }
}
