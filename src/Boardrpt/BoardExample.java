package Boardrpt;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.List;


public class BoardExample {
    // 출력용 날짜 포맷 (목록 출력에 사용)
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
    static Scanner scan = new Scanner(System.in);
    static List<Board> boards = new ArrayList<>();

    public static void main(String[] args) {
        BoardExample boardExample = new BoardExample();



        // 초기 게시물 2개
//        boards.add(setBno(1));
//        boardExample.boards[0].setBtitle("게시판에 오신 것을 환영합니다.");
//        boardExample.boards[0].setBcontent("");
//        boardExample.boards[0].setBwriter("winter");
//        boardExample.boards[0].setBdate(new Date());
//        boardExample.boardCount++;
//
//        boardExample.boards[1] = new Board();
//        boardExample.boards[1].setBno(2);
//        boardExample.boards[1].setBtitle("올 겨울은 많이 춥습니다.");
//        boardExample.boards[1].setBcontent("");
//        boardExample.boards[1].setBwriter("winter");
//        boardExample.boards[1].setBdate(new Date());
//        boardExample.boardCount++;

        Board board1 = new Board();
        board1.setBno(1);
        board1.setBtitle("게시판에 오신 것을 환영합니다.");
        board1.setBwriter("winter");
        board1.setBdate(new Date());
        boards.add(board1);

        Board board2 = new Board();
        board2.setBno(2);
        board2.setBtitle("올 겨울은 많이 춥습니다.");
        board2.setBwriter("winter");
        board2.setBdate(new Date());
        boards.add(board2);

        boardExample.list();
        boardExample.mainMenu();
    }

    // 게시물 목록

        // 게시물 목록 출력 (표 형태 정렬)
        public void list() {
            System.out.println("[게시물 목록]");
            System.out.println("---------------------------------------------------------");
            // 열 제목: 번호(No), 작성자(Writer), 날짜(Date), 제목(Title)
            System.out.printf("%-5s %-10s %-12s %-30s%n", "No", "Writer", "Date", "Title");
            System.out.println("---------------------------------------------------------");
            for (Board b : boards) {
                System.out.printf("%-5d %-10s %-12s %-30s%n",
                        b.getBno(),
                        b.getBwriter(),
                        dateFormat.format(b.getBdate()),
                        b.getBtitle().length() > 30 ? b.getBtitle().substring(0, 27) + "..." : b.getBtitle());
            }
            System.out.println("---------------------------------------------------------");
        }



    // 메인 메뉴
    public void mainMenu() {
        while (true) {
            System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
            System.out.print("메뉴 선택: ");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    Create();
                    break;
                case 2:
                    Read();
                    break;
                case 3:
                    Claer();
                    break;
                case 4:
                    Exit();
                    return;
                default:
                    System.out.println("1~4중 하나만 선택해주세요");
            }
        }
    }

    // 게시물 작성
    public void Create() {
        System.out.println("*** Create() 메소드 실행됨");
        System.out.println("[새 게시물 입력]");
        System.out.print("제목 : ");
        String title = scan.nextLine();
        System.out.print("내용 : ");
        String content = scan.nextLine();
        System.out.print("작성자 : ");
        String writer = scan.nextLine();
        System.out.println("--------------------------------------------------");
        System.out.println("보조 메뉴 : 1.Ok | 2.Cancel");
        int menu = scan.nextInt();
        scan.nextLine();

        if (menu == 1) {
            Board b = new Board();
            b.setBno(boards.size() + 1);
            b.setBtitle(title);
            b.setBcontent(content);
            b.setBwriter(writer);
            b.setBdate(new Date());
            boards.add(b);
        } else {
            System.out.println("게시물 등록이 취소되었습니다.");
        }
    }

    // [게시물 읽기] - 게시물 번호 입력 후 상세보기, 수정, 삭제, 목록 보기 선택
    public void Read() {
        System.out.println("*** Read() 메소드 실행됨");
        list();
        System.out.println("[게시물 읽기]");
        System.out.print("bno: ");
        int bno = scan.nextInt();
        scan.nextLine();

        if (bno < 1 || bno > boards.size()) {
            System.out.println("존재하지 않는 게시물 번호입니다.");
            return;
        }

        // Board 클래스의 toString()으로 상세 출력 (날짜는 toString()에서 포맷됨)
        System.out.println(boards.get(bno -1));
        System.out.println("1.Update | 2.Delete | 3.List");
        int choice = scan.nextInt();
        scan.nextLine();
        switch (choice) {
            case 1:
                Update(bno);
                break;
            case 2:
                Delete();
                break;
            case 3:
                list();
                break;
            default:
                System.out.println("1~3 숫자를 선택해주세요.");
        }
    }

    // [게시물 수정] : 수정할 게시물 번호(bno)를 매개변수로 받아 해당 게시물 수정
    public void Update(int bno) {
        Board b = boards.get(bno-1);
        System.out.println("[수정 내용 입력]");
        System.out.print("새 제목 : ");
        String title = scan.nextLine();
        System.out.print("새 내용 : ");
        String content = scan.nextLine();
        System.out.print("새 작성자 : ");
        String writer = scan.nextLine();
        System.out.println("--------------------------------------------------");
        System.out.println("보조 메뉴 : 1.Ok | 2.Cancel");
        int menu = scan.nextInt();
        scan.nextLine();

        if (menu == 1) {
            b.setBtitle(title);
            b.setBcontent(content);
            b.setBwriter(writer);
            b.setBdate(new Date());
            System.out.println("게시물이 수정되었습니다.");
        } else {
            System.out.println("수정이 취소되었습니다.");
        }
    }

    // 게시물 삭제
    public void Delete() {
        System.out.println("*** Delete() 메소드 실행됨");
        list();
        System.out.print("삭제할 게시물 번호: ");
        int bno = scan.nextInt();
        scan.nextLine();

        if (bno < 1 || bno > boards.size()) {
            System.out.println("존재하지 않는 게시물 번호입니다.");
            return;
        }

        System.out.println("보조 메뉴 : 1.Ok | 2.Cancel");
        int menu = scan.nextInt();
        scan.nextLine();

        if (menu == 1) {
            boards.remove(bno-1);

            for (int i = 0; i < boards.size(); i++) {
                boards.get(i).setBno(i + 1);
            }

            System.out.println("게시물이 삭제되었습니다.");
        } else {
            System.out.println("삭제가 취소되었습니다.");
        }
    }

    // 게시물 전체 삭제
    public void Claer() {
        System.out.println("*** Claer() 메소드 실행됨");
        System.out.println("[게시물 전체 삭제]");
        System.out.println("보조 메뉴 : 1.Ok | 2.Cancel");
        int choice = scan.nextInt();
        scan.nextLine();
        if (choice == 1) {
            for (int i = 0; i < boards.size(); i++) {
                boards.clear();
            }
            System.out.println("모든 게시물이 삭제되었습니다.");
        } else {
            System.out.println("게시물이 전체 삭제되지 않았습니다.");
        }
    }

    // 프로그램 종료
    public void Exit() {
        System.out.println("*** Exit() 메소드 실행됨");
        System.exit(0);
    }
}