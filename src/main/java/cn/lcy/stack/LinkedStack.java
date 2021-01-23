package cn.lcy.stack;

public class LinkedStack {

    private Node top;

    private int count;

    private int cap;

    public LinkedStack(int cap){
        this.cap = cap;
    }

    /**
     * 链表插入头
     * @param val
     * @return
     */
    public int push(int val) {

        if (count == cap) return -1;
        Node p = new Node(val,null);
        if (top == null){
            top = p;
        }else {
            p.next = top;
            top = p;
        }
        count++;
        return 1;
    }

    /**
     * 后进先出
     * @return
     */
    public int pop(){
        if (top == null) return -1;
        int val = top.data;
        top = top.next;
        count--;
        return val;
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int val, Node next) {
            this.data = val;
            this.next = next;
        }
    }
}
