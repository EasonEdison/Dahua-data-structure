package Sort.ShellSort;

import Sort.utils.utils;

public class shellSort {
    public static void main(String[] args) {
        int[] a = {62, 58, 88, 47, 73, 99, 35, 52, 93, 37};
        method(a);
        utils.show(a);
    }

    private static void method(int[] a) {
        int temp = 0;
        int j = 0;
        int increment = a.length;
        do {
            increment = increment / 3 + 1;
            // 一开始用的i=increment,使用a[i]和a[i+increment]比较，但是这样会出错
            // 会漏掉了一些内容
            // 这里的条件也错了，写成了i+=increment
            // 增量是后面比较的时候用的，所以这里应是i++
            for (int i=increment; i < a.length; i++) {
                if (a[i-increment] > a[i]) {
                    temp = a[i];
                    // 向前检查, j为0或正序就停止
                    // 这里比较写错了，影师和temp比较
                    // 这里影师j-increment>=0,因为没有用哨兵，数组从0开始存放数据
                    for (j = i; j-increment >= 0 && a[j-increment] > temp; j -= increment) {
                        a[j] = a[j-increment];
                    }
                    a[j] = temp;
                }
            }
        // 这里的限制条件是increment最后等于1
        // 这里是已经执行过的，上面已经等于1再执行了
        } while (increment > 1);
    }
}
