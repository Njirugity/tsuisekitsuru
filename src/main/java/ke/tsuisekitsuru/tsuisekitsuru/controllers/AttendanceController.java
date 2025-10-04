package ke.tsuisekitsuru.tsuisekitsuru.controllers;

import ke.tsuisekitsuru.tsuisekitsuru.dtos.AttendanceRequestDTO;
import ke.tsuisekitsuru.tsuisekitsuru.dtos.GeneratedDatesDTO;
import ke.tsuisekitsuru.tsuisekitsuru.mapper.GeneratedDatesMapper;
import ke.tsuisekitsuru.tsuisekitsuru.models.Attendance;
import ke.tsuisekitsuru.tsuisekitsuru.repositories.AttendanceRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    private AttendanceRepository attendanceRepository;
    private GeneratedDatesMapper generatedDatesMapper;

    public AttendanceController(AttendanceRepository attendanceRepository, GeneratedDatesMapper generatedDatesMapper) {
        this.attendanceRepository = attendanceRepository;
        this.generatedDatesMapper = generatedDatesMapper;
    }

    @GetMapping
    public List<Attendance> getAllAttendances(){return attendanceRepository.findAll();}
//    @PostMapping("/date")
//    public Attendance createDateRange(@RequestParam("date")
//                                      @DateTimeFormat(pattern = "dd.mm.yyyy")LocalDate date){
//
//    }
//    @PostMapping
//    public Attendance addDate(@RequestBody Attendance dates){
//        return attendanceRepository.save(dates);
//    }
    @PostMapping("/addMultiple")
    public List<GeneratedDatesDTO> addMultipleDate(@RequestBody AttendanceRequestDTO dates){
        List<Attendance> savedDates = new ArrayList<>();
        LocalDate startDate = dates.getStartDate();
        int numberOfDays = dates.getNumberOfDays();

        for (int i = 0; i< numberOfDays; i++){
            Attendance attendance = new Attendance();
            attendance.setDate(startDate.plusDays(i));
            savedDates.add(attendance);
        }

        List<Attendance> saved = attendanceRepository.saveAll(savedDates);
        return generatedDatesMapper.datesToDTO(saved);
    }
    @PatchMapping("/{id}/setStatus")
    public Attendance changeStatus (@PathVariable("id") Long id, @RequestBody Attendance status){
        Attendance existingAttendance = attendanceRepository.findById(id).
                orElseThrow();
        Boolean statusChange = status.getStatus();
        existingAttendance.setStatus(statusChange);
        return attendanceRepository.save(existingAttendance);
    }
}
