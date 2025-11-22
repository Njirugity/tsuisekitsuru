package ke.tsuisekitsuru.tsuisekitsuru.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ProjectsDTO {
    @NotBlank(message = "Project location is required")
    @Size(max = 256)
    private String location;

    @Size(max = 256)
    private String description;

    @Size(max = 56)
    private String code;

    @NotNull(message = "Project commencement date is required")
    private LocalDate startDate;

    @NotNull(message = "Project expected completion date is required")
    private LocalDate endDate;

    public ProjectsDTO(String description, String location, String code, LocalDate startDate, LocalDate endDate) {
        this.description = description;
        this.location = location;
        this.code = code;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
