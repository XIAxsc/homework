package month2.day27;

public class Demo2 {
    public static void main(String[] args) {
        System.out.println("new IntegerGenerator() = " + new IntegerGenerator().next());
    }
}

interface Generator<T> {
    T next();
}

class IntegerGenerator implements Generator<Integer> {
    @Override
    public Integer next() {
        for (int i = 0; i <= 114514; i++) {
            System.out.println("i = " + i);
        }
        return 1;
    }
}
