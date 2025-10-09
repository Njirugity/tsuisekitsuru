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

/**
 * UserService - Class that contains all user logic
 */
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

    /**
     * Add a user
     *
     * @param userCreationDTO - dto for user registration
     * Method will convert dto to entity add to database
     * @return - a dto of the user
     */
    public UsersDTO createUser(UserCreationDTO userCreationDTO){
        Users newUser = userMapper.userCreationDTOtoUsers(userCreationDTO);
        Users savedUser = usersRepository.save(newUser);
        return userMapper.userToUserRoleDTO(savedUser);
    }

    /**
     * Retrieve all user
     *
     * @return - list of all users in the database
     */
    public List<UsersDTO> getAll(){
        return userMapper.userToUserRoleDTOList(usersRepository.findAll());
    }

    /**
     * Retrieve one user
     *
     * @param id - user id
     * Take the user id, query the database for the use
     * @return - dto representation of an updated user
     */
    public UpdateUserDTO getUser(Long id){
        Users existingUsers = usersRepository.findById(id).
                orElseThrow(()-> new RuntimeException("User not found"));
        return updateUserMapper.entityToUpdateDTO(existingUsers);
    }

    /**
     * Update user details
     *
     * @param id - user id
     * @param userDetails - dto for fields to be updated
     * Find a user by their id and only update the fields sent
     * @return - response message
     */
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

    /**
     * Update a users roles
     *
     * @param id - user id
     * @param addRole - roles id
     * Query for a user and role by id. Update the users roles
     * @return - response message
     */
    public ResponseEntity<?> assignRole(Long id, Long addRole){
        Users existingUser = usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Roles roles = rolesRepository.findById(addRole)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        existingUser.setRoles(roles);
        usersRepository.save(existingUser);
        Map<String, String > response = new HashMap<>();
        response.put("message", "Department set successfully");
        return ResponseEntity.ok(response);
    }

    /**
     * Update a user department
     *
     * @param id -user id
     * @param deptId -dept id
     * Query for a user and department by id. Update the users department
     * @return - response message
     */
    public ResponseEntity<?> assignDepartment(Long id, Long deptId){
        Users existingUser = usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Department department = departmentRepository.findById(deptId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        existingUser.setDepartment(department);
        usersRepository.save(existingUser);
        Map<String, String > response = new HashMap<>();
        response.put("message", "Department set successfully");
        return ResponseEntity.ok(response);
    }

    /**
     * Delete a user entity
     *
     * @param id - user id
     * Find a user and delete
     * @return - response message
     */
    public ResponseEntity<?> deleteUser(Long id){
        Users existingUsers = usersRepository.findById(id).
                orElseThrow(()-> new RuntimeException("User not found"));
        usersRepository.delete(existingUsers);
        Map<String, String> response = new HashMap<>();
        response.put("message",String.format("User %s successfully removed", existingUsers.getName()));
        return ResponseEntity.ok(response);
    }
}
