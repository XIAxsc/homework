package algorithm.basicstructure.LinkedList;

public class LinkedListDemo {

    public static void main(String[] args) {

        // 创建一条单链表
        ListNode head = createLinkedList(new int[]{1, 2, 3, 4, 5});

        // 遍历单链表
        for (ListNode p = head; p != null; p = p.next) {
            System.out.println(p.val);
        }

    }

    // 输入一个数组，转换为一条单链表
    public static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }


}


