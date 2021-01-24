package cn.lcy.sort;

import org.omg.PortableInterceptor.INACTIVE;

import java.lang.ref.Reference;

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
        int[] temp = new int[r - p + 1];
        int k = 0;
        while (i <= q && j <= r) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            temp[k++] = a[start++];
        }

        for (int m = 0; m <= r - p; m++) {
            a[p + m] = temp[m];
        }


    }

    public static void mergeByBing(int[] a, int p, int q, int r) {
        int[] left = new int[q-p+2];
        int[] right = new int[r-q+1];
        for (int i = 0;i<=q-p;i++){
            left[i] = a[p+i];
        }
        for (int i = 0;i<r-q;i++){
            right[i] = a[q+1+i];
        }
        left[q-p+1] = Integer.MAX_VALUE;
        right[r-q] = Integer.MAX_VALUE;
        int k = p;
        int i = 0;
        int j = 0;
        while (k<=r){
            if (left[i]<right[j]){
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
            }
        }

     }
}
