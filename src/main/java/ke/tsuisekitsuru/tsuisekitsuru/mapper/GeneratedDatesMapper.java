package ke.tsuisekitsuru.tsuisekitsuru.mapper;

import ke.tsuisekitsuru.tsuisekitsuru.dtos.GeneratedDatesDTO;
import ke.tsuisekitsuru.tsuisekitsuru.models.Dates;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GeneratedDatesMapper {
    List <GeneratedDatesDTO> datesToDTO(List <Dates> dates);
    Dates datesDTOToEntity(GeneratedDatesDTO dates);
}
