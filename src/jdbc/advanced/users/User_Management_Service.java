package jdbc.advanced.users;

import java.sql.*;
import java.util.Scanner;

/**
 * 테이블 구조 (users):
 *   userId (문자열, PK)
 *   username (문자열)
 *   userpassword (문자열)
 *   phonenumber (문자열)
 *   address (문자열)
 */
public class User_Management_Service {

    private Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        new User_Management_Service().memberStart();
    }

    // 메인 메뉴
    private int displayMenu() {
        System.out.println();
        System.out.println("== 작업 선택 ==");
        System.out.println("1. 자료 추가");
        System.out.println("2. 자료 삭제");
        System.out.println("3. 자료 수정 (전체 항목)");
        System.out.println("4. 전체 자료 출력");
        System.out.println("5. 자료 수정 (원하는 항목만)");
        System.out.println("0. 작업 끝.");
        System.out.println("==================");
        System.out.print("원하는 작업 선택 >> ");
        return scan.nextInt();
    }

    // 메인 로직
    public void memberStart() {
        while (true) {
            int choice = displayMenu();
            switch (choice) {
                case 1: // 추가
                    insertMember();
                    break;
                case 2: // 삭제
                    deleteMember();
                    break;
                case 3: // 전체 항목 수정
                    updateMember();
                    break;
                case 4: // 전체 자료 출력
                    displayMember();
                    break;
                case 5: // 원하는 항목만 수정
                    updateMember2();
                    break;
                case 0: // 종료
                    System.out.println("작업을 마칩니다.");
                    return;
                default:
                    System.out.println("번호를 잘못 입력했습니다. 다시 입력하세요.");
            }
        }
    }

    // ─────────────────────────────────────────────────────────────
    // (1) 회원 정보를 추가하는 메서드
    // ─────────────────────────────────────────────────────────────
    private void insertMember() {
        Connection conn = null;
        PreparedStatement pstmt = null;

        System.out.println();
        System.out.println("추가할 회원 정보를 입력하세요.");

        // 중복 확인
        int count = 0;
        String memId = null;
        do {
            System.out.print("회원ID >> ");
            memId = scan.next();
            count = getMemberCount(memId); // 이미 등록된 ID인지 확인
            if (count > 0) {
                System.out.println(memId + "은(는) 이미 등록된 회원ID입니다.");
                System.out.println("다른 회원ID를 입력하세요.");
            }
        } while (count > 0);

        System.out.print("회원이름 >> ");
        String memName = scan.next();

        System.out.print("비밀번호 >> ");
        String memPass = scan.next();

        System.out.print("전화번호 >> ");
        String memPhone = scan.next();

        scan.nextLine();  // 입력 버퍼 비우기
        System.out.print("주소 >> ");
        String memAddr = scan.nextLine();

        try {
            conn = DBUtil.getConnection();
            // 컬럼명(userId, username, userpassword, phonenumber, address)과 정확히 일치
            String sql = "INSERT INTO users (userId, username, userpassword, phonenumber, address) "
                    + "VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memId);
            pstmt.setString(2, memName);
            pstmt.setString(3, memPass);
            pstmt.setString(4, memPhone);
            pstmt.setString(5, memAddr);

            int cnt = pstmt.executeUpdate();
            if (cnt > 0) {
                System.out.println("회원 정보 추가 성공!!!");
            } else {
                System.out.println("회원 정보 추가 실패~~~");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
            if (conn != null) try { conn.close(); } catch (SQLException e) {}
        }
    }

    // ─────────────────────────────────────────────────────────────
    // (2) 회원 정보를 삭제하는 메서드
    // ─────────────────────────────────────────────────────────────
    private void deleteMember() {
        Connection conn = null;
        PreparedStatement pstmt = null;

        System.out.println();
        System.out.println("삭제할 회원 정보를 입력하세요.");
        System.out.print("삭제할 회원ID >> ");
        String memId = scan.next();

        try {
            conn = DBUtil.getConnection();
            String sql = "DELETE FROM users WHERE userId = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memId);

            int cnt = pstmt.executeUpdate();
            if (cnt > 0) {
                System.out.println("회원ID가 " + memId + "인 회원 삭제 성공!!");
            } else {
                System.out.println(memId + "은(는) 없는 회원ID이거나 삭제에 실패했습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
            if (conn != null) try { conn.close(); } catch (SQLException e) {}
        }
    }

    // ─────────────────────────────────────────────────────────────
    // (3) 회원 정보를 전체 항목 수정하는 메서드
    // ─────────────────────────────────────────────────────────────
    private void updateMember() {
        Connection conn = null;
        PreparedStatement pstmt = null;

        System.out.println();
        System.out.println("수정할 회원 정보를 입력하세요.");
        System.out.print("수정할 회원ID >> ");
        String memId = scan.next();

        int count = getMemberCount(memId);
        if (count == 0) {
            System.out.println(memId + "은(는) 없는 회원ID입니다.");
            System.out.println("수정 작업을 중단합니다.");
            return;
        }

        System.out.println();
        System.out.println("수정할 내용을 입력하세요.");
        System.out.print("새로운 회원이름 >> ");
        String newName = scan.next();

        System.out.print("새로운 비밀번호 >> ");
        String newPass = scan.next();

        System.out.print("새로운 전화번호 >> ");
        String newPhone = scan.next();

        scan.nextLine();  // 입력 버퍼 비우기
        System.out.print("새로운 주소 >> ");
        String newAddr = scan.nextLine();

        try {
            conn = DBUtil.getConnection();
            // 컬럼명: userId, username, userpassword, phonenumber, address
            String sql = "UPDATE users "
                    + "SET username = ?, userpassword = ?, phonenumber = ?, address = ? "
                    + "WHERE userId = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newName);
            pstmt.setString(2, newPass);
            pstmt.setString(3, newPhone);
            pstmt.setString(4, newAddr);
            pstmt.setString(5, memId);

            int cnt = pstmt.executeUpdate();
            if (cnt > 0) {
                System.out.println(memId + " 회원 정보 수정 완료!!!");
            } else {
                System.out.println(memId + " 회원 정보 수정 실패~~~");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
            if (conn != null) try { conn.close(); } catch (SQLException e) {}
        }
    }

    // ─────────────────────────────────────────────────────────────
    // (4) 전체 회원 정보를 출력하는 메서드
    // ─────────────────────────────────────────────────────────────
    private void displayMember() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        System.out.println();
        System.out.println("==================================================");
        System.out.println(" 회원ID   회원이름   비밀번호   전화번호      주소");
        System.out.println("==================================================");

        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT * FROM users";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                // 컬럼명: userId, username, userpassword, phonenumber, address
                String memId   = rs.getString("userId");
                String memName = rs.getString("username");
                String memPass = rs.getString("userpassword");
                String memPhone= rs.getString("phonenumber");
                String memAddr = rs.getString("address");

                System.out.printf("%-8s  %-8s  %-10s  %-12s  %-15s\n",
                        memId, memName, memPass, memPhone, memAddr);
            }

            System.out.println("==================================================");
            System.out.println("출력 작업 끝...");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) {}
            if (stmt != null) try { stmt.close(); } catch (SQLException e) {}
            if (conn != null) try { conn.close(); } catch (SQLException e) {}
        }
    }

    // ─────────────────────────────────────────────────────────────
    // (5) 회원 정보를 원하는 항목만 수정하는 메서드
    // ─────────────────────────────────────────────────────────────
    private void updateMember2() {
        Connection conn = null;
        PreparedStatement pstmt = null;

        System.out.println();
        System.out.println("수정할 회원 정보를 입력하세요.");
        System.out.print("수정할 회원ID >> ");
        String memId = scan.next();

        int count = getMemberCount(memId);
        if (count == 0) {
            System.out.println(memId + "은(는) 없는 회원ID입니다.");
            System.out.println("수정 작업을 중단합니다.");
            return;
        }

        int num;
        String updateField = null;
        String updateTitle = null;
        do {
            System.out.println();
            System.out.println("수정할 항목을 선택하세요.");
            System.out.println(" 1.회원이름  2.비밀번호  3.전화번호  4.주소");
            System.out.println("----------------------------------------------");
            System.out.print("수정할 항목 선택 >> ");
            num = scan.nextInt();
            switch (num) {
                case 1:
                    updateField = "username";
                    updateTitle = "회원이름";
                    break;
                case 2:
                    updateField = "userpassword";
                    updateTitle = "비밀번호";
                    break;
                case 3:
                    updateField = "phonenumber";
                    updateTitle = "전화번호";
                    break;
                case 4:
                    updateField = "address";
                    updateTitle = "주소";
                    break;
                default:
                    System.out.println("수정할 항목을 잘못 선택했습니다. 다시 선택하세요.");
            }
        } while (num < 1 || num > 4);

        scan.nextLine(); // 입력 버퍼 비우기
        System.out.println();
        System.out.print("새로운 " + updateTitle + " >> ");
        String updateData = scan.nextLine();

        try {
            conn = DBUtil.getConnection();
            // 동적 컬럼명
            String sql = "UPDATE users SET " + updateField + " = ? WHERE userId = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, updateData);
            pstmt.setString(2, memId);

            int cnt = pstmt.executeUpdate();
            if (cnt > 0) {
                System.out.println(memId + " 회원 정보 수정 완료!!!");
            } else {
                System.out.println(memId + " 회원 정보 수정 실패~~~");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
            if (conn != null) try { conn.close(); } catch (SQLException e) {}
        }
    }

    // ─────────────────────────────────────────────────────────────
    // 회원ID를 받아 해당 회원이 존재하는지 개수를 반환하는 메서드
    // ─────────────────────────────────────────────────────────────
    private int getMemberCount(String memId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;

        try {
            conn = DBUtil.getConnection();
            // userId 컬럼명 주의
            String sql = "SELECT COUNT(*) FROM users WHERE userId = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            count = 0;
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) {}
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
            if (conn != null) try { conn.close(); } catch (SQLException e) {}
        }
        return count;
    }
}
