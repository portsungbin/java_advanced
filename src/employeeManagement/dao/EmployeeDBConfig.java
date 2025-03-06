package employeeManagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeeDBConfig {
    private static final String URL = "jdbc:mysql://localhost:3306/ssgdb?serverTimezone=Asia/Seoul";
    private static final String USER = "ssg";
    private static final String PASSWORD = "ssg1234";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL 드라이버 로드 성공");
        } catch (ClassNotFoundException e) {
            System.err.println("드라이버 로드 실패");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
