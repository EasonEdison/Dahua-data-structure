package Sort.QuickSort;

import Sort.utils.utils;

public class quickSort {
    public static void main(String[] args) {
        int[] a = {62, 58, 88, 47, 73, 99, 35, 52, 93, 37};
        QSort1(a, 0, a.length-1);
        utils.show(a);
        System.out.println("----------------");
        int[] b = {62, 58, 88, 47, 73, 99, 35, 52, 93, 37};
        QSort2(b, 0, b.length-1);
        utils.show(b);
    }

    private static void QSort2(int[] a, int low, int high) {
        // 优化迭代
        while(low < high){
            // 让keyget2代替pivkey+1 到 high的部分
            int pivkey = keyget2(a, low, high);
            QSort2(a, low, pivkey-1);
            low = pivkey+1;
        }
    }


    private static int keyget2(int[] a, int low, int high) {
        // 优化枢轴的选择
        // 找中位数
        int m = (low + high) / 2;
        if (a[m] < a[low]){
            utils.swap(a, m, low);
        }
        if (a[high] < a[m]){
            // 此时high已经是最大的了
            utils.swap(a, m, high);
        }
        if (a[m] > a[low]){
            // 此时m是最小的了
            utils.swap(a, m, low);
        }

        // key这里用m还是有点不合适，m不会再变化了
        // 让low做中位数
        int key = a[low];
        // 优化不必要的交换
        while (low < high){
            // 此处应有=key，否则会陷入死循环
            while (a[high]>=key && low<high){
                high--;
            }
            a[low] = a[high];
            while (a[low]<=key && low<high){
                low++;
            }
            a[high] = a[low];
        }
        a[low] = key;
        return low;
    }


    private static void QSort1(int[] a, int low, int high) {
        if (low < high){
            // 获取枢轴位置
            int pivkey = keyget1(a, low, high);
            QSort1(a, low,pivkey-1);
            QSort1(a, pivkey+1, high);
        }
    }


    private static int keyget1(int[] a, int low, int high) {
        int key = a[low];
        // 不断交换
        while (low < high){
            // 别忘了在里面也要加上low和high的判断
            while (a[high]>key && low<high){
                high--;
            }
            utils.swap(a, low, high);
            while (a[low]<key && low<high){
                low++;
            }
            utils.swap(a, low, high);
        }
        return low;
    }
}
