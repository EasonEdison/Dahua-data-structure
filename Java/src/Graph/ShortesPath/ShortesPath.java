package Graph.ShortesPath;

import Graph.NodeAndCreat.VertexList;
import Graph.NodeAndCreat.utils;

public class ShortesPath {
    public static void main(String[] args) {
        VertexList[] vertexLists = new VertexList[10];
        int[][] edgeList = new int[17][3];
        int[][] edgeMat = new int[10][10];
        InitShortPathVerAjd(vertexLists, edgeList);
        utils.CreateAdjMat(edgeList, edgeMat);
        // Dijkstra算法
        // Dijkstra(edgeMat);
        Floyd(edgeMat);
    }

    private static void Floyd(int[][] edgeMat) {
        int len = edgeMat.length;
        // 距离数组和路径数组，因为这次是两层遍历方法，所以用二维数组
        int[][] Dis = edgeMat.clone();
        int[][] Path = new int[len][len];
        // 初始化Path为终点
        for (int v = 1; v < len; v++) {
            for (int w = 1; w < len; w++) {
                // v表示起点，w表示终点
                Path[v][w] = w;
            }
        }
        // k为中转点
        for (int k = 1; k < len; k++) {
            // 所有的顶点之间都做中转
            for (int v = 1; v < len; v++) {
                for (int w = 1; w < len; w++) {
                    // 如果中专的距离更近，就更新距离和路径为中赚
                    if (Dis[v][w] > Dis[v][k]+Dis[k][w]){
                        Dis[v][w] = Dis[v][k]+Dis[k][w];
                        // 相当于改变了起点的后驱，把中转点插到了原本的起点和顶点之间
                        Path[v][w] = Path[v][k];
                    }
                }

            }
        }
        FloydForeach(Path);
    }

    private static void FloydForeach(int[][] path) {
        int v = 1;
        int w = 8;
        int k = path[v][w];
        System.out.println(v + "到" + w + "的最短路径");
        System.out.printf((k-1)+" ");
        while (k!=w){
            // 起点随着中转带你一直在变，终点不变
            k = path[k][w];
            System.out.printf("-> " + (k-1) + " ");
        }
        System.out.println("-> " + k);
    }

    private static void Dijkstra(int[][] edgeMat) {
        int len = edgeMat.length;
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < len; j++) {
                System.out.printf(edgeMat[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("----------------");
        // 创建数组，假设下标从1开始
        int[] Final = new int[len];
        int[] Dis = new int[len];
        int[] Path = new int[len];
        // 初始化
        for (int i = 1; i < len; i++) {
            // 全部为未知
            Final[i] = 0;
            // 以第一个顶点为起点
            Dis[i] = edgeMat[1][i];
            // 路径都设为第一个顶点
            Path[i] = 1;
        }
        Final[1] = 1;
        Dis[1] = 0;
        // 大遍历
        for (int i = 1; i < len; i++) {
            // 找离v0最近的没被考虑过的点
            int min = 65535;
            // 用来记录最近
            int k = 0;
            for (int w = 1; w < len; w++) {
                if (Final[w]==0 && Dis[w] < min){
                    k = w;
                    min = Dis[w];
                }
            }
            // 设k顶点为已被考虑过
            Final[k] = 1;
            // 看是否能通过k更近
            for (int w = 1; w < len; w++) {
                if (Final[w]==0 && (min+edgeMat[k][w] < Dis[w])){
                    // 更近就更新距离和路径
                    System.out.println("更新前到顶点"+w +"的距离： " + Dis[w]);

                    Dis[w] = min + edgeMat[k][w];
                    System.out.println("更新后到顶点"+w +"的距离： " + Dis[w]);
                    // 更新前驱点，通过k连接w会更近
                    Path[w] = k;
                }
            }
        }
        for (int i = 1; i < len; i++) {
            System.out.println(i-1+"的前驱是"+(Path[i]-1));
        }
    }

    private static void InitShortPathVerAjd(VertexList[] vertexList, int[][] edgeList) {
        vertexList[1] = new VertexList('A',0);
        vertexList[2] = new VertexList('B',0);
        vertexList[3] = new VertexList('C',0);
        vertexList[4] = new VertexList('D',0);
        vertexList[5] = new VertexList('E',0);
        vertexList[6] = new VertexList('F',0);
        vertexList[7] = new VertexList('G',0);
        vertexList[8] = new VertexList('H',0);
        vertexList[9] = new VertexList('I',0);
        // 1
        edgeList[1][0] = 1;
        edgeList[1][1] = 0;
        edgeList[1][2] = 1;
        // 2
        edgeList[2][0] = 0;
        edgeList[2][1] = 2;
        edgeList[2][2] = 5;
        // 3
        edgeList[3][0] = 1;
        edgeList[3][1] = 2;
        edgeList[3][2] = 3;
        // 4
        edgeList[4][0] = 1;
        edgeList[4][1] = 3;
        edgeList[4][2] = 7;
        // 5
        edgeList[5][0] = 1;
        edgeList[5][1] = 4;
        edgeList[5][2] = 5;
        // 6
        edgeList[6][0] = 2;
        edgeList[6][1] = 4;
        edgeList[6][2] = 1;
        // 7
        edgeList[7][0] = 2;
        edgeList[7][1] = 5;
        edgeList[7][2] = 7;
        // 8
        edgeList[8][0] = 3;
        edgeList[8][1] = 4;
        edgeList[8][2] = 2;
        // 9
        edgeList[9][0] = 4;
        edgeList[9][1] = 5;
        edgeList[9][2] = 3;
        // 10
        edgeList[10][0] = 3;
        edgeList[10][1] = 6;
        edgeList[10][2] = 3;
        // 11
        edgeList[11][0] = 4;
        edgeList[11][1] = 6;
        edgeList[11][2] = 6;
        // 12
        edgeList[12][0] = 4;
        edgeList[12][1] = 7;
        edgeList[12][2] = 9;
        // 13
        edgeList[13][0] = 7;
        edgeList[13][1] = 5;
        edgeList[13][2] = 5;
        // 14
        edgeList[14][0] = 6;
        edgeList[14][1] = 7;
        edgeList[14][2] = 2;
        // 15
        edgeList[15][0] = 6;
        edgeList[15][1] = 8;
        edgeList[15][2] = 7;
        // 16
        edgeList[16][0] = 7;
        edgeList[16][1] = 8;
        edgeList[16][2] = 4;

        // 搞错了，应从1开始
        for (int i = 0; i < 16; i++) {
            edgeList[i+1][0] += 1;
            edgeList[i+1][1] += 1;
        }
    }
}


