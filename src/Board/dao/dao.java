package Board.dao;

import Board.dto.dto;

import java.util.List;

public interface dao {
    boolean insert(dto dto);
    boolean update(dto dto);
    boolean delete(int id);
    dto select(dto dto);
    List<dto> selectAll();

}
