package ke.tsuisekitsuru.tsuisekitsuru.controllers;

import ke.tsuisekitsuru.tsuisekitsuru.models.Roles;
import ke.tsuisekitsuru.tsuisekitsuru.repositories.RolesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesController {
    private RolesRepository rolesRepository;

    public RolesController(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @GetMapping
    public List<Roles> getAllRoles(){return rolesRepository.findAll();}

    @PostMapping
    public Roles createRole(@RequestBody Roles newRole){
        return rolesRepository.save(newRole);
    }
}
