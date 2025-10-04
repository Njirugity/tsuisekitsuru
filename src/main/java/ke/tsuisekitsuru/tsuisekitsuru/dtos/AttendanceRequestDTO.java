package ke.tsuisekitsuru.tsuisekitsuru.dtos;

import java.time.LocalDate;

public class AttendanceRequestDTO {
    private LocalDate startDate;
    private int numberOfDays;

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }
}
