package ke.tsuisekitsuru.tsuisekitsuru.mapper;

import ke.tsuisekitsuru.tsuisekitsuru.dtos.UpdateUserDTO;
import ke.tsuisekitsuru.tsuisekitsuru.models.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UpdateUserMapper {
    UpdateUserDTO entityToUpdateDTO(Users users);
    Users dtoToUserEntity(UpdateUserDTO updateUserDTO);
}
