package Graph.MinTree;

import Graph.NodeAndCreat.VertexList;
import Graph.NodeAndCreat.utils;

import java.util.Arrays;

public class MinTree {

    public static void main(String[] args) {
        VertexList[] vertexLists = new VertexList[10];
        int[][] edgelist = new int[16][3];
        int[][] edgeMat = new int[10][10];
        utils.InitVerAjd(vertexLists, edgelist);
        utils.CreateAdjMat(edgelist, edgeMat);
        // Prim需要用到邻接权值矩阵
        Prim(vertexLists, edgeMat);
        Kruskal(vertexLists, edgelist, edgeMat);

    }

    private static void Kruskal(VertexList[] vertexLists, int[][] edgelist, int[][] edgemat) {
        // 后在前，逆序
        // 将edgelist按升序重新排序
        Arrays.sort(edgelist, (int[] a, int[] b)->{
            return a[2] - b[2];
        });
    }

    private static void Prim(VertexList[] vertexLists, int[][] edgeMat) {
        int len = vertexLists.length;
        int[] adjvex = new int[len];
        int[] lowcost = new int[len];
        for (int i = 1; i < len; i++) {
            // 赋值第一个点的邻接边的权重
            // 这里搞错了
            lowcost[i] = edgeMat[1][i];
            // 初始化为1， 就是生活树中只有第一个顶点
            adjvex[i] = 1;
        }
        // 设为0表示已经进树了
        lowcost[1] = 0;
        // 每次选出一个顶点
        for (int i = 1; i < len-1; i++) {
            int min = Integer.MAX_VALUE;
            int k = 0;
            // 不会算第一个点本身
            for (int j = 2; j < len; j++) {
                if (lowcost[j]!=0 && lowcost[j]<min){
                    min = lowcost[j];
                    k = j;
                }
            }
            // 该点被选出
            lowcost[k] = 0;
            System.out.println("第" + i + "条边：" + adjvex[k] + "->" + k);
            // 更新lowcost和adjvex
            for (int m = 2; m < len; m++) {
                // 看有无更近
                if (lowcost[m]!=0 && lowcost[m]>edgeMat[k][m]){
                    // 更近就更新
                    lowcost[m] = edgeMat[k][m];
                    // 得记录和那个更近
                    adjvex[m] = k;
                }
            }
        }
    }
}
