package cn.lcy.sort;

public class BSort {
    public static void main(String[] args) {
        int a[] = {1, 3, 4, 5, 6, 7,  8, 8, 10};
        System.out.println(bsearchLastSmall(a, 10, 8));
    }

    /**
     * 查找第一个符合条件的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            }
        }
        if (low < n && a[low] == value) return low;
        return -1;
    }

    /**
     * 查找第一个符合给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bsearchFirst(int[] a, int n, int value) {
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
                else low = mid+1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个符合给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bsearchLast(int[] a, int n, int value) {
        int low = 0;
        int high = n-1;
        while (low<=high){
            int mid = low + ((high-low) >> 1);
            if (a[mid] > value){
                high = mid -1;
            } else if(a[mid]<value){
                low = mid + 1;
            }else if (a[mid] == value){
                if (mid==(n-1) || a[mid+1]!=value) return mid;
                else low = mid+1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bsearchFirstBig(int[] a, int n, int value) {
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
        if (a[low]>=value) return low;
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bsearchLastSmall(int[] a, int n, int value) {
        int low = 0;
        int high = n-1;
        while (low<=high){
            int mid = low + ((high-low) >> 1);
            if (a[mid] > value){
                high = mid -1;
            } else if(a[mid]<=value){
                if (mid==(n-1) || a[mid+1]>value) return mid;
                else low = mid + 1;
            }
        }
        if (low<n && a[low]>value) return low;
        return -1;
    }






}
