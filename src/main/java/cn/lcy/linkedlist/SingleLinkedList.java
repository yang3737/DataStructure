package cn.lcy.linkedlist;


public class SingleLinkedList {

    private Node head;

    public SingleLinkedList() {
    }

    public boolean insertToTail(int a) {
        Node node = new Node(a, null);
        if (head == null) {
            head = node;
            return true;
        }
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = node;
        return true;
    }

    /**
     * 这个方法是错误的，没有考虑尾节点的情况
     *
     * @param a
     * @return
     */
    public boolean remove(int a) {

        if (head == null) return false;
        if (head.data == a) head = null;
        Node p = head;
        while (p != null && p.data == a) {
            p.next = p.next.next;
        }
        return true;
    }

    public boolean removeFirst(int a) {

        if (head == null) return false;
        if (head.data == a) head = null;
        Node p = head;
        Node q = null;
        while (p != null && p.data != a) {
            q = p;
            p = p.next;
        }
        if (p == null) {
            return false;
        }
        q.next = p.next;
        return true;
    }

    public void removeALl(int a) {

        if (head != null && head.data == a) {
            head = head.next;
        }
        Node p = head;
        while (p != null) {
            if (p.next != null && p.next.data == a) {
                p.next = p.next.next;
                continue;
            }
            p = p.next;
        }
    }

    public Node get(int a) {
        Node node = head;
        while (node != null && node.data != a) {
            node = node.next;
        }
        return node;
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
    }

    public boolean palindrome() {
        Node left = null;
        Node right = null;
        if (head == null) return false;
        if (head.next == null) return true;
        Node p = head;
        Node q = head;
        while (q.next != null && q.next.next != null){
            p = p.next;
            q = q.next.next;
        }
        System.out.println("中间节点：" + p.data);
        if (q.next == null){
            System.out.println("链表为奇数节点");
            right = p.next;
            left = revertLinkedList(p).next;
        }else {
            right = p.next;
            left = revertLinkedList(p);
        }

        return TFResult(left, right);

    }

    public boolean TFResult(Node left, Node right) {
        Node r = right;
        Node l = left;
        while ( r != null && l != null){
            if (r.data == l.data){
                r = r.next;
                l = l.next;
                continue;
            }else {
                return false;
            }
        }
        return true;
    }

    public  boolean iscycle(){
        if (head == null && head.next == null) return false;

        Node p = head;
        Node q = head;
        while (q.next != null && q.next.next !=null){
            p = p.next;
            q = q.next.next;
            if (p == q){
                return true;
            }
        }

        return false;
    }


    /**
     * 翻转单链表
     *
     * @param p
     * @return
     */
    public Node revertLinkedList(Node p) {
        Node pre = null;
        Node next = null;
        Node r = head;
        while (r!=p){
            next = r.next;
            r.next = pre;
            pre = r;
            r = next;
        }
        r.next = pre;
        return  r;
    }


    public static class Node {
        private int data;
        private Node next;

        public Node(int a, Node n) {
            this.data = a;
            this.next = n;
        }
    }

    public static void main(String[] args) {

        SingleLinkedList link = new SingleLinkedList();
        System.out.println("hello");
        //int data[] = {1};
        //int data[] = {1,2};
        //int data[] = {1,2,3,1};
        //int data[] = {1,2,5};
        int data[] = {1, 2, 3, 4,5,2};
        //int data[] = {1,2,5,2,1};
        //int data[] = {1,2,5,3,1};

        for (int i = 0; i < data.length; i++) {
            //link.insertToHead(data[i]);
            link.insertToTail(data[i]);
        }
        // link.printAll();
        // Node p = link.inverseLinkList_head(link.head);
        // while(p != null){
        //     System.out.println("aa"+p.data);
        //     p = p.next;
        // }
        //link.removeALl(5);
        System.out.println("是否有环："+link.iscycle());
        System.out.println("打印原始:");
        link.printAll();
        if (link.palindrome()) {
            System.out.println("回文");
        } else {
            System.out.println("不是回文");
        }
    }
}
