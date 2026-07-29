package main.java.algorithm.basicstructure.stack;

import java.util.LinkedList;

/**
 * 链表实现栈
 *
 * @param <E> 栈中存的数据类型
 */
public class MyLinkedStack<E> {
    private final LinkedList<E> list = new LinkedList<>();

    // 向栈顶加入元素，时间复杂度O(1)
    public void push(E e) {
        list.addLast(e);
    }

    // 从栈顶弹出元素，时间复杂度O(1)
    public E pop() {
        return list.removeLast();
    }

    // 查找栈顶元素，时间复杂度O(1)
    public E peek() {
        return list.peekLast();
    }

    // 返回栈中元素的个数，时间复杂度O(1)
    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyLinkedStack<Integer> stack = new MyLinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
