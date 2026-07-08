package algorithm.basicstructure.stack;

import java.util.ArrayList;

/**
 * 用动态数组实现栈
 *
 * @param <E> 栈结点值的数据类型
 */
public class MyArrayStack<E> {
    private final ArrayList<E> arr = new ArrayList<>();

    // 向栈内压入数据
    public void push(E e) {
        arr.add(e);
    }

    // 从栈顶弹出数据
    public E pop() {
        return arr.remove(arr.size() - 1);
    }

    // 查看栈顶元素
    public E peek() {
        return arr.get(arr.size() - 1);
    }

    // 返回栈中元素个数
    public int size() {
        return arr.size();
    }
}
