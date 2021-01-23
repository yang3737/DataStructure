package cn.lcy.stack;

import apple.laf.JRSUIConstants;

public class ArrayStack {

    private String[] item;

    private int count;

    private int n;

    public ArrayStack(int cap) {
        this.item = new String[cap];
        this.n = cap;
        this.count=0;
    }

    public boolean push(String x) {
        if (count == this.n){
            int cap = this.n*2;
            this.n = cap;
            String[] copy = new String[cap];
            for (int i = 0; i < item.length; i++) {
                copy[i] = item[i];
            }
            item = copy;
        }
        item[count] = x;
        count++;
        return true;
    }

    public String pop() {
        if (count == 0) return null;
        String ret = item[count - 1];
        count--;
        return ret;
    }
}
