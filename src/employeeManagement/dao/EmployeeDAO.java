package employeeManagement.dao;

import employeeManagement.dto.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {
    Connection conn = null;
    PreparedStatement pstmt = null;

    // insert (salary 모르겠네)
    public void insertEmployee(Employee employee) throws SQLException {
        try {
            conn = EmployeeDBConfig.getConnection();
            String sql = "INSERT INTO employee (eno, name, enteryear, entermonth, enterday, role, secno) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, employee.getEno());
            pstmt.setString(2, employee.getName());
            pstmt.setInt(3, employee.getEnterYear());
            pstmt.setInt(4, employee.getEnterMonth());
            pstmt.setInt(5, employee.getEnterDay());
            pstmt.setString(6, employee.getRole());
            pstmt.setString(7, employee.getSecNo());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 업데이트
    public void updateEmployee(Employee employee) throws SQLException {
        try {
            conn = EmployeeDBConfig.getConnection();
            String sql = "UPDATE employee SET name=?, enteryear=?, entermonth=?, enterday=?, role=?, secno=? WHERE eno=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, employee.getName());
            pstmt.setInt(2, employee.getEnterYear());
            pstmt.setInt(3, employee.getEnterMonth());
            pstmt.setInt(4, employee.getEnterDay());
            pstmt.setString(5, employee.getRole());
            pstmt.setString(6, employee.getSecNo());
            pstmt.setString(7, employee.getEno());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 삭제
    public void deleteEmployee(String eno) throws SQLException {
        try {
            conn = EmployeeDBConfig.getConnection();
            String sql = "DELETE FROM employee WHERE eno=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, eno);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // eno를 기준으로 조회
    public Employee getEmployeeByEno(String eno) throws SQLException {
        Employee employee = null;
        ResultSet rs = null;
        try {
            conn = EmployeeDBConfig.getConnection();
            String sql = "SELECT eno, name, enteryear, entermonth, enterday, role, secno FROM employee WHERE eno=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, eno);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                employee = new Employee(
                        rs.getString("eno"),
                        rs.getString("name"),
                        rs.getInt("enteryear"),
                        rs.getInt("entermonth"),
                        rs.getInt("enterday"),
                        rs.getString("role"),
                        rs.getString("secno"),
                        null  // salary는 테이블 컬럼에 없으므로 null 처리
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employee;
    }
}
