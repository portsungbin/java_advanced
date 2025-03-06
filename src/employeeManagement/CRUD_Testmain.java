package employeeManagement;

import employeeManagement.dao.EmployeeDAO;
import employeeManagement.dto.Employee;
import java.sql.SQLException;

public class CRUD_Testmain {
    public static void main(String[] args) throws SQLException {
        EmployeeDAO employeeDAO = new EmployeeDAO();

        // insert
        Employee employee = new Employee("1001", "Alice", 2023, 3, 3, "Manager", "101", null);
        employeeDAO.insertEmployee(employee);

        // read
        Employee retrievedEmployee = employeeDAO.getEmployeeByEno("1001");
        if (retrievedEmployee != null) {
            System.out.println("조회된 사원 정보: " + retrievedEmployee);
        } else {
            System.out.println("사원 정보가 존재하지 않습니다.");
        }

        // update
        Employee updatedEmployee = new Employee("1001", "Alice Johnson", 2023, 3, 3, "Senior Manager", "101", null);
        employeeDAO.updateEmployee(updatedEmployee);


        //delete
        employeeDAO.deleteEmployee("1001");

    }
}
