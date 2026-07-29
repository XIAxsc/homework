package main.java.algorithm.basicstructure.LinkedList;

public class DoublyListNode {
    public int val;
    public DoublyListNode next, prev;
    public DoublyListNode(int x) {
        val = x;
    }

    public static DoublyListNode createDoublyLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        DoublyListNode head = new DoublyListNode(arr[0]);
        DoublyListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            DoublyListNode newNode = new DoublyListNode(arr[i]);
            cur.next = newNode;
            newNode.prev = cur;
            cur = cur.next;
        }
        return head;
    }

    public static DoublyListNode searchDoublyList(DoublyListNode head, DoublyListNode tail) {
        // 正向遍历
        for (DoublyListNode p = head; p != null; p = p.next) {
            System.out.print(p.val + " ");
            tail = p;
        }
        System.out.println();

        // 反向遍历
        for (DoublyListNode p = tail; p != null; p = p.prev) {
            System.out.print(p.val + " ");
        }
        System.out.println();

        return tail;
    }

    // 在头结点前新插入一个节点，返回新头结点地址
    public static DoublyListNode insertHead(DoublyListNode head, int newNum) {
        DoublyListNode newHead = new DoublyListNode(newNum);
        newHead.next = head;
        head.prev = newHead;
        head = newHead;
        return head;
    }

    // 在尾节点后插入一个新的节点，返回尾结点的地址
    public static DoublyListNode insertTail(DoublyListNode tail, int newNum) {
        DoublyListNode newTail = new DoublyListNode(newNum);
        newTail.prev = tail;
        tail.next = newTail;
        tail = newTail;
        return tail;
    }

    // 在双链表中间插入一个新的节点，通过索引找到插入位置的前一个节点，先把新节点的next和prev地址赋值，再赋值P节点的next
    public static void insertMiddle(DoublyListNode head, int newNum, int index) {
        DoublyListNode newNode = new DoublyListNode(newNum);
        DoublyListNode p =head;

        for (int i = 1; i < index; i++) {
            p=p.next;
        }
        newNode.next = p.next;
        newNode.prev = p;
        p.next = newNode;
        newNode.next.prev = newNode;
    }
}

