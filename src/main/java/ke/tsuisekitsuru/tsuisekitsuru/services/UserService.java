package ke.tsuisekitsuru.tsuisekitsuru.services;

import ke.tsuisekitsuru.tsuisekitsuru.dtos.UserCreationDTO;
import ke.tsuisekitsuru.tsuisekitsuru.dtos.UserRolesDTO;
import ke.tsuisekitsuru.tsuisekitsuru.mapper.UserMapper;
import ke.tsuisekitsuru.tsuisekitsuru.models.Users;
import ke.tsuisekitsuru.tsuisekitsuru.repositories.UsersRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UsersRepository usersRepository;
    private UserMapper userMapper;
    public UserService(UsersRepository usersRepository, UserMapper userMapper) {
        this.usersRepository = usersRepository;
        this.userMapper = userMapper;
    }

    public UsersRepository getUsersRepository() {
        return usersRepository;
    }

    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserRolesDTO getToUserDTO(Users users){
        return userMapper.userToUserRoleDTO(users);
    }
    public UserRolesDTO createUser(UserCreationDTO userCreationDTO){
        Users newUser = userMapper.userCreationDTOtoUsers(userCreationDTO);
        Users savedUser = usersRepository.save(newUser);
        return userMapper.userToUserRoleDTO(savedUser);
    }

    /**
     *
     * @return a list of all users
     */
    public List<UserRolesDTO> getAll(){
        return usersRepository.findAll()
                .stream()
                .map(this::getToUserDTO)
                .collect(Collectors.toList());
    }
}
