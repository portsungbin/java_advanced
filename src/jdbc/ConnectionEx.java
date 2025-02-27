package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionEx {
    public static void main(String[] args){
        Connection connection = null;

        // 1. JDBC 드라이버 등록 : MYSQL DB 접근 하기 위한 드라이버 등록
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded ok!" + connection);

            // 2. Mysql DB에 연결객체를 얻어와서 연결하기
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssgdb?serverTimezone=Asia/Seoul","ssg","ssg1234");
            System.out.println("Connection OK" + connection);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (connection != null) {
                try{
                    connection.close();
                    System.out.println("connection closed");
                }catch (SQLException e){ e.printStackTrace();}

            }
        }
    }
}
