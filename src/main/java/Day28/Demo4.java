package Day28;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class Demo4 {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
        Order order1 = new Order("zs", new BigDecimal("1000"), now.getTime());
        Order order2 = new Order("ls", new BigDecimal("2000"), new Date());
        now.set(2022, 2, 3);
        Order order3 = new Order("ww", new BigDecimal("100"), now.getTime());
        now.set(2023, 1, 3);
        Order order4 = new Order("zl", new BigDecimal("1010"), now.getTime());
        now.set(2022, 9, 9);
        Order order5 = new Order("tq", new BigDecimal("10120"), now.getTime());
        now.add(Calendar.YEAR, 2);
        Order order6 = new Order("hh", new BigDecimal("10"), now.getTime());

        ArrayList<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);
        orders.add(order6);

        BigDecimal max = new BigDecimal("0");
        Order maxPrice = new Order();
        for (Order order : orders) {
            if (max.compareTo(order.price) < 0) {
                max = order.price;
                maxPrice = order;
            }
        }
        System.out.println("最大的下单金额对应的下单人是" + maxPrice.name);

        System.out.println("2022-2023年下单的所有订单信息:");
        Calendar first = Calendar.getInstance();
        Calendar second = Calendar.getInstance();
        first.set(2022, 1, 1);
        second.set(2023, 1, 1);
        Date date1 = first.getTime();
        Date date2 = second.getTime();
        for (Order order : orders) {
            if (order.date.compareTo(date1) >= 0 && order.date.compareTo(date2) < 0) {
                System.out.println("order = " + order);
            }
        }

        BigDecimal total = new BigDecimal("0");
        for (Order order : orders) {
            total = total.add(order.price);
        }
        int totalPrice = total.intValue();
        double avg = totalPrice / 6D;

        System.out.println("删除之前的订单信息:" + orders);
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().price.doubleValue() < avg) {
                iterator.remove();
            }
        }
        System.out.println("删除之后的订单信息：" + orders);
    }
}

class Order {
    String name;
    BigDecimal price;
    Date date;

    public Order() {
    }

    public Order(String name, BigDecimal price, Date date) {
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
