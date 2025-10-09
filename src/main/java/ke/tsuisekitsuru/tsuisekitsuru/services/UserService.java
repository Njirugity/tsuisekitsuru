package ke.tsuisekitsuru.tsuisekitsuru.services;

import ke.tsuisekitsuru.tsuisekitsuru.dtos.UpdateUserDTO;
import ke.tsuisekitsuru.tsuisekitsuru.dtos.UserCreationDTO;
import ke.tsuisekitsuru.tsuisekitsuru.dtos.UsersDTO;
import ke.tsuisekitsuru.tsuisekitsuru.mapper.UpdateUserMapper;
import ke.tsuisekitsuru.tsuisekitsuru.mapper.UserMapper;
import ke.tsuisekitsuru.tsuisekitsuru.models.Department;
import ke.tsuisekitsuru.tsuisekitsuru.models.Roles;
import ke.tsuisekitsuru.tsuisekitsuru.models.Users;
import ke.tsuisekitsuru.tsuisekitsuru.repositories.DepartmentRepository;
import ke.tsuisekitsuru.tsuisekitsuru.repositories.RolesRepository;
import ke.tsuisekitsuru.tsuisekitsuru.repositories.UsersRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final UsersRepository usersRepository;
    private final DepartmentRepository departmentRepository;
    private final RolesRepository rolesRepository;
    private final UserMapper userMapper;
    private final UpdateUserMapper updateUserMapper;

    public UserService(UsersRepository usersRepository, UserMapper userMapper,
                       DepartmentRepository departmentRepository, RolesRepository rolesRepository,
                       UpdateUserMapper updateUserMapper) {
        this.usersRepository = usersRepository;
        this.userMapper = userMapper;
        this.departmentRepository = departmentRepository;
        this.rolesRepository = rolesRepository;
        this.updateUserMapper = updateUserMapper;
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
        return userMapper.userToUserRoleDTOList(usersRepository.findAll());
    }
    public UpdateUserDTO getUser(Long id){
        Users existingUsers = usersRepository.findById(id).
                orElseThrow(()-> new RuntimeException("User not found"));
        return updateUserMapper.entityToUpdateDTO(existingUsers);
    }
    public ResponseEntity <?> updateUserDetails(Long id, UpdateUserDTO userDetails){
        Users existingUsers = usersRepository.findById(id).
                orElseThrow(()-> new RuntimeException("User not found"));

        if (userDetails.getName() != null){
            existingUsers.setName(userDetails.getName());
        }
        if(userDetails.getEmail() != null){
            existingUsers.setEmail(userDetails.getEmail());
        }
        if (userDetails.getIdNumber() != null){
            existingUsers.setIdNumber(userDetails.getIdNumber());
        }
        if (userDetails.getPhoneNumber() != null){
            existingUsers.setPhoneNumber(userDetails.getPhoneNumber());
        }

        usersRepository.save(existingUsers);
        Map <String, String> response = new HashMap<>();
        response.put("message","Update successful");
        return ResponseEntity.ok(response);
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

    public ResponseEntity<?> deleteUser(Long id){
        Users existingUsers = usersRepository.findById(id).
                orElseThrow(()-> new RuntimeException("User not found"));
        usersRepository.delete(existingUsers);
        Map<String, String> response = new HashMap<>();
        response.put("message",String.format("User %s successfully removed", existingUsers.getName()));
        return ResponseEntity.ok(response);
    }
}
