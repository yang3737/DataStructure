package cn.lcy.queue;

public class CycleQueue {
    private int[] item;
    private int tail = 0;
    private int head = 0;
    private int n;


    public CycleQueue(int cap) {
        item = new int[cap];
        this.n = cap;
    }

    public boolean enqueue(int value) {
        if ((tail + 1) % n == head) return false;
        item[tail] = value;
        tail = (tail + 1) % n;
        return true;
    }

    public Integer dequeue() {
        if (tail == head) return null;
        int value = item[head];
        head = (head + 1) % n;
        return value;
    }


}
