package ke.tsuisekitsuru.tsuisekitsuru.mapper;

import ke.tsuisekitsuru.tsuisekitsuru.dtos.UserCreationDTO;
import ke.tsuisekitsuru.tsuisekitsuru.dtos.UsersDTO;
import ke.tsuisekitsuru.tsuisekitsuru.models.Users;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UsersDTO userToUserRoleDTO(Users users);
    List <UsersDTO> userToUserRoleDTOList(List<Users> users);
    Users userCreationDTOtoUsers(UserCreationDTO userCreationDTO);
    UserCreationDTO usersToUserCreationDTO(Users users);
}
