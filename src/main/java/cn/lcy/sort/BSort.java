package cn.lcy.sort;

public class BSort {
    public static void main(String[] args) {
        int a[] = {1, 3, 4, 5, 6, 7,0, 8, 11, 18};
        System.out.println(bsearch(a, 10, 8));
    }

    /*public static int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n-1;
        while (low<=high){
            int mid = low + ((high-low) >> 1);
            if (a[mid] > value){
                high = mid -1;
            } else if(a[mid]<value){
                low = mid + 1;
            }else if (a[mid] == value){
                if (mid==0 || a[mid-1]!=value) return mid;
                else high = mid-1;
            }
        }
        return -1;
    }*/

    public static int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n-1;
        while (low<=high){
            int mid = low + ((high-low) >> 1);
            if (a[mid] >= value){
                high = mid -1;
            } else if(a[mid]<value){
                low = mid + 1;
            }
        }
        if (low<n && a[low] == value) return low;
        return -1;
    }

}
