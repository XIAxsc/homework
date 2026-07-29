package main.java.Day28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class Demo1 {
    public static void main(String[] args) {
        User user1 = new User(0);
        User user2 = new User(1);
        User user3 = new User(1);
        User user4 = new User(5);
        User user5 = new User(5);
        User user6 = new User(8);
        User user7 = new User(10);

        Collection<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);

        System.out.println("users = " + users);

        Iterator<User> iterator = users.iterator();
        ArrayList<User> newUsers = new ArrayList<>();
        while (iterator.hasNext()) {
            User element = iterator.next();
            int flag = 0;
            for (User newUser : newUsers) {
                if (Objects.equals(newUser.value, element.value)) {
                    // iterator.remove();
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                newUsers.add(element);
            }
        }
        System.out.println("newUsers = " + newUsers);
    }
}

class User {
    Integer value;

    public User(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "User{" +
                "value=" + value +
                '}';
    }
}
