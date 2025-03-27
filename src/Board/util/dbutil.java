package Board.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class dbutil {
    private static ResourceBundle rb;

    static {
        rb = ResourceBundle.getBundle("Board.config.Config");

        try {
            Class.forName(rb.getString("driver"));
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    rb.getString("url"),
                    rb.getString("user"),
                    rb.getString("password")
            );
        } catch (SQLException e) {
            System.out.println("연결실패");
            return null;
        }
    }



}
