package test.month2.generics.generics_interface;

public class User<T> {
    String name;
    T data;

    public String getName() {
        return name;
    }

    public T getData() {
        return data;
    }
}
