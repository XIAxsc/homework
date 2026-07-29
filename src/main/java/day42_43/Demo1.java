package day42_43;

import utils.JDBCUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo1 {

    static String logFile = "testjava/month2/day42/log.txt";

    private static void writeLogs(String s) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
            long now = System.currentTimeMillis();
            Date date = new Date(now);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
            String format = dateFormat.format(date);
            writer.write("[" + format + "] ");
            writer.write(s);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void transfer(String from, String to, float money) {
        Connection connection = JDBCUtils.getConnection();

        try {
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement1 = connection.prepareStatement("select money from account_t where name = ?");
            preparedStatement1.setString(1, from);
            ResultSet resultSet = preparedStatement1.executeQuery();
            float fromMoney = 0;
            if (resultSet == null) {
                String s = "转账失败！转账账户用户名错误！";
                writeLogs(s);
                throw new RuntimeException(s);
            } else {
                resultSet.next();
                fromMoney = resultSet.getFloat("money");
                if (fromMoney < money) {
                    String s = "转账失败！账户余额不足";
                    writeLogs(s);
                    throw new RuntimeException(s);
                }
            }
            PreparedStatement preparedStatement2 = connection.prepareStatement("update account_t set money=money - ? where name = ? and money >= ?");
            preparedStatement2.setFloat(1, money);
            preparedStatement2.setString(2, from);
            preparedStatement2.setFloat(3, money);
            preparedStatement2.executeUpdate();

            PreparedStatement preparedStatement3 = connection.prepareStatement("update account_t set money=money + ? where name = ?");
            preparedStatement3.setFloat(1, money);
            preparedStatement3.setString(2, to);
            preparedStatement3.executeUpdate();

            int affectedRows = preparedStatement3.executeUpdate();
            if (affectedRows < 1) {
                String s = "转账失败！收款帐户用户名错误！";
                writeLogs(s);
                throw new RuntimeException(s);
            }

            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }

        String s = "转账成功";
        writeLogs(s);

    }

    public static void main(String[] args) {
        transfer("张三", "李四", 20000);
        transfer("王五", "李四", 20000);
    }
}
