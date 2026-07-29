package algorithm.basicstructure.Demo;

import algorithm.basicstructure.LinkedList.ListNode;

public class LinkedListDemo {

    public static void main(String[] args) {

        // 创建一条单链表
        ListNode head = ListNode.createLinkedList(new int[]{1, 2, 3, 4, 5});

        // 遍历单链表
        ListNode.traverse(head);

    }
}


