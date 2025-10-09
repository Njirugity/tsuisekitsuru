package ke.tsuisekitsuru.tsuisekitsuru.controllers;

import ke.tsuisekitsuru.tsuisekitsuru.dtos.UpdateUserDTO;
import ke.tsuisekitsuru.tsuisekitsuru.dtos.UserCreationDTO;
import ke.tsuisekitsuru.tsuisekitsuru.dtos.UsersDTO;
import ke.tsuisekitsuru.tsuisekitsuru.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;
    public UsersController(UserService userService){
        this.userService = userService;
    }
    @GetMapping
    public List<UsersDTO> getAllUser(){
        return userService.getAll();
    }
    @GetMapping("/{id}")
    public UpdateUserDTO getUser(@PathVariable("id") Long id){
        return userService.getUser(id);
    }
    @PostMapping("/register")
    public UsersDTO createUser(@RequestBody UserCreationDTO newUser){
        return userService.createUser(newUser);
    }
    @PatchMapping("/assignDepartment/{id}/{deptId}")
    public ResponseEntity<?> assignDepartment(@PathVariable("id") Long id, @PathVariable Long deptId){
        return userService.assignDepartment(id, deptId);
    }
    @PatchMapping("/assignRoles/{id}/{roleId}")
    public ResponseEntity<?> assignRoles(@PathVariable("id") Long id, @PathVariable Long roleId){
        return userService.assignRole(id, roleId);
    }
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<?> updateUserDetails(@PathVariable("id") Long id, @RequestBody UpdateUserDTO userDetails){
        return userService.updateUserDetails(id, userDetails);
    }
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        return userService.deleteUser(id);
    }
}
