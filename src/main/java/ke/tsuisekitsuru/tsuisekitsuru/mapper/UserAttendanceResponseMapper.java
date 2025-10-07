package ke.tsuisekitsuru.tsuisekitsuru.mapper;

import ke.tsuisekitsuru.tsuisekitsuru.dtos.UserAttendanceResponseDTO;
import ke.tsuisekitsuru.tsuisekitsuru.models.UserAttendance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserAttendanceResponseMapper {
    @Mapping(source = "users.name", target = "name")
    @Mapping(source = "dates.date", target = "date")
    UserAttendanceResponseDTO userAttendanceToDTO(UserAttendance userAttendance);
    List <UserAttendanceResponseDTO> userAttendanceToDTOList (List <UserAttendance> userAttendance);
    UserAttendance dtoToEntity(UserAttendanceResponseDTO userAttendanceResponseDTO);
}
