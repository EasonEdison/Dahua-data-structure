package Sort.MergeSort;

import Sort.utils.utils;

public class mergeSortNew {
    public static void main(String[] args) {
        int[] a = {62, 58, 88, 47, 73, 99, 35, 52, 93, 37};
        merge_sort(a);
        utils.show(a);

    }

    // 归并排序（Java-迭代版）
    public static void merge_sort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        int block, start;

        // block为间隔
        for(block = 1; block < len*2; block *= 2) {
            for(start = 0; start <len; start += 2 * block) {
                // 控制间隔
                int low = start;
                int mid = (start + block) < len ? (start + block) : len;
                int high = (start + 2 * block) < len ? (start + 2 * block) : len;
                // 两段的首尾
                int start1 = low, end1 = mid;
                int start2 = mid, end2 = high;
                // 开始对两个block进行归并排序
                // 优美啊
                while (start1 < end1 && start2 < end2) {
                    result[low++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
                }
                while(start1 < end1) {
                    result[low++] = arr[start1++];
                }
                while(start2 < end2) {
                    result[low++] = arr[start2++];
                }
            }
            // 互换
            int[] temp = arr;
            arr = result;
            result = temp;
        }
        result = arr;
    }
}
