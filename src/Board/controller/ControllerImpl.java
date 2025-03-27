package Board.controller;

import Board.dto.dto;
import Board.service.service;
import Board.service.serviceImpl;

import java.util.List;
import java.util.Scanner;

public class ControllerImpl implements Controller {
    service svs = new serviceImpl();
    Scanner scan = new Scanner(System.in);

    @Override
    public void mainMenu() {
        munu();
        int choice = scan.nextInt();
        scan.nextLine();
        switch (choice) {
            case 1:
                insert();
                break;
            case 2:
                select();
                break;
            case 3:
                update();
                break;
            case 4:
                delete();
                break;
            case 5:
                selectAll();
                break;
            default:
                System.out.println("잘못입력함");
        }
    }

    @Override
    public void insert() {
        System.out.println("게시판 제목");
        String title = scan.nextLine();
        System.out.println("게시판 작성자");
        String writer = scan.nextLine();
        System.out.println("게시판 내용");
        String content = scan.nextLine();

        dto dto = new dto();
        dto.setBoard_title(title);
        dto.setBoard_writer(writer);
        dto.setBoard_content(content);
        svs.insert(dto);

        mainMenu();
    }

    @Override
    public void select() {
        System.out.println("검색할 게시판 아이디를 선택해주세요");
        int id = scan.nextInt();
        scan.nextLine();

        dto dto = new dto(id, null, null, null, null);
        dto read = svs.select(dto);
        System.out.println("아이디 : " + read.getBoard_id());
        System.out.println("제목 : " + read.getBoard_title());
        System.out.println("작성자 : " + read.getBoard_writer());
        System.out.println("게시판내용 : " + read.getBoard_content());
        System.out.println("작성날짜 : " + read.getBoard_date());

        mainMenu();
    }


    @Override
    public void update() {
        System.out.println("수정할 아이디를 선택해주세요");
        int id = scan.nextInt();
        scan.nextLine();

        System.out.println("새로운 제목 : ");
        String title = scan.nextLine();
        System.out.println("새로운 작성자");
        String writer = scan.nextLine();
        System.out.println("새로운 내용");
        String content = scan.nextLine();

        dto dto = new dto(id, title, writer, content, null);
        svs.update(dto);

        mainMenu();

    }

    @Override
    public void delete() {
        System.out.println("삭제할 아이디를 선택해주세요. ");
        int id = scan.nextInt();
        scan.nextLine();

        svs.delete(id);

        mainMenu();

    }

    public List<dto> selectAll() {
        List<dto> dto = svs.selectAll();
        System.out.println("전체 게시글");
        for (dto dto1 : dto) {
            System.out.println(dto1);
        }
        mainMenu();
        return dto;
    }

    public void munu() {
        System.out.println("메뉴");
        System.out.println("1. 게시글삽입");
        System.out.println("2. 게시글검색");
        System.out.println("3. 게시글수정");
        System.out.println("4. 게시글삭제");
        System.out.println("5. 게시글전체보기");
    }


    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        controller.mainMenu();
    }
}
