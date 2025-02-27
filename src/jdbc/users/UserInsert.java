package jdbc.users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserInsert {
    public static void main(String[] args) {
        Connection connection = null;

        // 1. JDBC 드라이버 등록 : MySQL DB 접근 하기 위한 드라이버 등록

        try {
            // forName 은 try-catch 필수
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded ok " + connection);


            // 2. MySQL DB에 연결객체를 얻어와서 연결하기
            // getConnection 은 try-catch 필수
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ssgdb?serverTimezone=Asia/Seoul", "ssg", "ssg1234");
            System.out.println("Connection ok " + connection);

            // 3. 매개변수화된 SQL 문 작성
            String query = ""+
                    "INSERT INTO users (userid,username,userpassword,userage,useremail)" +
                    "VALUES(?,?,?,?,?)";

            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1,"1");
            pstmt.setString(2,"서유미");
            pstmt.setString(3,"1234");
            pstmt.setInt(4,30);
            pstmt.setString(5,"서유미@gmail.com");

            // 4. SQL 실행
            int rows = pstmt.executeUpdate();
            System.out.println(rows + "rows inserted");
            // 5. PreparedStatement 객체 닫기
            pstmt.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(connection != null){
                try {
                    connection.close();
                    System.out.println("Connection closed");
                } catch (SQLException e) {e.printStackTrace();}
            }
        }


    }
}