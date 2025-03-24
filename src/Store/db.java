package Store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {
    private static final String url = "jdbc:mysql://localhost:3306/store?serverTimezone=Asia/Seoul";
    private static final String user = "root";
    private static final String password = "tjdqlsdml456";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("드라이버 찾을 수 없음",e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
