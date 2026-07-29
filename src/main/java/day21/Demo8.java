package main.java.day21;

import java.io.*;
import java.util.Arrays;

public class Demo8 {
    private static void objectSerialize(String path, User user) throws Exception{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path, true));
        out.writeObject(user);
        out.write("\n".getBytes());
        out.close();
    }

    private static void objectUnSerialize(String path) throws Exception{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));

        User user = (User) in.readObject();
        in.close();
        System.out.println(user);

    }

    private static void objectsSerialize(String path, User[] users) throws Exception{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path, true));
        out.writeObject(users);
        out.write("\n".getBytes());
        out.close();
    }

    private static void objectsUnSerialize(String path) throws Exception{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));

        User[] users = (User[]) in.readObject();
        in.close();
        System.out.println(Arrays.toString(users));

    }


    public static void main(String[] args) throws Exception {
        String path1 = "testjava/h1.txt";
        String path2 = "testjava/h2.txt";
        Address address = new Address("武汉市", "100");
        User user1 = new User(1, "张三", "华为", address);
        User user2 = new User(2, "李四", "小米", address);
        User user3 = new User(3, "王五", "OPPO", address);
        User user4 = new User(4, "赵六", "vivo", address);
        User[] users = new User[]{user1, user2, user3, user4};

        objectSerialize(path1,user1);
        objectUnSerialize(path1);
        objectsSerialize(path2,users);
        objectsUnSerialize(path2);


    }
}

class User implements Serializable {
    int id;
    String name;
    String mobile;
    Address address;

    public User(int id, String name, String mobile, Address address) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address=" + address +
                '}';
    }
}

class Address implements Serializable {
    String detail;
    String code;

    public Address(String detail, String code) {
        this.detail = detail;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Address{" +
                "detail='" + detail + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
