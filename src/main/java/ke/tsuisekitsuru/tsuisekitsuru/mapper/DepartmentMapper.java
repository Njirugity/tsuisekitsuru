package ke.tsuisekitsuru.tsuisekitsuru.mapper;

import ke.tsuisekitsuru.tsuisekitsuru.dtos.DepartmentDTO;
import ke.tsuisekitsuru.tsuisekitsuru.models.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentDTO deptToDeptDTO(Department department);
    Department deptDTOToDept(DepartmentDTO departmentDTO);
}
