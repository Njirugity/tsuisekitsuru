package ke.tsuisekitsuru.tsuisekitsuru.mapper;

import ke.tsuisekitsuru.tsuisekitsuru.dtos.UserCreationDTO;
import ke.tsuisekitsuru.tsuisekitsuru.dtos.UserRolesDTO;
import ke.tsuisekitsuru.tsuisekitsuru.models.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserRolesDTO userToUserRoleDTO(Users users);
    Users userCreationDTOtoUsers(UserCreationDTO userCreationDTO);
    UserCreationDTO usersToUserCreationDTO(Users users);
}
