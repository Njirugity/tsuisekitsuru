package ke.tsuisekitsuru.tsuisekitsuru.mapper;

import ke.tsuisekitsuru.tsuisekitsuru.dtos.AttendanceRequestDTO;
import ke.tsuisekitsuru.tsuisekitsuru.models.Attendance;
import org.mapstruct.Mapper;

@Mapper
public interface AttendanceRequestMapper {
    AttendanceRequestDTO attendanceToDTO(Attendance attendance);
    Attendance attendanceDTOToEntity(AttendanceRequestDTO attendanceRequestDTO);
}
