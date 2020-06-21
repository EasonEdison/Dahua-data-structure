package Sort.HeapSort;

import Sort.utils.utils;

public class headSort {
    public static void main(String[] args) {

        int[] a = {62, 58, 88, 47, 73, 99, 35, 52, 93, 37};
        int[] b = new int[a.length+1];
        for (int i = 0; i < a.length; i++) {
            b[i+1] = a[i];
        }
        // 先初始化，利用了完全二叉树的性质
        for (int i=a.length / 2; i>0; i--){
            HeadAdjust(b, i, a.length);
        }

        for (int i=a.length; i >1; i--){
            // 先交换再整理，整理中的交换只是为了整理
            utils.swap(b, 1, i);
            HeadAdjust(b, 1, i-1);
        }

        utils.show(b);
    }

    // 从s开始以后的数组变成大顶堆
    public static void HeadAdjust(int[] L, int s, int len){

        int j, temp;
        temp = L[s];
        // j按理说可=len
        for (j=2*s; j<=len ;j=2*j){
            // 防止j+1越界
            if (j+1 <= len){
                if (L[j+1] > L[j]){
                    j++;
                }
            }
            if (L[s] < L[j]){
                utils.swap(L, j, s);
            } else {
                // 如果已经是最大了，就不用向下比了
                break;
            }
            s = j;
        }
    }
}
