package Graph.NodeAndCreat;

import Graph.NodeAndCreat.VertexList;
import Graph.NodeAndCreat.adjNode;

import java.util.Scanner;

public class Base {
    public static void main(String[] args) {
        int[][] adjMat  = CreAdjMat();
        VertexList[] vertexLists = CreaAdjList();

    }

    private static VertexList[] CreaAdjList() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入顶点个数和边数：");
        int numVer = scanner.nextInt();
        int numEdge = scanner.nextInt();
        VertexList[] vertexLists = new VertexList[numVer+1];
        System.out.println("num ver" + numVer);
        // 初始化顶点表
        for (int i = 1; i < numVer+1; i++) {
            System.out.println("输入顶点：");
            char data = scanner.next().charAt(0);
            System.out.println("输入顶点权重：");
            int weight = scanner.nextInt();
            // 忘了初始化了，要先初始化才能赋值
            vertexLists[i] = new VertexList(data, weight);
        }
        // 输入边
        // 注意下标，这里我把长度都+1了
        for (int i = 0; i < numEdge; i++) {
            System.out.println("输入边的顶点序号：");
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            // 两个顶点都接入边，先从s开始
            adjNode node1 = new adjNode();
            node1.data = e;
            // 用头插法，原本的放在新的后面
            node1.next = vertexLists[s].firstNode;
            // 新的插在顶点后
            vertexLists[s].firstNode = node1;

            // 同样的方法再处理e
            adjNode node2 = new adjNode();
            node2.data = s;
            node2.next = vertexLists[e].firstNode;
            vertexLists[e].firstNode = node2;
        }

        return vertexLists;

    }

    private static int[][] CreAdjMat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入的顶点数和边数");
        int numVer = scanner.nextInt();
        int numEdge = scanner.nextInt();
        int[] vertexes = new int[numVer];
        int[][] edge = new int[numVer][numVer];
        for (int i = 0; i < numVer; i++) {
            for (int i1 = 0; i1 < numVer; i1++) {
                edge[i][i1] = 0;
            }
        }
        for (int i = 0; i < numEdge; i++) {
            System.out.println("输入边：");
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            edge[v1][v2] = 1;
        }
        return edge;
    }
}