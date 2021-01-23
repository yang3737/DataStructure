package cn.lcy.stack;


public class ArrayStack {
    private int[] item;

    /**
     * 现有的元素
     */
    private int n;

    /**
     * 栈的容量
     */
    private int cap;


    public ArrayStack(int cap) throws Exception {
        if (cap==0){
            throw new Exception("Stack length can not zero");
        }
        this.cap = cap;
        int[] item = new int[cap];
    }

    public boolean push(int a){
        if (n==cap){
            return false;
        }
        item[n++] = a;
        return true;
    }


    public int pop() throws Exception {
        if (n==0){
            throw new Exception("Stack is empty");
        }
        int val = item[n-1];
        n--;
        return val;
    }

}
