package Board.service;

import Board.dao.dao;
import Board.dao.daoImpl;
import Board.dto.dto;

import java.util.List;


public class serviceImpl implements service {
    dao dao = new daoImpl();

    @Override
    public boolean insert(dto dto) {
        return dao.insert(dto);
    }

    @Override
    public boolean update(dto dto) {
        return dao.update(dto);
    }

    @Override
    public boolean delete(int id) {
        return dao.delete(id);
    }

    @Override
    public dto select(dto dto) {
        return dao.select(dto);
    }

    @Override
    public List<dto> selectAll() {
        return dao.selectAll();
    }



}
