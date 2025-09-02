package ke.tsuisekitsuru.tsuisekitsuru.controllers;

import ke.tsuisekitsuru.tsuisekitsuru.models.Department;
import ke.tsuisekitsuru.tsuisekitsuru.repositories.DepartmentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping
    public List<Department> getAllDepartments(){return departmentRepository.findAll();}

    @PostMapping
    public Department addDepartment(@RequestBody Department newDept){
        return departmentRepository.save(newDept);
    }
}
