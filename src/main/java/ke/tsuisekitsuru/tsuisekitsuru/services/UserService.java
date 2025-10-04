package ke.tsuisekitsuru.tsuisekitsuru.services;

import ke.tsuisekitsuru.tsuisekitsuru.dtos.UserCreationDTO;
import ke.tsuisekitsuru.tsuisekitsuru.dtos.UsersDTO;
import ke.tsuisekitsuru.tsuisekitsuru.mapper.UserMapper;
import ke.tsuisekitsuru.tsuisekitsuru.models.Department;
import ke.tsuisekitsuru.tsuisekitsuru.models.Roles;
import ke.tsuisekitsuru.tsuisekitsuru.models.Users;
import ke.tsuisekitsuru.tsuisekitsuru.repositories.DepartmentRepository;
import ke.tsuisekitsuru.tsuisekitsuru.repositories.RolesRepository;
import ke.tsuisekitsuru.tsuisekitsuru.repositories.UsersRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UsersRepository usersRepository;
    private DepartmentRepository departmentRepository;
    private RolesRepository rolesRepository;
    private UserMapper userMapper;
    public UserService(UsersRepository usersRepository, UserMapper userMapper, DepartmentRepository departmentRepository, RolesRepository rolesRepository) {
        this.usersRepository = usersRepository;
        this.userMapper = userMapper;
        this.departmentRepository = departmentRepository;
        this.rolesRepository = rolesRepository;
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

    public UsersDTO getToUserDTO(Users users){
        return userMapper.userToUserRoleDTO(users);
    }
    public UsersDTO createUser(UserCreationDTO userCreationDTO){
        Users newUser = userMapper.userCreationDTOtoUsers(userCreationDTO);
        Users savedUser = usersRepository.save(newUser);
        return userMapper.userToUserRoleDTO(savedUser);
    }

    /**
     *
     * @return a list of all users
     */
    public List<UsersDTO> getAll(){
        return usersRepository.findAll()//returns a list of user
                .stream()//convert this list to in a way that it can be processed
                .map(this::getToUserDTO)//apply the function to each item in the list
                .collect(Collectors.toList());//place the dtos in a list
    }

    public  Users assignRole(Long id, Long addRole){
        Users existingUser = usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Roles roles = rolesRepository.findById(addRole)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        existingUser.setRoles(roles);
        return  usersRepository.save(existingUser);
    }
    public Users assignDepartment(Long id, Long deptId){
        Users existingUser = usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Department department = departmentRepository.findById(deptId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        existingUser.setDepartment(department);
        return usersRepository.save(existingUser);
    }

}
