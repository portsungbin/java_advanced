package jdbc.homework.boards;



import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BoardDao {
    Scanner sc = new Scanner(System.in);

    // DB에 저장된 현재 최대 bno 값을 조회해 다음 번호를 결정
    public int getNextBno() {
        int nextBno = 1;
        String sql = "SELECT MAX(bno) FROM board";
        try (Connection conn = DBConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                nextBno = rs.getInt(1) + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nextBno;
    }

    public void list() {
        System.out.println("[게시물 목록]");
        System.out.println("------------------------------------------");
        System.out.printf("%-10s %-15s %-20s %-40s\n", "no", "writer", "date", "title");
        System.out.println("------------------------------------------");

        readAll();
        mainMenu();
    }

    public void mainMenu() {
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
        System.out.println("---------------------------------");
        System.out.print("메뉴 선택: ");
        String menuNo = sc.nextLine();
        System.out.println();

        switch (menuNo) {
            case "1" -> create();
            case "2" -> read();
            case "3" -> clear();
            case "4" -> exit();
            default -> {
                System.out.println("잘못된 입력입니다.");
                mainMenu();
            }
        }
    }

    public void create() {
        System.out.println("[새 게시물 입력]");
        Board board = new Board();
        board.setBno(getNextBno());
        System.out.print("제목: ");
        board.setBtitle(sc.nextLine());
        System.out.print("내용: ");
        board.setBcontent(sc.nextLine());
        System.out.print("작성자: ");
        board.setBwriter(sc.nextLine());
        board.setBdate(getCurrentDate());

        System.out.println("-----------------------------------");
        System.out.println("보조 메뉴: 1. Ok | 2. Cancel");
        System.out.print("메뉴 선택: ");
        String menuNo = sc.nextLine();
        if (menuNo.equals("1")) {
            String sql = "INSERT INTO board (bno, btitle, bcontent, bwriter, bdate) VALUES (?, ?, ?, ?, ?)";
            try (Connection conn = DBConfig.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, board.getBno());
                pstmt.setString(2, board.getBtitle());
                pstmt.setString(3, board.getBcontent());
                pstmt.setString(4, board.getBwriter());
                pstmt.setString(5, board.getBdate());
                int result = pstmt.executeUpdate();
                if (result > 0) {
                    System.out.println("게시물이 등록되었습니다.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("등록 취소됨.");
        }
        list();
    }

    public void read() {
        System.out.println("[게시물 읽기]");
        System.out.print("bno: ");
        int bno = Integer.parseInt(sc.nextLine());

        String query = "SELECT * FROM board WHERE bno = ?";

        try (Connection conn = DBConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, bno);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Board board = new Board();
                    board.setBno(rs.getInt("bno"));
                    board.setBtitle(rs.getString("btitle"));
                    board.setBcontent(rs.getString("bcontent"));
                    board.setBwriter(rs.getString("bwriter"));
                    board.setBdate(rs.getString("bdate"));

                    System.out.println("##########");
                    System.out.println("번호: " + board.getBno());
                    System.out.println("제목: " + board.getBtitle());
                    System.out.println("내용: " + board.getBcontent());
                    System.out.println("작성자: " + board.getBwriter());
                    System.out.println("날짜: " + board.getBdate());
                    System.out.println("##########");
                } else {
                    System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
                }
            }

            System.out.println("---------------------------");
            System.out.println("보조 메뉴: 1. Update | 2.Delete | 3. List");
            System.out.print("메뉴 선택: ");
            String tmp = sc.nextLine();
            switch (tmp) {
                case "1" -> update(bno);
                case "2" -> delete(bno);
                case "3" -> list();
                default -> list();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // DB에서 모든 게시물 조회 후 출력
    public void readAll() {
        String query = "SELECT * FROM board ORDER BY bno";
        try (Connection conn = DBConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int bno = rs.getInt("bno");
                String btitle = rs.getString("btitle");
                String bwriter = rs.getString("bwriter");
                String bdate = rs.getString("bdate");
                System.out.printf("%-10s %-15s %-20s %-40s\n", bno, bwriter, bdate, btitle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void clear() {
        System.out.println("[게시물 전체 삭제]");
        System.out.println("------------------");
        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        String tmp = sc.nextLine();
        if (tmp.equals("1")) {
            String sql = "DELETE FROM board";
            try (Connection conn = DBConfig.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                int result = pstmt.executeUpdate();
                if (result >= 0) {
                    System.out.println("전체 게시물이 삭제되었습니다.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        list();
    }

    public void exit() {
        System.out.println("** 게시판 종료 **");
        System.exit(0);
    }

    public String getCurrentDate() {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        return date.format(new Date());
    }

    public void update(int bno) {
        System.out.println("[수정 내용 입력]");
        System.out.print("새 제목: ");
        String changeTitle = sc.nextLine();
        System.out.print("새 내용: ");
        String changeContent = sc.nextLine();
        System.out.print("새 작성자: ");
        String changeWriter = sc.nextLine();

        System.out.println("보조 메뉴: 1. Ok | 2. Cancel");
        System.out.print("메뉴 선택: ");
        String tmp = sc.nextLine();
        if (tmp.equals("1")) {
            String sql = "UPDATE board SET btitle = ?, bcontent = ?, bwriter = ? WHERE bno = ?";
            try (Connection conn = DBConfig.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, changeTitle);
                pstmt.setString(2, changeContent);
                pstmt.setString(3, changeWriter);
                pstmt.setInt(4, bno);
                int result = pstmt.executeUpdate();
                if (result > 0) {
                    System.out.println("게시물이 수정되었습니다.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("수정 취소됨.");
        }
        list();
    }

    public void delete(int bno) {
        System.out.println("정말 삭제하시겠습니까? (Y/N)");
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("Y")) {
            String sql = "DELETE FROM board WHERE bno = ?";
            try (Connection conn = DBConfig.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, bno);
                int result = pstmt.executeUpdate();
                if (result > 0) {
                    System.out.println("게시물이 삭제되었습니다.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("삭제 취소됨.");
        }
        list();
    }
}
