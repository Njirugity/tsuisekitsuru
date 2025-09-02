package ke.tsuisekitsuru.tsuisekitsuru.controllers;

import ke.tsuisekitsuru.tsuisekitsuru.models.Users;
import ke.tsuisekitsuru.tsuisekitsuru.repositories.UsersRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    private UsersRepository usersRepository;
    public UsersController(UsersRepository usersRepository){this.usersRepository = usersRepository;}
    @GetMapping
    public List<Users> getAllUser(){
        return usersRepository.findAll();
    }
    @PostMapping
    public Users createUser(@RequestBody Users newUser){
        return usersRepository.save(newUser);
    }
}
