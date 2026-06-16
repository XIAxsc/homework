package algorithm.basicstructure.array;


public class DynamicArray<E> {
    private  E[] data;
    private int size;
    private  static  final int INIT_CAP = 1;

    public DynamicArray() {
        this(INIT_CAP);
    }

    public  DynamicArray(int initCapacity) {
        data = (E[]) new Object[initCapacity];
        size = 0;

    }

    public void addList(E e) {
        int cap = data.length;
        if (size == cap) {
             //resize(2 * cap);
         }
        data[size] = e;
        size++;
    }



    public static void main(String[] args){

    }

}
