package ke.tsuisekitsuru.tsuisekitsuru.mapper;

import ke.tsuisekitsuru.tsuisekitsuru.dtos.ProjectsDTO;
import ke.tsuisekitsuru.tsuisekitsuru.models.Projects;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    ProjectsDTO deptToDeptDTO(Projects projects);
    List<ProjectsDTO> deptToDeptDTOList(List<Projects> projects);
    Projects deptDTOToDept(ProjectsDTO projectsDTO);
}
