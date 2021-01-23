package cn.lcy.queue;

public class ArrayQueue {

    private int[] item;
    private int cap;

    private int tail;
    private int head;

    public ArrayQueue(int cap) {
        item = new int[cap];
        this.cap = cap;
    }

    public boolean enqueue(int val) {
        if (tail + 1 == cap) {
            return false;
        }
        item[tail] = val;
        tail++;
        return true;
    }

    public int dequeue() throws Exception {
        if (tail == head) throw new Exception("Queue is empty");
        int val = item[head];
        head++;
        return val;
    }
}
