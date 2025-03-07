package MainSystem.model.dao;

import MainSystem.Util.DBUtil;
import MainSystem.io.EmployeeIO;
import MainSystem.model.Employee;
import MainSystem.model.ObjectIO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//실제로 CRUD 구현 부

public class EmployeeDBIO extends ObjectIO implements EmployeeIO {

    @Override
    public boolean addEmployee(Employee employee) {

        String sql = "" +
                "INSERT INTO EMPLOYEE (eno, name, enteryear, entermonth, enterday, role, secno, salary, lastRaiseYear) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, employee.getEno());
            pstmt.setString(2, employee.getName());
            pstmt.setInt(3, employee.getEnterYear());
            pstmt.setInt(4, employee.getEnterMonth());
            pstmt.setInt(5, employee.getEnterDay());
            pstmt.setString(6, employee.getRole());
            pstmt.setString(7, employee.getSecno());
            pstmt.setInt(8, employee.getSalary());
            pstmt.setInt(9, employee.getLastRaiseYear());

            System.out.println(pstmt.toString());
            int cnt = pstmt.executeUpdate();
            if (cnt > 0) {
                System.out.println("회원 정보 추가 성공");
                return true;
            } else {
                System.out.println("회원 정보 추가 실패");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBUtil.getConnection();
        return false;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {

        String sql = "UPDATE EMPLOYEE SET name=?, enteryear=?, entermonth=?, enterday=?, role=?, secno=?, salary=?, lastRaiseYear =? WHERE eno=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, employee.getName());
            pstmt.setInt(2, employee.getEnterYear());
            pstmt.setInt(3, employee.getEnterMonth());
            pstmt.setInt(4, employee.getEnterDay());
            pstmt.setString(5, employee.getRole());
            pstmt.setString(6, employee.getSecno());
            pstmt.setInt(7, employee.getSalary());
            pstmt.setInt(8, employee.getLastRaiseYear());
            pstmt.setString(9, employee.getEno());
            pstmt.executeUpdate();
        }

        return false;
    }


    @Override
    public Employee getEmployeeById(String eno) {
        String sql = "SELECT * FROM EMPLOYEE WHERE eno = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, eno);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // 🔹 단순히 테이블의 데이터를 Employee 객체로 변환하여 반환
                return new Employee(
                        rs.getString("eno"),
                        rs.getString("name"),
                        rs.getInt("enteryear"),
                        rs.getInt("entermonth"),
                        rs.getInt("enterday"),
                        rs.getString("role"),  // 그대로 저장
                        rs.getString("secno"),
                        rs.getInt("salary"),
                        rs.getInt("lastRaiseYear")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBUtil.getConnection();
        return null; // 직원이 존재하지 않는 경우
    }


    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM EMPLOYEE";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                employees.add(new Employee(
                        rs.getString("eno"),
                        rs.getString("name"),
                        rs.getInt("enteryear"),
                        rs.getInt("entermonth"),
                        rs.getInt("enterday"),
                        rs.getString("role"),
                        rs.getString("secno"),
                        rs.getInt("salary"),
                        rs.getInt("lastRaiseYear")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving employees", e);
        }

        return employees;
    }


    @Override
    public List<Employee> searchEmployeesByName(String name) {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM EMPLOYEE WHERE name LIKE ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                employees.add(new Employee(
                        rs.getString("eno"),
                        rs.getString("name"),
                        rs.getInt("enteryear"),
                        rs.getInt("entermonth"),
                        rs.getInt("enterday"),
                        rs.getString("role"),
                        rs.getString("secno"),
                        rs.getInt("salary"),
                        rs.getInt("lastRaiseYear")

                ));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBUtil.getConnection();
        return employees;
    }

