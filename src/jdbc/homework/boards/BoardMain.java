package jdbc.homework.boards;

public class BoardMain {
    public static void main(String[] args) {
        BoardDao boardDao = new BoardDao();
        boardDao.list();
    }
}
