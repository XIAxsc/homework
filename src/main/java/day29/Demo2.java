package main.java.day29;

import java.util.ArrayList;
import java.util.Comparator;

public class Demo2 {

    public static void groupByCity1(ArrayList<User> users) {
        users.sort(Comparator.comparing(o -> o.city));
        System.out.println("-----------------------------\n用户按照城市进行分组：\n" + users);
    }

    public static void groupByCity(ArrayList<User> users, int[] index) {
        users.sort(Comparator.comparing(o -> o.city));
        System.out.println("-----------------------------\n用户按照城市进行分组：");
        String temp = "1";
        int j = 0;
        for (int i = 0; i < users.size(); i++) {
            if (!users.get(i).city.cityName.equals(temp)) {
                temp = users.get(i).city.cityName;
                index[j++] = i;
            }

        }
        ArrayList<User> city1 = new ArrayList<>(users.subList(0, index[1]));
        ArrayList<User> city2 = new ArrayList<>(users.subList(index[1], index[2]));
        ArrayList<User> city3 = new ArrayList<>(users.subList(index[2], users.size()));
        System.out.println("城市为" + users.get(0).city + "的用户列表：\n" + city1);
        System.out.println("城市为" + users.get(2).city + "的用户列表：\n" + city2);
        System.out.println("城市为" + users.get(4).city + "的用户列表：\n" + city3);
    }

    public static void avgAge(ArrayList<User> users, int index1, int index2) {
        Double totalAge = 0D;
        for (int i = index1; i < index2; i++) {
            totalAge += users.get(i).age;
        }
        Double avgAge = totalAge / (index2 - index1);
        System.out.println(users.get(index1).city.cityName + "的平均年龄：" + avgAge);
    }

    public static void findOldest(ArrayList<User> users, int index1, int index2) {
        Integer oldestAge = 0;
        User oldest = new User();
        for (int i = index1; i < index2; i++) {
            if (users.get(i).age > oldestAge) {
                oldest = users.get(i);
                oldestAge = users.get(i).age;
            }
        }
        System.out.println(oldest.city.cityName + "最老的人是：" + oldest);
    }


    public static void main(String[] args) {
        User user1 = new User("张三", 22, City.BEIJING);
        User user2 = new User("李四", 99, City.SHANGHAI);
        User user3 = new User("王五", 66, City.HUBEI);
        User user4 = new User("赵六", 55, City.HUBEI);
        User user5 = new User("咸鱼", 23, City.BEIJING);
        User user6 = new User("雪茄", 24, City.SHANGHAI);

        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        System.out.println("用户列表：\n" + users);

        int[] index = new int[]{0, 0, 0, users.size()};
        groupByCity(users, index);
        avgAge(users, index[0], index[1]);
        avgAge(users, index[1], index[2]);
        avgAge(users, index[2], index[3]);
        findOldest(users, index[0], index[1]);
        findOldest(users, index[1], index[2]);
        findOldest(users, index[2], index[3]);
    }
}

class User {
    String name;
    Integer age;
    City city;

    public User() {
    }

    public User(String name, Integer age, City city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city=" + city +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        return city == user.city;
    }

    @Override
    public int hashCode() {
        return city.hashCode();
    }
}

enum City {
    HUBEI("湖北"),
    BEIJING("北京"),
    SHANGHAI("上海");
    final String cityName;

    City(String cityName) {
        this.cityName = cityName;
    }
}
