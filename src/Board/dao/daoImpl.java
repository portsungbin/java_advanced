package Board.dao;

import Board.dto.dto;
import Board.util.dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class daoImpl implements dao {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    @Override
    public boolean insert(dto dto) {
        try {
            conn = dbutil.getConnection();
            String sql = "insert into noticeboard(board_title, board_writer, board_content) values(?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getBoard_title());
            pstmt.setString(2, dto.getBoard_writer());
            pstmt.setString(3, dto.getBoard_content());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return false;
    }

    @Override
    public boolean update(dto dto) {
        try {
            conn = dbutil.getConnection();
            String sql = "update noticeboard set board_title=?, board_writer=?, board_content=? where board_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getBoard_title());
            pstmt.setString(2, dto.getBoard_writer());
            pstmt.setString(3, dto.getBoard_content());
            pstmt.setInt(4, dto.getBoard_id());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            conn = dbutil.getConnection();
            String sql = "delete from noticeboard where board_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return false;
    }

    @Override
    public dto select(dto dto) {
        try {
            conn = dbutil.getConnection();
            String sql = "select * from noticeboard where board_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dto.getBoard_id());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                dto.setBoard_id(rs.getInt("board_id"));
                dto.setBoard_title(rs.getString("board_title"));
                dto.setBoard_writer(rs.getString("board_writer"));
                dto.setBoard_content(rs.getString("board_content"));
                dto.setBoard_date(rs.getDate("board_date"));
            } else {
                System.out.println("해당 게시글이 존재하지 않음");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return dto;
    }


    public List<dto> selectAll() {
        List<dto> list = new ArrayList<>();
        try {
            conn = dbutil.getConnection();
            String sql = "select * from noticeboard";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                dto dto = new dto();
                dto.setBoard_id(rs.getInt("board_id"));
                dto.setBoard_title(rs.getString("board_title"));
                dto.setBoard_writer(rs.getString("board_writer"));
                dto.setBoard_content(rs.getString("board_content"));
                dto.setBoard_date(rs.getDate("board_date"));
                list.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close();
        }
        return list;
    }

    public void close(){
        if(rs != null){
            try {
                pstmt.close();
            } catch (SQLException e) {
            }
            try {
                conn.close();
            } catch (SQLException e) {
            }
            try {
                rs.close();
            } catch (SQLException e) {
            }

        }
    }


}
