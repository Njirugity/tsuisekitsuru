package ke.tsuisekitsuru.tsuisekitsuru.controllers;

import ke.tsuisekitsuru.tsuisekitsuru.dtos.DatesRequestDTO;
import ke.tsuisekitsuru.tsuisekitsuru.dtos.GeneratedDatesDTO;
import ke.tsuisekitsuru.tsuisekitsuru.dtos.UserAttendanceRequestDTO;
import ke.tsuisekitsuru.tsuisekitsuru.dtos.UserAttendanceResponseDTO;
import ke.tsuisekitsuru.tsuisekitsuru.mapper.GeneratedDatesMapper;
import ke.tsuisekitsuru.tsuisekitsuru.mapper.UserAttendanceResponseMapper;
import ke.tsuisekitsuru.tsuisekitsuru.models.Dates;
import ke.tsuisekitsuru.tsuisekitsuru.models.UserAttendance;
import ke.tsuisekitsuru.tsuisekitsuru.models.Users;
import ke.tsuisekitsuru.tsuisekitsuru.repositories.DatesRepository;
import ke.tsuisekitsuru.tsuisekitsuru.repositories.UserAttendanceRepository;
import ke.tsuisekitsuru.tsuisekitsuru.repositories.UsersRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dates")
public class DatesController {
    private DatesRepository datesRepository;
    private UserAttendanceRepository userAttendanceRepository;
    private UsersRepository usersRepository;
    private GeneratedDatesMapper generatedDatesMapper;
    private UserAttendanceResponseMapper userAttendanceResponseMapper;

    public DatesController(
            DatesRepository datesRepository, GeneratedDatesMapper generatedDatesMapper,
            UserAttendanceRepository userAttendanceRepository, UsersRepository usersRepository,
            UserAttendanceResponseMapper userAttendanceResponseMapper) {
        this.datesRepository = datesRepository;
        this.generatedDatesMapper = generatedDatesMapper;
        this.userAttendanceRepository = userAttendanceRepository;
        this.usersRepository = usersRepository;
        this.userAttendanceResponseMapper = userAttendanceResponseMapper;
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
    @PostMapping("/markAttendance")
    public ResponseEntity<?> markAttendance (@RequestBody UserAttendanceRequestDTO request){
        Users user = usersRepository.findById(request.getUserId()).
                orElseThrow(()-> new RuntimeException("User not found"));
        Dates date = datesRepository.findById(request.getAttendanceId()).
                orElseThrow(()-> new RuntimeException("Date not found"));

        UserAttendance updateRecord = new UserAttendance();
        updateRecord.setUsers(user);
        updateRecord.setDates(date);
        updateRecord.setStatus(request.isStatus());
        userAttendanceRepository.save(updateRecord);
        return ResponseEntity.ok("Attendance marked successfully");
    }

    @GetMapping("/attendanceRecord")
    public List<UserAttendanceResponseDTO> getAllAttendance(){
        List<UserAttendance> attendanceRecord = userAttendanceRepository.findAll();
        return userAttendanceResponseMapper.userAttendanceToDTOList(attendanceRecord);
    }
}
