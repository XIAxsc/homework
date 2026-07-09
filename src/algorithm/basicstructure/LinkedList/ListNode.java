package algorithm.basicstructure.LinkedList;


/**
 *  自定义单链表
 * <p>
 *  createLinkedList(int[] arr)                             传入一个数组，创建单链表
 *  traverse(ListNode head)                                 传入链表的一个结点，从该结点开始依次向后遍历
 *  insertTail(ListNode head, int value)                    传入链表头结点和一个int类型值value，在链表结尾新增值为value的结点
 *  insertMiddle(ListNode head, int value, int index)       在第index节点之后插入值为value的新结点
 *
 */
public class ListNode {
    public int val;             // 值
    public ListNode next;       // 指针指向下一个节点

    public ListNode(int x) {
        this.val = x;
    }

    /**
     * 传入数组，创建单链表
     */
    public static ListNode createLinkedList(int[] arr) {
        // 如果arr不指向数组，或者数组为空，创建单链表失败（边界条件判定）
        if (arr == null || arr.length == 0) {
            System.out.println("创建单链表失败。");
            return null;
        }
        // 创建头结点
        ListNode head = new ListNode(arr[0]);
        // 创建temp节点指向head
        ListNode temp = head;
        // for循环从下标1开始逐个给节点赋值
        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        // 返回头结点
        return head;
    }

    /**
     * 遍历单链表
     */
    public static void traverse(ListNode head) {
        System.out.println("遍历当前单链表：");
        // 创建p指针指向头结点，挨个向后遍历链表节点并打印节点value
        for (ListNode p = head; p != null; p = p.next) {
            System.out.print(p.val + " ");
        }
        System.out.println();
    }


    /**
     * 在单链表表尾插入新的节点
     *
     * @param head  头结点
     * @param value 新增结点的值
     */
    public static void insertTail(ListNode head, int value) {
        // 指针p指向头结点
        ListNode p = head;
        // p节点下一个节点非空，p往下走，下一个节点为空说明走到链表尾
        while (p.next != null) {
            p = p.next;
        }
        // 创捷新尾节点
        p.next = new ListNode(value);
    }

    /**
     * 在第index节点后插入节点
     *
     * @param head  头结点
     * @param value 新增结点的值
     * @param index 新增结点的前一个位置
     */
    public static void insertMiddle(ListNode head, int value, int index) {
        ListNode p = head;
        // 循环找到index节点
        for (int i = 0; i < index - 1; i++) {
            p = p.next;
        }
        ListNode newNode = new ListNode(value);
        newNode.next = p.next;
        p.next = newNode;
    }

    public static void main(String[] args) {
        ListNode head = createLinkedList(new int[]{1, 2, 3, 4, 5}); // 创建单链表
        traverse(head);                                             // 遍历

        insertTail(head, 6);
        insertMiddle(head, 0, 3);

        traverse(head);
    }
}