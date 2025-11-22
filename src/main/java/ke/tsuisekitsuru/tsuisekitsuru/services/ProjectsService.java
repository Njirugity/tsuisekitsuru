package ke.tsuisekitsuru.tsuisekitsuru.services;

import ke.tsuisekitsuru.tsuisekitsuru.dtos.ProjectsDTO;
import ke.tsuisekitsuru.tsuisekitsuru.mapper.ProjectMapper;
import ke.tsuisekitsuru.tsuisekitsuru.models.Company;
import ke.tsuisekitsuru.tsuisekitsuru.models.Projects;
import ke.tsuisekitsuru.tsuisekitsuru.repositories.CompanyRepository;
import ke.tsuisekitsuru.tsuisekitsuru.repositories.ProjectsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjectsService {
    private final ProjectsRepository projectsRepository;
    private final CompanyRepository companyRepository;
    private final ProjectMapper projectMapper;

    public ProjectsService(ProjectsRepository projectsRepository, CompanyRepository companyRepository,
                           ProjectMapper projectMapper) {
        this.projectsRepository = projectsRepository;
        this.companyRepository = companyRepository;
        this.projectMapper = projectMapper;
    }

    public List<ProjectsDTO> getAllProjects(){
        List<Projects> allProjects = projectsRepository.findAll();
        return projectMapper.entitiesToDTOList(allProjects);
    }

    public ProjectsDTO getProject(Long id){
        Projects existingProjects = projectsRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Department not found"));
        return projectMapper.entityToDTO(existingProjects);
    }
    public ResponseEntity<?> addProject(ProjectsDTO newDepartment){
        Projects addProjects = projectsRepository.save(projectMapper.DTOToEntity(newDepartment));
        Map<String, String> response = new HashMap<>();
        response.put("message","Department added successfully");
        return ResponseEntity.ok(response);
    }
    public ResponseEntity<?> updateProject(Long id, ProjectsDTO request){
        Projects existingProjects = projectsRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Department not found"));
        if(request.getLocation() != null){
            existingProjects.setLocation(request.getLocation());
        }
        if(request.getDescription()!= null){
            existingProjects.setDescription(request.getDescription());
        }
        projectsRepository.save(existingProjects);
        Map <String, String> response = new HashMap<>();
        response.put("message","Update successful");
        return ResponseEntity.ok(response);
    }
    public ResponseEntity<?> assignCompany(Long deptId, Long compId){
        Projects existingProjects = projectsRepository.findById(deptId)
                .orElseThrow(()-> new RuntimeException("Department not found"));
        Company existingCompany = companyRepository.findById(compId)
                .orElseThrow(()-> new RuntimeException("Company not found"));

        existingProjects.setCompany(existingCompany);
        projectsRepository.save(existingProjects);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Company assigned successfully");
        return ResponseEntity.ok(response);
    }
}
