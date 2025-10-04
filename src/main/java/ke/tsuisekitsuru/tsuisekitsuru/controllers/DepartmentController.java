package ke.tsuisekitsuru.tsuisekitsuru.controllers;

import ke.tsuisekitsuru.tsuisekitsuru.models.Company;
import ke.tsuisekitsuru.tsuisekitsuru.models.Department;
import ke.tsuisekitsuru.tsuisekitsuru.repositories.CompanyRepository;
import ke.tsuisekitsuru.tsuisekitsuru.repositories.DepartmentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private DepartmentRepository departmentRepository;
    private CompanyRepository companyRepository;

    public DepartmentController(DepartmentRepository departmentRepository, CompanyRepository companyRepository) {
        this.departmentRepository = departmentRepository;
        this.companyRepository = companyRepository;
    }

    @GetMapping
    public List<Department> getAllDepartments(){return departmentRepository.findAll();}

    @PostMapping
    public Department addDepartment(@RequestBody Department newDept){
        return departmentRepository.save(newDept);
    }

    @PatchMapping("/{id}/{compId}/assignCompany")
    public Department assignCompany (@PathVariable("id") Long id, @PathVariable Long compId){
        Department existingDept = departmentRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Department not found"));
        Company existingComp = companyRepository.findById(compId).
                orElseThrow(() -> new RuntimeException("Company not found"));

        existingDept.setCompany(existingComp);
        return departmentRepository.save(existingDept);
    }

}
