package Graph.NodeAndCreat;

public class utils {
    public static void InitVerAjd(VertexList[] vertexList, int[][] edgeList) {
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
        edgeList[1][1] = 2;
        edgeList[1][2] = 10;
        // 2
        edgeList[2][0] = 2;
        edgeList[2][1] = 3;
        edgeList[2][2] = 18;
        // 3
        edgeList[3][0] = 3;
        edgeList[3][1] = 4;
        edgeList[3][2] = 22;
        // 4
        edgeList[4][0] = 4;
        edgeList[4][1] = 5;
        edgeList[4][2] = 20;
        // 5
        edgeList[5][0] = 5;
        edgeList[5][1] = 6;
        edgeList[5][2] = 26;
        // 6
        edgeList[6][0] = 6;
        edgeList[6][1] = 1;
        edgeList[6][2] = 11;
        // 7
        edgeList[7][0] = 2;
        edgeList[7][1] = 7;
        edgeList[7][2] = 16;
        // 8
        edgeList[8][0] = 7;
        edgeList[8][1] = 6;
        edgeList[8][2] = 17;
        // 9
        edgeList[9][0] = 2;
        edgeList[9][1] = 9;
        edgeList[9][2] = 12;
        // 10
        edgeList[10][0] = 3;
        edgeList[10][1] = 9;
        edgeList[10][2] = 8;
        // 11
        edgeList[11][0] = 9;
        edgeList[11][1] = 4;
        edgeList[11][2] = 21;
        // 12
        edgeList[12][0] = 4;
        edgeList[12][1] = 8;
        edgeList[12][2] = 16;
        // 13
        edgeList[13][0] = 7;
        edgeList[13][1] = 4;
        edgeList[13][2] = 24;
        // 14
        edgeList[14][0] = 8;
        edgeList[14][1] = 5;
        edgeList[14][2] = 7;
        // 15
        edgeList[15][0] = 7;
        edgeList[15][1] = 8;
        edgeList[15][2] = 19;
    }

    public static void CreateAdjList(VertexList[] vertexList, int[][] edgeList) {
        int len = edgeList.length;
        for (int i = 1; i < len; i++) {
            int s = edgeList[i][0];
            int e = edgeList[i][1];
            adjNode node1 = new adjNode();
            node1.data = s;

            node1.next = vertexList[e].firstNode;
            vertexList[e].firstNode = node1;

            adjNode node2 = new adjNode();
            node2.data = e;
            node2.next = vertexList[s].firstNode;
            vertexList[s].firstNode = node2;
        }
    }

    public static void CreateAdjMat(int[][] edgeList, int[][] edgeMat) {
        // 长度搞错了
        int lenVer = edgeMat.length;
        for (int i = 1; i < lenVer; i++) {
            for (int i1 = 1; i1 < lenVer; i1++) {
                // 不相连的距离设为无穷大
                if (i==i1){
                    edgeMat[i][i1] = 0;
                }else {
                    edgeMat[i][i1] = 65535;
                }
            }
        }
        int len = edgeList.length;
        for (int i = 1; i < len; i++) {
            int s = edgeList[i][0];
            int e = edgeList[i][1];
            edgeMat[s][e] = edgeList[i][2];
            edgeMat[e][s] = edgeList[i][2];
        }
    }
}
