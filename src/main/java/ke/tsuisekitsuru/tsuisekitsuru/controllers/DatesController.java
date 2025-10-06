package ke.tsuisekitsuru.tsuisekitsuru.controllers;

import ke.tsuisekitsuru.tsuisekitsuru.dtos.DatesRequestDTO;
import ke.tsuisekitsuru.tsuisekitsuru.dtos.GeneratedDatesDTO;
import ke.tsuisekitsuru.tsuisekitsuru.mapper.GeneratedDatesMapper;
import ke.tsuisekitsuru.tsuisekitsuru.models.Dates;
import ke.tsuisekitsuru.tsuisekitsuru.repositories.DatesRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dates")
public class DatesController {
    private DatesRepository datesRepository;
    private GeneratedDatesMapper generatedDatesMapper;

    public DatesController(DatesRepository datesRepository, GeneratedDatesMapper generatedDatesMapper) {
        this.datesRepository = datesRepository;
        this.generatedDatesMapper = generatedDatesMapper;
    }

    @GetMapping
    public List<Dates> getAllAttendances(){return datesRepository.findAll();}

    @PostMapping("/addMultiple")
    public List<GeneratedDatesDTO> addMultipleDate(@RequestBody DatesRequestDTO dates){
        List<Dates> savedDates = new ArrayList<>();
        LocalDate startDate = dates.getStartDate();
        int numberOfDays = dates.getNumberOfDays();

        for (int i = 0; i< numberOfDays; i++){
            Dates attendance = new Dates();
            attendance.setDate(startDate.plusDays(i));
            savedDates.add(attendance);
        }

        List<Dates> saved = datesRepository.saveAll(savedDates);
        return generatedDatesMapper.datesToDTO(saved);
    }
}
