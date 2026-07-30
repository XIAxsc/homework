package homework.Stage2.Day2_Git.Problem3;

import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<User> queryDB(Integer page, Integer size) throws SQLException {
        Connection connection = JDBCUtils.getConnection();

        connection.setAutoCommit(false);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from cskaoyan_user limit ? offset ?");

            preparedStatement.setInt(1, size);
            preparedStatement.setInt(2, (page - 1) * size);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<User> users = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("username");
                String password = resultSet.getString("password");
                int age = resultSet.getInt("age");
                Date birthday = resultSet.getDate("birthday");
                Date createDate = resultSet.getDate("create_date");
                String mobile = resultSet.getString("mobile");
                String address = resultSet.getString("address");
                users.add(new User(id, name, password, age, birthday, createDate, mobile, address));
            }

            connection.commit();

            JDBCUtils.closeConnection(resultSet, preparedStatement, connection);
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        }
        return null;
    }

    public static void insertSQL(User user) throws Exception {
        Connection connection = JDBCUtils.getConnection();
        connection.setAutoCommit(false);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into cskaoyan_user values (?,?,?,?,?,?,?,?)");

            preparedStatement.setInt(1, user.id);
            preparedStatement.setString(2, user.username);
            preparedStatement.setString(3, user.password);
            preparedStatement.setInt(4, user.age);
            preparedStatement.setDate(5, (Date) user.birthday);
            preparedStatement.setDate(6, (Date) user.create_date);
            preparedStatement.setString(7, user.mobile);
            preparedStatement.setString(8, user.address);

            int i = preparedStatement.executeUpdate();
            if (i >= 1) {
                System.out.println("插入数据成功！");
            } else System.out.println("插入数据失败！");

            connection.commit();

            JDBCUtils.closeConnection(null, preparedStatement, connection);
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        }

    }

    public static void insertSQLs(List<User> users) throws Exception {
        Connection connection = JDBCUtils.getConnection();

        connection.setAutoCommit(false);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into cskaoyan_user values (?,?,?,?,?,?,?,?)");

            for (User user : users) {
                preparedStatement.setInt(1, user.id);
                preparedStatement.setString(2, user.username);
                preparedStatement.setString(3, user.password);
                preparedStatement.setInt(4, user.age);
                preparedStatement.setDate(5, (Date) user.birthday);
                preparedStatement.setDate(6, (Date) user.create_date);
                preparedStatement.setString(7, user.mobile);
                preparedStatement.setString(8, user.address);

                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.commit();

            JDBCUtils.closeConnection(null, preparedStatement, connection);
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        }
    }

    public static void updateById(Integer id, String username) throws Exception {
        Connection connection = JDBCUtils.getConnection();
        connection.setAutoCommit(false);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update cskaoyan_user set username=? where id=?");

            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, id);

            int i = preparedStatement.executeUpdate();
            if (i >= 1) {
                System.out.println("更新数据成功！");
            } else System.out.println("更新数据失败！");

            connection.commit();

            JDBCUtils.closeConnection(null, preparedStatement, connection);
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        }
    }

    public static void deleteById(Integer id) throws Exception {
        Connection connection = JDBCUtils.getConnection();
        connection.setAutoCommit(false);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from cskaoyan_user where id=?");

            preparedStatement.setInt(1, id);

            int i = preparedStatement.executeUpdate();
            if (i >= 1) {
                System.out.println("删除数据成功！");
            } else System.out.println("删除数据失败！");

            connection.commit();

            JDBCUtils.closeConnection(null, preparedStatement, connection);
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        }
    }

    public static void main(String[] args) throws Exception {
        queryDB(2, 10).forEach(System.out::println);

        insertSQL(new User(11, "张三", "pass123", 25, new Date(95, 5, 15), new Date(System.currentTimeMillis()), "13800001111", "北京市朝阳区"));

        List<User> users = new ArrayList<>();

        // 添加10个User对象
        users.add(new User(1, "张三", "pass123", 25, new Date(95, 5, 15), new Date(System.currentTimeMillis()), "13800001111", "北京市朝阳区"));
        users.add(new User(2, "李四", "qwe456", 30, new Date(90, 2, 20), new Date(System.currentTimeMillis()), "13900002222", "上海市浦东新区"));
        users.add(new User(3, "王五", "abc789", 22, new Date(98, 8, 10), new Date(System.currentTimeMillis()), "13700003333", "广州市天河区"));
        users.add(new User(4, "赵六", "pwd321", 28, new Date(92, 11, 5), new Date(System.currentTimeMillis()), "13600004444", "深圳市南山区"));
        users.add(new User(5, "孙七", "hello99", 35, new Date(85, 3, 25), new Date(System.currentTimeMillis()), "13500005555", "杭州市西湖区"));
        users.add(new User(6, "周八", "test888", 26, new Date(94, 7, 12), new Date(System.currentTimeMillis()), "15800006666", "武汉市江汉区"));
        users.add(new User(7, "吴九", "admin123", 40, new Date(80, 9, 8), new Date(System.currentTimeMillis()), "15900007777", "南京市玄武区"));
        users.add(new User(8, "郑十", "love2026", 19, new Date(103, 0, 30), new Date(System.currentTimeMillis()), "18600008888", "成都市锦江区"));
        users.add(new User(9, "冯十一", "good666", 33, new Date(89, 6, 18), new Date(System.currentTimeMillis()), "18700009999", "重庆市渝中区"));
        users.add(new User(10, "陈十二", "happy321", 27, new Date(93, 4, 22), new Date(System.currentTimeMillis()), "18800001010", "西安市雁塔区"));
        insertSQLs(users);

        updateById(10, "陈平安");
        deleteById(11);
    }
}
