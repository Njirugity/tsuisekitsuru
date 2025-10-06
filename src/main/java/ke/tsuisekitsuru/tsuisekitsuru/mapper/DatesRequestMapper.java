package ke.tsuisekitsuru.tsuisekitsuru.mapper;

import ke.tsuisekitsuru.tsuisekitsuru.dtos.DatesRequestDTO;
import ke.tsuisekitsuru.tsuisekitsuru.models.Dates;
import org.mapstruct.Mapper;

@Mapper
public interface DatesRequestMapper {
    DatesRequestDTO datesToDTO(Dates dates);
    Dates datesDTOToEntity(DatesRequestDTO datesRequestDTO);
}
