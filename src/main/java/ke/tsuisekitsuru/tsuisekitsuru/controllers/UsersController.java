package ke.tsuisekitsuru.tsuisekitsuru.controllers;

import ke.tsuisekitsuru.tsuisekitsuru.dtos.UserCreationDTO;
import ke.tsuisekitsuru.tsuisekitsuru.dtos.UserRolesDTO;
import ke.tsuisekitsuru.tsuisekitsuru.models.Users;
import ke.tsuisekitsuru.tsuisekitsuru.repositories.UsersRepository;
import ke.tsuisekitsuru.tsuisekitsuru.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    private UsersRepository usersRepository;
    private UserService userService;
    public UsersController(UsersRepository usersRepository, UserService userService){
        this.usersRepository = usersRepository;
        this.userService = userService;
    }
    @GetMapping
    public List<UserRolesDTO> getAllUser(){
        return userService.getAll();
    }
    @PostMapping("/register")
    public UserRolesDTO createUser(@RequestBody UserCreationDTO newUser){
        return userService.createUser(newUser);
    }
}
