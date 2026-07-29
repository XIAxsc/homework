package homework.day31.data;

import java.util.Objects;

public class Student {
    public enum Address {
        BJ, SH, WH, SZ
    }

    public Student(String name, int age, int height, Address address) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.address = address;
    }

    private String name;
    private int age;
    private int height;
    private Address address;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", address=" + address +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;

        if (age != student.age) return false;
        if (height != student.height) return false;
        if (!Objects.equals(name, student.name)) return false;
        return address == student.address;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + height;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
