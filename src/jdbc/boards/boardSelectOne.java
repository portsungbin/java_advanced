package jdbc.boards;

import jdbc.boards.Board;

import java.sql.*;

public class boardSelectOne {
    public static void main(String[] args) {
        Connection connection = null;
        ResultSet rs = null;

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



            String query = new StringBuilder()
                    .append(" SELECT * FROM boards ")
                    .toString();

            PreparedStatement pstmt = connection.prepareStatement(query);
            //pstmt.setString(1,"ssgcom1");

            // 4. SQL 실행
            rs = pstmt.executeQuery();

            if (rs.next()) {
                Board board = new Board();
                board.setBno(rs.getInt("bno"));
                board.setBtitle(rs.getString("btitle"));
                board.setBwriter(rs.getString("bwriter"));
                board.setBcontent(rs.getString("bcontent"));
                board.setBdate(rs.getDate("bdate"));
                board.setBfiledata(rs.getBlob("bfiledata"));
                board.setBfilename(rs.getString("bfilename"));
                System.out.println(board);
            } else {
                System.out.println("가입된 회원이 아닙니다.");
            }


            // 5. PreparedStatement 객체 닫기
            pstmt.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connection closed");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}