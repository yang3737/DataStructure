package cn.lcy.queue;

public class CycleQueue {

    private int[] item;

    private int cap;

    private int head;

    private int tail;

    public CycleQueue(int cap) {
        item = new int[cap];
        this.cap = cap;
    }

    public void enqueue(int val) throws Exception {
        if ((tail + 1) % cap == head) {
            throw new Exception("Queue is full");
        }
        item[tail] = val;
        tail = (tail + 1) % cap;
    }

    public int dequeue() throws Exception {
        if (head == tail){
            throw new Exception("Queue is empty");
        }
        int val = item[head];
        head = (head+1)%cap;
        return val;
    }

}
