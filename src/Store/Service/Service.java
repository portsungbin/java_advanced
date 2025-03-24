package Store.Service;


import Store.DAO.Dao;
import Store.DTO.Dto;

public class Service {

    private Dao dao =  new Dao();

    public boolean insertfruitcheck(Dto dto) {
        return dao.insertfruit(dto);
    }

    public boolean deletefruit(String fruit) {
        return dao.deletefruit(fruit);
    }

    public boolean updatefruit(Dto dto) {
        return dao.updatefruit(dto);
    }

    public Dto readfruit(Dto dto) {
        return dao.readfruit(dto);
    }

}
