package cn.lcy.sort;

import java.lang.ref.Reference;

/**
 * Created by wangzheng on 2018/10/16.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = {7,6,5,4,3,2,1};
        mergeSort(a,7);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void mergeSort(int[] a, int n){
        mergeSortInternally(a,0, n-1);
    }

    public static void mergeSortInternally(int a[],int p,int r){
        if (p>=r) return;
        int q = p+(r-p)/2;
        mergeSortInternally(a,p,q);
        mergeSortInternally(a,q+1,r);
        merge(a,p,q,r);
    }

    public static void merge(int[] a, int p, int q, int r){
        int i = p;
        int j = q+1;
        int[] temp = new int[r-p+1];
        int k = 0;
        while (i<=q && j<=r){
            if (a[i]<a[j]){
                temp[k++] = a[i++];
            }else {
                temp[k++] = a[j++];
            }
        }

        int start = i;
        int end = q;
        if (j<=r){
            start = j;
            end = r;
        }
//        while (start <= end) {
//            temp[k++] = a[start++];
//        }
        for (int m = start;m<=end;m++){
            temp[k++] = a[m];
        }

        for (int n =0;n<r-p+1;n++){
            a[p+n] = temp[n];
        }
    }
}
