package main.java.algorithm.basicstructure.Demo;

import main.java.algorithm.basicstructure.LinkedList.DoublyListNode;

import static main.java.algorithm.basicstructure.LinkedList.DoublyListNode.*;

public class DoublyLinkedListDemo {
    public static void main(String[] args) {
        DoublyListNode head = createDoublyLinkedList(new int[]{1, 2, 3, 4, 5});
        DoublyListNode tail = null;

        tail = searchDoublyList(head, tail);
        head = insertHead(head, 0);
        tail = insertTail(tail, 6);
        insertMiddle(head,1,1);
        tail = searchDoublyList(head, tail);

        System.out.println("head.val = " + head.val);
        System.out.println("tail.val = " + tail.val);

    }
}
