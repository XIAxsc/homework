package homework.Day28;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Demo2 {
    public static void main(String[] args) {
        User user1 = new User(0);
        User user2 = new User(1);
        User user3 = new User(1);
        User user4 = new User(5);
        User user5 = new User(5);
        User user6 = new User(8);
        User user7 = new User(10);

        ArrayList<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        list.add(user6);
        list.add(user7);

        System.out.println("list = " + list);

        ListIterator<User> iterator = list.listIterator();
        List<User> newList = new ArrayList<>();
        while (iterator.hasNext()) {
            User element = iterator.next();
            int flag = 0;
            for (int i = 0; i < newList.size(); i++) {
                if (element.value.equals(list.get(i).value)) {
                    flag = 1;
                    // iterator.remove();
                    break;
                }
            }
            if (flag == 0) {
                newList.add(element);
            }
        }
        System.out.println("newList = " + newList);

    }
}
