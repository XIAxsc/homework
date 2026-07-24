package month2.Day40;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Demo1 {
    static String url;
    static String username;
    static String password;
    static String driverClass;

    static {
        Properties properties = new Properties();

        try {
            properties.load(new FileReader("jdbc.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        driverClass = properties.getProperty("class");

    }

    public static void main(String[] args) throws Exception {
        Class.forName(driverClass);

        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();

        // 1.请查出每个导师所带研究生的姓名。
        ResultSet rs1 = statement.executeQuery("select s.name,gs.name from supervisor as s  left join graduate_student as gs on s.id = gs.supervisor_id;");

        System.out.println("----------查出每个导师所带研究生的姓名----------\n");

        while (rs1.next()) {
            String sName1 = rs1.getString("s.name");
            String gsName1 = rs1.getString("gs.name");
            System.out.println("导师姓名：" + sName1 + "，研究生姓名：" + gsName1);
        }


        // 2.清查出特定姓名的导师所带研究生的姓名。
        ResultSet rs2 = statement.executeQuery("select s.name,gs.name from supervisor as s  left join graduate_student as gs on s.id = gs.supervisor_id where s.name = '李秀英'");

        System.out.println("\n----------查出李秀英导师所带研究生的姓名----------\n");
        while (rs2.next()) {
            String sName2 = rs2.getString("s.name");
            String gsName2 = rs2.getString("gs.name");
            System.out.println("导师姓名：" + sName2 + "，研究生姓名：" + gsName2);
        }

        // 3.请查出每个导师所带研究生的数量。
        ResultSet rs3 = statement.executeQuery("select s.name,count(gs.id) from supervisor as s  left join graduate_student as gs on s.id = gs.supervisor_id group by s.id,s.name;");

        System.out.println("\n----------查出每个导师所带研究生的数量----------\n");

        while (rs3.next()) {
            String sName3 = rs3.getString("s.name");
            int countId3 = rs3.getInt("count(gs.id)");
            System.out.println("导师姓名：" + sName3 + "，研究生数量：" + countId3);
        }

        // 4.请查出每个导师所带的男研究生的数量。
        ResultSet rs4 = statement.executeQuery("select s.name,count(gs.id) from supervisor as s  left join graduate_student as gs on s.id = gs.supervisor_id and gs.gender = '男' group by s.id,s.name");

        System.out.println("\n----------查出每个导师所带男研究生的数量----------\n");

        while (rs4.next()) {
            String sName4 = rs4.getString("s.name");
            int countId4 = rs4.getInt("count(gs.id)");
            System.out.println("导师姓名：" + sName4 + "，男研究生数量：" + countId4);
        }

        // 5.请找出选择哪个研究方向的导师最多。
        ResultSet rs5 = statement.executeQuery("select research_area,count(s.id) from supervisor as s group by research_area order by count(s.id) desc limit 1;");

        System.out.println("\n----------选择哪个研究方向的导师最多----------\n");

        while (rs5.next()) {
            String researchArea5 = rs5.getString("research_area");
            int countId5 = rs5.getInt("count(s.id)");
            System.out.println("研究方向：" + researchArea5 + "，导师数量：" + countId5);
        }

        // 6.请找统计不同职称的导师的个数。
        ResultSet rs6 = statement.executeQuery("select sp.professional_title,count(sp.id) from supervisor as sp group by sp.professional_title;");

        System.out.println("\n----------统计不同职称的导师的个数----------\n");

        while (rs6.next()) {
            String professionalTitle6 = rs6.getString("sp.professional_title");
            int countId6 = rs6.getInt("count(sp.id)");
            System.out.println("职称：" + professionalTitle6 + "，导师数量：" + countId6);
        }

        rs1.close();
        rs2.close();
        rs3.close();
        rs4.close();
        rs5.close();
        rs6.close();
        statement.close();
        connection.close();
    }
}
