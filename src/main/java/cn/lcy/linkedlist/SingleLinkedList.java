package cn.lcy.linkedlist;


public class SingleLinkedList {

    private static Node head;


    public void insertToTail(String val) {
        Node p = new Node(val, null);
        if (head == null){
            head = p;
            return;
        }
        Node q = head;
        while (q.next != null) {
            q = q.next;
        }
        q.next = p;
    }

    private static boolean compareNode(Node right, Node left) {
        boolean flag= false;
        while (right!=null && left!=null){
            if (right.data.equals(left.data)){
                right = right.next;
                left = left.next;
                flag = true;
            }else {
                break;
            }
        }
        if (right!=null && left==null){
            return false;
        }
        if (left!=null && right==null){
            return false;
        }
        return flag;
    }

    private static Node flip(Node p) {
        Node next = null;
        Node pre = null;
        Node q = head;
        while (q!=p){
            next = q.next;
            q.next = pre;
            pre = q;
            q = next;
        }
        p.next = pre;
        return p;
    }

    public static void main(String[] args) {
        String[] arrays = {"1","2","2","1"};
        SingleLinkedList linkedList = new SingleLinkedList();
        for (int i = 0; i < arrays.length; i++) {
            linkedList.insertToTail(arrays[i]);
        }
        Node p = head;
        Node q = head;
        if (q.next!=null && q.next.next!=null){
            p = p.next;
            q = q.next.next;
        }
        System.out.println("中间元素"+p.data);
        boolean flag = false;
        if (q.next == null){
            System.out.println("链表长度为奇数");
            Node right = p.next;
            Node left = flip(p).next;
            flag = compareNode(right,left);

        }else {
            Node right = p.next;
            Node left = flip(p);
            flag = compareNode(right,left);
            System.out.println("链表长度为偶数");
        }
        if (flag){
            System.out.println("是回文");
        }else {
            System.out.println("不是回文");
        }
    }




    public class Node {
        String data;
        Node next;

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
