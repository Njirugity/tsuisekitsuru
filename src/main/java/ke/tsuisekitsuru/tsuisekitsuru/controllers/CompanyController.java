package ke.tsuisekitsuru.tsuisekitsuru.controllers;

import ke.tsuisekitsuru.tsuisekitsuru.models.Company;
import ke.tsuisekitsuru.tsuisekitsuru.repositories.CompanyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping
    public List<Company> getAllCompanies(){return companyRepository.findAll();}

    @PostMapping
    public Company addCompany(@RequestBody Company newCompany){
        return companyRepository.save(newCompany);
    }
}
