package homework.day27;

public class Demo1 {
    public static void main(String[] args) {
        Box<String> box = new Box<>();

        box.set("What can I say.Mamba out!");
        System.out.println("Kobe said:" + box.get());
    }
}

class Box<T> {
    private T content;

    public T get() {
        return content;
    }

    public void set(T t) {
        this.content = t;
    }
}
