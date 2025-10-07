package ke.tsuisekitsuru.tsuisekitsuru.dtos;


import java.time.LocalDate;

public class UserAttendanceResponseDTO {
    private String name;
    private LocalDate date;
    private boolean status;

    public UserAttendanceResponseDTO() {
    }

    public UserAttendanceResponseDTO(LocalDate date, String name, boolean status) {
        this.date = date;
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