    @Override
    public List<Employee> searchEmployeesByRole(String role) {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM EMPLOYEE WHERE role LIKE ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, role);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                employees.add(new Employee(
                        rs.getString("eno"),
                        rs.getString("name"),
                        rs.getInt("enteryear"),
                        rs.getInt("entermonth"),
                        rs.getInt("enterday"),
                        rs.getString("role"),
                        rs.getString("secno"),
                        rs.getInt("salary"),
                        rs.getInt("lastRaiseYear")

                ));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBUtil.getConnection();
        return employees;
    }

    @Override
    public List<Employee> getUnassignedSecretaries() {
        List<Employee> secretaries = new ArrayList<>();
        String sql = "SELECT * FROM Employee " +
                "WHERE role = 'Secretary' " +
                "AND eno NOT IN (" +
                "   SELECT secno FROM Employee WHERE role = 'Manager' AND secno IS NOT NULL" +
                ")";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Employee emp = new Employee(
                        rs.getString("eno"),
                        rs.getString("name"),
                        rs.getInt("enteryear"),
                        rs.getInt("entermonth"),
                        rs.getInt("enterday"),
                        rs.getString("role"),
                        rs.getString("secno"),
                        rs.getInt("salary"),
                        rs.getInt("lastRaiseYear")
                );
                secretaries.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return secretaries;
    }

    /**
     * Employee 객체에 담긴 값 중 기본값이 아닌 단 하나의 항목을
     * 데이터베이스의 해당 직원 레코드에 업데이트합니다.
     * 예를 들어, 이름만 변경할 경우 Employee 객체는
     * new Employee("12345", "새이름", 0, 0, 0, "", "", 0) 형태로 생성됩니다.
     *
     * @param employee 업데이트할 정보를 담은 Employee 객체
     * @return 업데이트 성공하면 true, 실패하면 false를 반환
     */
    @Override
    public boolean selectUpdateEmployee(Employee employee) {
        // 1. 업데이트할 직원의 사번(eno)를 가져옵니다.
        String eno = employee.getEno();

        // 2. 사번에 해당하는 직원이 데이터베이스에 있는지 확인합니다.
        Employee existing = getEmployeeById(eno);
        if (existing == null) {
            System.out.println("업데이트 실패: 해당 사번의 직원이 존재하지 않습니다.");
            return false;
        }

        // 3. 업데이트할 컬럼과 새 값을 저장할 변수를 준비합니다.
        String column = null;
        String newValue = null;

        // 4. Employee 객체에서 업데이트할 항목을 하나만 선택합니다.
        if (employee.getName() != null && !employee.getName().isEmpty()) {
            column = "name";                        // 이름 업데이트
            newValue = employee.getName();            // 새 이름
        } else if (employee.getEnterYear() != 0) {
            column = "enteryear";                     // 입사년도 업데이트
            newValue = Integer.toString(employee.getEnterYear());
        } else if (employee.getEnterMonth() != 0) {
            column = "entermonth";                    // 입사월 업데이트
            newValue = Integer.toString(employee.getEnterMonth());
        } else if (employee.getEnterDay() != 0) {
            column = "enterday";                      // 입사일 업데이트
            newValue = Integer.toString(employee.getEnterDay());
        } else if (employee.getRole() != null && !employee.getRole().isEmpty()) {
            column = "role";                          // 직급 업데이트
            newValue = employee.getRole();
        } else if (employee.getSecno() != null && !employee.getSecno().isEmpty()) {
            column = "secno";                         // 비서번호 업데이트
            newValue = employee.getSecno();
        } else if (employee.getSalary() != 0) {
            column = "salary";                        // 급여 업데이트
            newValue = Integer.toString(employee.getSalary());
        } else {
            // 아무 항목도 업데이트할 값이 없다면
            System.out.println("업데이트할 항목이 지정되지 않았습니다.");
            return false;
        }

        // 5. 선택된 컬럼만 업데이트하는 SQL 쿼리 생성
        String sql = "UPDATE EMPLOYEE SET " + column + " = ? WHERE eno = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // 6. 숫자형 컬럼이면 String newValue를 정수로 변환해서 바인딩, 아니면 그대로 문자열로 바인딩
            if (column.equals("enteryear") || column.equals("entermonth") ||
                    column.equals("enterday") || column.equals("salary")) {
                pstmt.setInt(1, Integer.parseInt(newValue));
            } else {
                pstmt.setString(1, newValue);
            }
            // 7. 사번을 WHERE 조건에 바인딩
            pstmt.setString(2, eno);

            // 8. 쿼리를 실행하고 결과를 확인합니다.
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("업데이트 성공");
                return true;
            } else {
                System.out.println("업데이트 실패");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}