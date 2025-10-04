package ke.tsuisekitsuru.tsuisekitsuru.dtos;

import ke.tsuisekitsuru.tsuisekitsuru.models.Department;

public class AssignDepartmentDTO {
    Department department;

    public AssignDepartmentDTO(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
