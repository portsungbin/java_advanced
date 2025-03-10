package BoardPkg;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BoardExample {
    // 출력용 날짜 포맷 (목록 출력에 사용)
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
    Board[] boards = new Board[100];
    private int boardCount = 0;

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        BoardExample boardExample = new BoardExample();

        // 초기 게시물 2건 등록
        boardExample.boards[0] = new Board();
        boardExample.boards[0].setBno(1);
        boardExample.boards[0].setBtitle("게시판에 오신 것을 환영합니다.");
        boardExample.boards[0].setBcontent("");
        boardExample.boards[0].setBwriter("winter");
        boardExample.boards[0].setBdate(new Date());
        boardExample.boardCount++;

        boardExample.boards[1] = new Board();
        boardExample.boards[1].setBno(2);
        boardExample.boards[1].setBtitle("올 겨울은 많이 춥습니다.");
        boardExample.boards[1].setBcontent("");
        boardExample.boards[1].setBwriter("winter");
        boardExample.boards[1].setBdate(new Date());
        boardExample.boardCount++;

        boardExample.list();
    }

    // [게시물 목록] 출력
    public void list() {
        System.out.println("[게시물 목록]");
        System.out.println("--------------------------------------------------");
        System.out.println("no\twriter\tdate\t\ttitle");
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < boardCount; i++) {
            Board b = boards[i];
            System.out.println(
                    b.getBno() + "\t" +

                            b.getBwriter() + "\t" +
                            dateFormat.format(b.getBdate()) + "\t" +
                            b.getBtitle()
            );
        }
        System.out.println("--------------------------------------------------");
        mainMenu();
    }

    // [메인 메뉴] 처리
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

    // [게시물 작성]
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
            b.setBno(boardCount + 1);
            b.setBtitle(title);
            b.setBcontent(content);
            b.setBwriter(writer);
            b.setBdate(new Date());
            boards[boardCount] = b;
            boardCount++;
        } else {
            System.out.println("게시물 등록이 취소되었습니다.");
        }
    }

    // [게시물 읽기] - 게시물 번호 입력 후 상세보기, 수정, 삭제, 목록 보기 선택
    public void Read() {
        System.out.println("*** Read() 메소드 실행됨");
        System.out.println("[게시물 읽기]");
        System.out.print("bno: ");
        int bno = scan.nextInt();
        scan.nextLine();

        if (bno < 1 || bno > boardCount) {
            System.out.println("존재하지 않는 게시물 번호입니다.");
            return;
        }

        // Board 클래스의 toString()으로 상세 출력 (날짜는 toString()에서 포맷됨)
        System.out.println(boards[bno - 1]);
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
        Board b = boards[bno - 1];
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

    // [게시물 삭제] : 파라미터 없이 내부에서 삭제할 게시물 번호를 입력받아 삭제
    public void Delete() {
        System.out.println("*** Delete() 메소드 실행됨");
        System.out.print("삭제할 게시물 번호: ");
        int bno = scan.nextInt();
        scan.nextLine();

        if (bno < 1 || bno > boardCount) {
            System.out.println("존재하지 않는 게시물 번호입니다.");
            return;
        }

        System.out.println("보조 메뉴 : 1.Ok | 2.Cancel");
        int menu = scan.nextInt();
        scan.nextLine();

        if (menu == 1) {
            // 삭제할 게시물 인덱스(bno-1)부터 마지막 전까지 한 칸씩 앞으로 당기고, 게시물 번호 재설정
            for (int i = bno - 1; i < boardCount - 1; i++) {
                boards[i] = boards[i + 1];
                boards[i].setBno(i + 1);
            }
            // 마지막 인덱스 null 처리
            boards[boardCount - 1] = null;
            boardCount--;
            System.out.println("게시물이 삭제되었습니다.");
        } else {
            System.out.println("삭제가 취소되었습니다.");
        }
    }

    // [게시물 전체 삭제]
    public void Claer() {
        System.out.println("*** Claer() 메소드 실행됨");
        System.out.println("[게시물 전체 삭제]");
        System.out.println("보조 메뉴 : 1.Ok | 2.Cancel");
        int choice = scan.nextInt();
        scan.nextLine();
        if (choice == 1) {
            for (int i = 0; i < boardCount; i++) {
                boards[i] = null;
            }
            boardCount = 0;
            System.out.println("모든 게시물이 삭제되었습니다.");
        } else {
            System.out.println("게시물이 전체 삭제되지 않았습니다.");
        }
    }

    // [프로그램 종료]
    public void Exit() {
        System.out.println("*** Exit() 메소드 실행됨");
        System.exit(0);
    }
}