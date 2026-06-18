package test.exe;

class MyLinkedList {
    final private Node head;
    final private Node tail;
    private int size;

    public MyLinkedList() {
        this.head = new Node(0);
        this.tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        size = 0;

    }

    public static class Node {
        int val;
        Node next;
        Node prev;

        Node(int val) {
            this.val = val;
        }

    }


    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node p = head;
        for (int i = 0; i < index + 1; i++) {
            p = p.next;
        }
        return p.val;
    }

    public void addAtHead(int val) {
        if (val > 1000) {
            return;
        }
        Node newNode = new Node(val);
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
        size++;
    }

    public void addAtTail(int val) {
        if (val > 1000) {
            return;
        }
        Node newNode = new Node(val);
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        tail.prev = newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        } else if (index == size) {
            addAtTail(val);
        } else {
            Node newNode = new Node(val);
            Node p = head;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
            newNode.prev = p;
            newNode.next = p.next;
            p.next.prev = newNode;
            p.next = newNode;
            size++;
        }

    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size || size == 0) {
            return;
        }
        Node p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        Node x = p.next;
        x.next.prev = p;
        p.next = x.next;
        x.next = null;
        x.prev = null;
        size--;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        System.out.println("myLinkedList.head.next.val = " + myLinkedList.head.next.val);
        myLinkedList.addAtTail(3);
        System.out.println("myLinkedList.tail.prev.val = " + myLinkedList.tail.prev.val);
        System.out.println("myLinkedList.size = " + myLinkedList.size);
        myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
        System.out.println("myLinkedList.head.next.next.val = " + myLinkedList.head.next.next.val);
        System.out.println("myLinkedList.get(1) = " + myLinkedList.get(1));                        // 返回 2
        myLinkedList.deleteAtIndex(1);              // 现在，链表变为 1->3
        System.out.println("myLinkedList.get(1) = " + myLinkedList.get(1));
    }
}
