package ke.tsuisekitsuru.tsuisekitsuru.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Dates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;

    @OneToMany
    @JoinColumn(name="attendance_id")
    private Set<UserAttendance> userAttendance = new HashSet<>();

    public Dates() {
    }

    public Dates(Long id, LocalDate date) {
        this.id = id;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<UserAttendance> getUserAttendance() {
        return userAttendance;
    }

    public void setUserAttendance(Set<UserAttendance> userAttendance) {
        this.userAttendance = userAttendance;
    }
}
