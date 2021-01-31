package cn.lcy.sort;

/**
 * Created by wangzheng on 2018/10/16.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = {7, 6, 5, 4, 3, 2, 1};
        mergeSort(a, 7);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void mergeSort(int[] a, int n) {
        mergeSortInternally(a, 0, n - 1);
    }

    public static void mergeSortInternally(int a[], int p, int r) {
        if (p < r) {
            int q = p + (r - p) / 2;
            mergeSortInternally(a, p, q);
            mergeSortInternally(a, q + 1, r);
            mergeByBing(a, p, q, r);
        }
    }

    public static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        //临时数组，先从a数组中从小到大取出到临时数组，再把临时数组的元素复制到原数组
        int[] temp = new int[r - p + 1];
        int k = 0;
        //将元素分别从左右序列里面取小的元素
        while (i <= q && j <= r) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        //取剩余的元素
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            temp[k++] = a[start++];
        }
        //复制到原数组
        for (int m = 0; m <= r - p; m++) {
            a[p + m] = temp[m];
        }

    }

    /**
     * 利用哨兵，简化归并排序
     * @param a
     * @param p
     * @param q
     * @param r
     */
    public static void mergeByBing(int[] a, int p, int q, int r) {
        int[] left = new int[q - p + 2];
        int[] right = new int[r - q + 1];
        for (int i = 0; i <= q - p; i++) {
            left[i] = a[p + i];
        }
        for (int j = 0; j < r - q; j++) {
            right[j] = a[q + 1 + j];
        }
        left[q - p + 1] = Integer.MAX_VALUE;
        right[r - q] = Integer.MAX_VALUE;
        int k = p;
        int i = 0;
        int j = 0;
        //通过数量的限制和哨兵比较，正确的将元素从小到达复制到原数组
        while (k <= r) {
            if (left[i] < right[j]) {
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
            }
        }

    }
}
