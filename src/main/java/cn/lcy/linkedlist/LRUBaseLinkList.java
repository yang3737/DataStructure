package cn.lcy.linkedlist;

public class LRUBaseLinkList {

    public Node head;
    private int cap;
    private int count;

    public LRUBaseLinkList(int cap) {
        this.cap = cap;
    }

    public int insertToHead(int val) {
        Node node = new Node(val, null);
        if (head == null) {
            head = node;
            count++;
            return 1;
        }
        if (head.data == val) {
            return 1;
        }
        Node pre = findPreByVal(val);
        if (pre != null) {
            deleteByPre(pre);
        }
        if (count >= count) {
            deleteTail();
        }
        node.next = head;
        head = node;
        count++;
        return 1;
    }

    public Node findPreByVal(int val) {
        if (head == null) return null;
        Node p = head;
        while (p.next != null && p.next.data != val) {
            p = p.next;
        }
        if (p.next == null) return null;
        return p.next;
    }

    public void deleteByPre(Node pre) {
        pre.next = pre.next.next;
        count--;
    }

    public void deleteTail() {
        if (head == null) {
            return;
        }
        Node p = head;
        if (p.next == null) {
            head = null;
        }
        if (p.next.next != null) {
            p = p.next;
        }
        p.next = p.next.next;
        count--;
    }


    public class Node {
        public int data;
        public Node next;

        public Node(int val, Node next) {
            this.data = val;
            this.next = next;
        }

    }
}

