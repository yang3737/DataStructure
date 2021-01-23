package cn.lcy.queue;

public class ArrayQueue {

    private String[] item;

    private int n = 0;

    private int head;

    private int tail;

    public ArrayQueue(int cap) {
        item = new String[cap];
        this.n = cap;
    }

    private boolean enqueue(String x) {
        if (tail == n) {
            if (head == 0) return false;
            for (int i = head;i < tail; i++){
                item[i-head] = item[i];
            }
            tail -= head;
            head = 0;
        }
        item[head] = x;
        tail++;
        return true;
    }

    private String dequeue() {
        if (tail == head) return null;
        String ret = item[head];
        ++head;
        return ret;
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enqueue("1");
        arrayQueue.enqueue("2");
        arrayQueue.enqueue("3");
        arrayQueue.enqueue("4");
        arrayQueue.enqueue("5");
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.enqueue("6");

        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());

    }

}
