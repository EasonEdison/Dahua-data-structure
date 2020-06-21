package String;

import java.util.Scanner;

public class BaseMatch {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        System.out.println("输入数组1");
        String str1 = "jojostarstarl";
        System.out.println(str1);
//        String str1 = scanner.next();
        System.out.println("输入数组2");
//        String str2 = scanner.next();
        String str2 = "starl";
        System.out.println(str1);
        System.out.println("正确结果应为：");
        System.out.println(EasyMatch(str1.toCharArray(), str2.toCharArray()));
        System.out.println("KMP结果尾：");
        System.out.println(KMP(str1.toCharArray(), str2.toCharArray()));

    }


    private static Object EasyMatch(char[] str1, char[] str2) {
        int len1 = str1.length;
        int len2 = str2.length;
        int count = 0;

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (str1[i + j] == str2[j]) {
                    count++;
                    if (count == len2)
                        return i + 1;
                }
            }
            count = 0;
        }

        return "不匹配";
    }

    private static Object KMP(char[] str1, char[] str2) {
        int len1 = str1.length;
        int len2 = str2.length;
        int[] next = new int[len2];
        // 获取next数组
        next = getNextVal(str2);
        int i = -1;
        int j = -1;
        // 两个都不能越界
        while (i < len1 && j < len2) {
            // 通过两个条件推动数组移动
            if (j == -1 || str1[i] == str2[j]) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }
        // 判断是否比较了str2的全部
        if (j >= len2) {
            // 如果不加1则输出的是下标位置，下标位置是比实际位置小1的
            return i - len2 + 1;
        }
        return "没找到";
    }

    private static int[] getNext(char[] str) {
        int len = str.length;
        int i = 0;  // 后移
        int j = -1;  // 回溯
        int[] next = new int[len];
        next[0] = -1;
        // 即算完最后的i++之后i=len，停止循环
        while (i < len - 1) {
            if (j == -1 || str[i] == str[j]) {
                i++;
                j++;
                // 回溯位置和相同数相关
                next[i] = j;
            } else {
                j = next[j];    // 不相同，要回溯
            }
        }

        return next;
    }

    private static int[] getNextVal(char[] str) {
        int len = str.length;
        int i = 0;
        int j = -1;
        int[] next = new int[len];
        next[0] = -1;
        while (i < len - 1) {
            if (j == -1 || str[i] == str[j]) {
                ++j;
                ++i;
                // 不相等了，就不用管重复问题了
                if (str[i] != str[j])
                    next[i] = j;
                else
                    // 相等就一直回溯到最前的第一个同元素位置
                    next[i] = next[j];
            } else {
                j = next[j];
            }
        }
        return next;
    }
}