package cn.lcy.linkedlist;

public class LRUBaseLinkList {

    int cap = 100;

    int length = 0;

    private Node head;

    public Node findNodeByValue(int a) {
        if (head == null) return null;
        Node node = head;
        while (node != null && node.data != a) {
            node = node.next;
        }
        if (node == null) return null;
        return node;
    }

    public Node findPreNodeByValue(int a) {
        if (head == null) return null;
        Node node = head;
        if (node.data == a) return head;
        while (node.next != null && node.next.data != a) {
            node = node.next;
        }
        if (node.next == null) return null;
        return node;
    }

    public boolean add(int a) {
        if (length >= 100) {
            delTail();
        }
        Node node = findPreNodeByValue(a);
        if (node != null) {
            delByPre(node);
        }
        Node q = new Node(a);
        if (head == null) {
            head = q;
            return true;
        }
        q.next = head;
        head = q ;
        ++length;
        return true;
    }

    public boolean delByPre(Node pre) {
        if (pre.data == head.data && length == 1) {
            head = null;
            return true;
        }
        pre.next = pre.next.next;
        --length;
        return true;
    }

    public boolean delTail() {
        Node p = head;
        while (p.next != null && p.next.next != null) {
            p = p.next;
        }
        p.next = null;
        return true;
    }

    public void printList() {
        Node p = head;
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
    }


    public static class Node {
        int data;
        Node next;

        public Node(int a) {
            this.data = a;
        }

    }


    public static void main(String[] args) {
        LRUBaseLinkList lruBaseLinkedList = new LRUBaseLinkList();
        lruBaseLinkedList.add(1);
        lruBaseLinkedList.add(2);
        lruBaseLinkedList.add(3);
        lruBaseLinkedList.add(4);
        lruBaseLinkedList.add(2);
        lruBaseLinkedList.printList();
    }
}
