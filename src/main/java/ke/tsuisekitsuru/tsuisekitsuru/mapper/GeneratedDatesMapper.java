package ke.tsuisekitsuru.tsuisekitsuru.mapper;

import ke.tsuisekitsuru.tsuisekitsuru.dtos.GeneratedDatesDTO;
import ke.tsuisekitsuru.tsuisekitsuru.models.Attendance;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GeneratedDatesMapper {
    List <GeneratedDatesDTO> datesToDTO(List <Attendance> attendance);
    Attendance datesDTOToEntity(GeneratedDatesDTO dates);
}
