package ke.tsuisekitsuru.tsuisekitsuru.mapper;

import ke.tsuisekitsuru.tsuisekitsuru.dtos.UserAttendanceRequestDTO;
import ke.tsuisekitsuru.tsuisekitsuru.models.UserAttendance;
import org.mapstruct.Mapper;

@Mapper(componentModel = "string")
public interface UserAttendanceRequestMapper {
    UserAttendanceRequestDTO userAttendanceToDTO(UserAttendance userAttendance);
    UserAttendance userAttendanceDTOToEntity(UserAttendanceRequestDTO userAttendanceRequestDTO);
}
