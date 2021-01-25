package cn.lcy.sort;

/**
 * Created by wangzheng on 2018/10/16.
 */
public class QuickSort {

    // 快速排序，a是数组，n表示数组的大小
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }

    // 快速排序递归函数，p,r为下标
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) return;

        int q = partition(a, p, r); // 获取分区点
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);
    }

    private static int partition(int[] a, int p, int r) {
        int x = a[r];
        int i = p;
        for (int j = p;j<r;j++){
            if (a[j]<x && i!=j){
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
            i++;
        }
        a[r] = a[i];
        a[i] = x;
        return i;
    }


    public static void main(String[] args) {
        int a[] = {7, 6, 5, 4, 2, 1, 3};
        quickSort(a, 7);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
