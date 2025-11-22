package ke.tsuisekitsuru.tsuisekitsuru.controllers;

import jakarta.validation.Valid;
import ke.tsuisekitsuru.tsuisekitsuru.dtos.ProjectsDTO;
import ke.tsuisekitsuru.tsuisekitsuru.services.ProjectsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectsController {
    private final ProjectsService projectsService;

    public ProjectsController(ProjectsService projectsService) {
        this.projectsService = projectsService;
    }

    @GetMapping
    public List<ProjectsDTO> getAllProjects(){
        return projectsService.getAllProjects();
    }

    @GetMapping("/{id}")
    public ProjectsDTO getProject(@PathVariable("id") Long id){
        return projectsService.getProject(id);
    }
    @PostMapping
    public ResponseEntity<?> addProject(@Valid @RequestBody ProjectsDTO newProject){
        return projectsService.addProject(newProject);
    }

    @PatchMapping("/assignCompany/{id}/{compId}")
    public ResponseEntity<?> assignCompany (@PathVariable("id") Long id, @PathVariable Long compId){
        return projectsService.assignCompany(id, compId);
    }
    @PutMapping("/updateDepartment/{id}")
    public ResponseEntity<?> updateProject(@PathVariable("id")Long id,
                                              @RequestBody ProjectsDTO request){
        return projectsService.updateProject(id, request);
    }

}
