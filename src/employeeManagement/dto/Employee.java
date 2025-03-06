package employeeManagement.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Employee {
    private String eno;
    private String name;
    private int enterYear;
    private int enterMonth;
    private int enterDay;
    private String role;
    private String secNo;
    private BigDecimal salary;

}
