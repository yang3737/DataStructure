package cn.lcy.linkedlist;


public class SingleLinkedList {

    public Node head;

    public void insertToTail(String val) {
        Node q = new Node(val, null);
        if (head == null){
            head = q;
            return;
        }
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = q;
    }


    //判断是否回文字符串
    public boolean rang() {
        if (head == null || head.next == null) return false;
        Node p = head;
        Node q = head;
        //用快慢指针获取中间节点
        while (q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }
        Node right = null;
        Node left = null;
        if (q.next == null) {
            System.out.println("链表为奇数节点");
            right = p.next;
            left = flip(p).next;
        } else {
            System.out.println("链表为偶数节点");
            right = p.next;
            left = flip(p);
        }

        return compareNodeList(left, right);
    }


    //翻转链表
    public Node flip(Node p) {
        Node next = null;
        Node pre = null;
        //要翻转的节点
        Node q = head;
        while (q != p) {
            //记录下一个要翻转的节点
            next = q.next;
            //当前节点指向前置节点
            q.next = pre;
            //记录前置节点
            pre = q;
            //设置要翻转的节点
            q = next;
        }
        //最后一个节点翻转
        p.next = pre;
        return p;
    }


    //判断左右链表是否相等
    public boolean compareNodeList(Node p, Node q) {
        while (p != null && q != null) {
            if (p.data.equals(q.data)) {
                p = p.next;
                q = q.next;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        SingleLinkedList linkedList = new SingleLinkedList();
        String[] a = {"1","1","2","3","2","1","1"};
        for (int i = 0; i < a.length; i++) {
            linkedList.insertToTail(a[i]);
        }

        System.out.println(linkedList.rang() ? "是回文" : "不是回文");

    }


    public static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
