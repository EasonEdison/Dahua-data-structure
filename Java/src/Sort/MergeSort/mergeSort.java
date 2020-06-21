package Sort.MergeSort;

import Sort.utils.utils;

public class mergeSort {
    public static int MAXSIZE;

    public static void main(String[] args) {
        int[] a = {62, 58, 88, 47, 73, 99, 35, 52, 93, 37};
        MAXSIZE = a.length;

        MergeSort(a, a, 0, a.length-1);
        System.out.println("-------------");
        utils.show(a);
    }

    // SR是固定的，TR用来存放结果，s是开始的位置，t是结束的位置
    public static void MergeSort(int[] SR, int[] TR, int s, int t){
        int m;
        // 存放被分段的内容
        int[] TR2 = new int[MAXSIZE];
        // 结束条件, s==t 无法再分
        if (s==t){
            TR[s] = SR[s];
        } else {
            m = (s + t) / 2;
            // 利用SR来赋值
            MergeSort(SR, TR2, s, m);
            MergeSort(SR, TR2, m+1, t);
            // 其实就算是TR2一直被保存
            MergeMethod(TR2, TR, s, m, t);
        }

    }

    // tr是存放的，sr是临时的
    public static void MergeMethod(int[] sr, int[] tr, int i, int m, int n) {

        // tr的起点
        int k = i;
        int j;
        // 两个判断条件
        for (j=m+1; j<=n && i<=m; k++){
            if (sr[j] < sr[i]){
                tr[k] = sr[j++];
            } else {
                tr[k] = sr[i++];
            }
        }
        // 检查两个数组是否还有剩余
        if (i <= m){
            for (int l=0; l<=m-i; l++){
                tr[k+l] = sr[i+l];
            }
        }

        if (j <= n){
            for (int l=0; l<=n-j; l++){
                tr[k+l] = sr[j+l];
            }
        }
    }
}
