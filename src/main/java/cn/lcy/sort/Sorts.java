package cn.lcy.sort;

import java.awt.event.FocusEvent;

public class Sorts {

    public static void main(String[] args) {
        int a[] = {5, 4, 3, 2, 1};
        insertSort(a, 5);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void sort(int[] a, int n) {
        if (n <= 0) return;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) return;
        }

    }

    public static void chooseSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int temp = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > temp) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = temp;
        }

    }

    public static void insertSort(int[] a, int n) {

        for (int i = 0; i < n; i++) {
            int min = i;
            int j = i + 1;
            for (; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }

    }

}
