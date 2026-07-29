package main.java.Day28;

import java.util.ArrayList;
import java.util.Date;

public class Demo7 {
    public static void main(String[] args) {
        OrderData order1 = new OrderData(1001, 120D, new Date(), Status.PAID);
        OrderData order2 = new OrderData(1002, 110D, new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 3), Status.UNPAID);
        OrderData order3 = new OrderData(1003, 1200D, new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 2), Status.SENT);
        OrderData order4 = new OrderData(1004, 1100D, new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24 * 3), Status.COMMENTED);
        OrderData order5 = new OrderData(1005, 1000D, new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24 * 2), Status.PAID);

        ArrayList<OrderData> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);
        System.out.println("orders:" + orders);

        Date earlyDate = orders.get(0).date;
        OrderData earlyOrder = orders.get(0);
        for (OrderData order : orders) {
            if (order.date.compareTo(earlyDate) < 0) {
                earlyDate = order.date;
                earlyOrder = order;
            }
        }
        System.out.println("时间最早的订单:" + earlyOrder);

        for (OrderData order : orders) {
            if (order.status == Status.PAID) {
                System.out.println("订单状态是已付款:" + order);
            }
        }

        for (OrderData order : orders) {
            if (order.price > 200 && order.status == Status.SENT) {
                System.out.println("订单金额超过200的，并且订单状态是已发货:" + order);
            }
        }
    }
}

class OrderData {
    Integer id;
    Double price;
    Date date;
    Status status;

    public OrderData() {
    }

    public OrderData(Integer id, Double price, Date date, Status status) {
        this.id = id;
        this.price = price;
        this.date = date;
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderData{" +
                "id=" + id +
                ", price=" + price +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}

enum Status {
    UNPAID,
    PAID,
    SENT,
    COMMENTED;
}
