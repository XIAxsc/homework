package homework.day42_43;


import utils.JDBCUtils;

import java.sql.Connection;
import java.util.LinkedList;


public class MyConnectionPool {

    static LinkedList<Connection> pool;
    static int capacity = 10;

    // 初始化
    static {

        pool = new LinkedList<>();

        for (int i = 0; i < capacity; i++) {
            Connection connection = JDBCUtils.getConnection();
            pool.offerLast(connection);
        }
    }


    // 获取连接的方法
    public static Connection getConnection() {

        if (pool.isEmpty()) {
            grow();
        }
        Connection connection = pool.pollFirst();
        return connection;

    }

    // 双倍扩容
    public static void grow() {
        int old = capacity;
        capacity = old * 2;
        System.out.println("原容量：" + old + "， 正在扩容！\n" + "扩容后容量：" + capacity);
        for (int i = 0; i < capacity - old; i++) {
            Connection connection = JDBCUtils.getConnection();
            pool.offerLast(connection);
        }
    }


    // 返回连接的方法
    public static void returnConnection(Connection connection) {

        pool.offerFirst(connection);

    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            getConnection();
        }
    }

}

