package month2.day27;

public class Demo5 {
    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(0);
        head = head.createLinkedList(new Integer[]{0, 1, 2, 3, 4, 5});
        head.traverse(head);                                        // 遍历
        head = head.insertNode(head, 8, 0);             // 增加节点
        head.traverse(head);
        head.findByIndex(head, 4);                            // 查找索引4位置的值
        head.findByValue(head, 8);                               // 查找值为8的结点
        head.updateValue(head, 6, 9);                     // 修改index索引节点的值
        head.traverse(head);
        head.deleteNode(head, 4);                              // 按索引删除节点
        head.traverse(head);
    }
}

class ListNode<T> {
    public T val;             // 值
    public ListNode<T> next;       // 指针指向下一个节点

    public ListNode(T val) {
        this.val = val;
    }

    /**
     * 传入数组，创建单链表
     */
    public ListNode<T> createLinkedList(T[] arr) {
        // 如果arr不指向数组，或者数组为空，创建单链表失败（边界条件判定）
        if (arr == null || arr.length == 0) {
            System.out.println("创建单链表失败。");
            return null;
        }
        // 创建头结点
        ListNode<T> head = new ListNode<T>(arr[0]);
        // 创建temp节点指向head
        ListNode<T> temp = head;
        // for循环从下标1开始逐个给节点赋值
        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode<T>(arr[i]);
            temp = temp.next;
        }
        // 返回头结点
        return head;
    }

    /**
     * 遍历单链表
     */
    public void traverse(ListNode<T> head) {
        System.out.println("遍历当前单链表：");
        // 创建p指针指向头结点，挨个向后遍历链表节点并打印节点value
        for (ListNode<T> p = head; p != null; p = p.next) {
            System.out.print(p.val + " ");
        }
        System.out.println();
    }

    /**
     * 按值查找返回节点
     */
    public ListNode<T> findByValue(ListNode<T> head, T val) {
        int index = 0;
        for (ListNode<T> p = head; p != null; p = p.next, index++) {
            if (p.val == val) {
                System.out.println("找到的节点索引为" + index);
                return p;
            }
        }
        System.out.println("未找到该值对应的节点！");
        return null;
    }

    /**
     * 按索引查找节点
     */
    public ListNode<T> findByIndex(ListNode<T> head, int index) {
        ListNode<T> p = head;
        for (int i = 0; i <= index && p != null; p = p.next, i++) {
            if (i == index) {
                System.out.println("索引" + index + "位置的值为" + p.val);
                return p;
            }
        }
        System.out.println("未找到该值对应的节点！");
        return null;
    }

    /**
     * 在第index节点后插入节点
     *
     * @param head  头结点
     * @param value 新增结点的值
     * @param index 新增结点的前一个位置
     */
    public ListNode<T> insertNode(ListNode<T> head, T value, int index) {
        ListNode<T> p = head;
        if (index == 0) {
            ListNode<T> newNode = new ListNode<>(value);
            newNode.next = p;
            p = newNode;
            return p;
        } else {// 循环找到index节点
            for (int i = 0; i < index - 1; i++) {
                p = p.next;
            }
            ListNode<T> newNode = new ListNode<T>(value);
            newNode.next = p.next;
            p.next = newNode;
            return head;
        }
    }

    /**
     * 删除index节点后的结点
     */
    public void deleteNode(ListNode<T> head, int index) {
        ListNode<T> p = head;
        // 循环找到index节点
        for (int i = 0; i < index - 1; i++) {
            p = p.next;
        }
        p.next = p.next.next;
    }

    /**
     * 改变第index位置的结点的值
     */
    public void updateValue(ListNode<T> head, int index, T value) {
        ListNode<T> p = head;
        for (int i = 0; i <= index && p != null; p = p.next, i++) {
            if (i == index) {
                p.val = value;
            }
        }
    }
}