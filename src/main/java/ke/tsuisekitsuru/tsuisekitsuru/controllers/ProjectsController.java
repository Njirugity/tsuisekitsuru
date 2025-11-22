package ke.tsuisekitsuru.tsuisekitsuru.controllers;

import ke.tsuisekitsuru.tsuisekitsuru.dtos.ProjectsDTO;
import ke.tsuisekitsuru.tsuisekitsuru.services.ProjectsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final ProjectsService projectsService;

    public DepartmentController(ProjectsService projectsService) {
        this.projectsService = projectsService;
    }

    @GetMapping
    public List<ProjectsDTO> getAllDepartments(){
        return projectsService.getAllDepartments();
    }

    @GetMapping("/{id")
    public ProjectsDTO getDepartment(@PathVariable("id") Long id){
        return projectsService.getDepartment(id);
    }
    @PostMapping
    public ResponseEntity<?> addDepartment(@RequestBody ProjectsDTO newDept){
        return projectsService.addDepartments(newDept);
    }

    @PatchMapping("/assignCompany/{id}/{compId}")
    public ResponseEntity<?> assignCompany (@PathVariable("id") Long id, @PathVariable Long compId){
        return projectsService.assignCompany(id, compId);
    }
    @PutMapping("/updateDepartment/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable("id")Long id,
                                              @RequestBody ProjectsDTO request){
        return projectsService.updateDepartment(id, request);
    }

}
