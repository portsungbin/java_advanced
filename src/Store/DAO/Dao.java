package Store.DAO;

import Store.DTO.Dto;
import Store.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
    public boolean insertfruit(Dto dto) {
        String sql =  "insert into fruit_shop values (?,?,?)";
        try(Connection conn = db.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dto.getFruit());
            pstmt.setInt(2, dto.getCount());
            pstmt.setInt(3, dto.getPrice());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deletefruit(String fruit) {
        String sql = "delete from fruit_shop where fruit = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, fruit);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updatefruit(Dto dto) {
        String sql =  "update fruit_shop set price = ? where fruit = ?";
        try(Connection conn = db.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, dto.getPrice());
            pstmt.setString(2, dto.getFruit());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Dto readfruit(Dto dto) {
        String sql =  "select * from fruit_shop where fruit = ?";
        try(Connection conn = db.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dto.getFruit());

            try(ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Dto result = new Dto(
                            rs.getString("fruit"),
                            rs.getInt("count"),
                            rs.getInt("price")
                    );
                    return result;
                }
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dto;
    }





}

