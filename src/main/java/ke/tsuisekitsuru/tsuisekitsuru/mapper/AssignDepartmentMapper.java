package ke.tsuisekitsuru.tsuisekitsuru.mapper;

import ke.tsuisekitsuru.tsuisekitsuru.dtos.AssignDepartmentDTO;
import ke.tsuisekitsuru.tsuisekitsuru.models.Department;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface AssignDepartmentMapper {
    AssignDepartmentDTO deptToAssignDeptDTo(Department department);
    Department assignDeptDTOtoDept(AssignDepartmentDTO assignDepartmentDTO);
}
