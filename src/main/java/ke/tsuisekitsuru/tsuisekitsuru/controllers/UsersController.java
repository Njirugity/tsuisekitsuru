package ke.tsuisekitsuru.tsuisekitsuru.controllers;

import ke.tsuisekitsuru.tsuisekitsuru.dtos.UserCreationDTO;
import ke.tsuisekitsuru.tsuisekitsuru.dtos.UsersDTO;
import ke.tsuisekitsuru.tsuisekitsuru.models.Department;
import ke.tsuisekitsuru.tsuisekitsuru.models.Users;
import ke.tsuisekitsuru.tsuisekitsuru.repositories.DepartmentRepository;
import ke.tsuisekitsuru.tsuisekitsuru.repositories.UsersRepository;
import ke.tsuisekitsuru.tsuisekitsuru.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    private UsersRepository usersRepository;
    private DepartmentRepository departmentRepository;
    private UserService userService;
    public UsersController(UsersRepository usersRepository, UserService userService, DepartmentRepository departmentRepository){
        this.usersRepository = usersRepository;
        this.userService = userService;
        this.departmentRepository = departmentRepository;
    }
    @GetMapping
    public List<UsersDTO> getAllUser(){
        return userService.getAll();
    }
    @PostMapping("/register")
    public UsersDTO createUser(@RequestBody UserCreationDTO newUser){
        return userService.createUser(newUser);
    }
    @PatchMapping("/{id}/{deptId}/assignDepartment")
    public Users assignDepartment(@PathVariable("id") Long id, @PathVariable Long deptId){
        return userService.assignDepartment(id, deptId);
    }
    @PatchMapping("/{id}/{roleId}/assignRoles")
    public Users assignRoles(@PathVariable("id") Long id, @PathVariable Long roleId){
        return userService.assignRole(id, roleId);
    }
}
