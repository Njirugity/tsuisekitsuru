package ke.tsuisekitsuru.tsuisekitsuru.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Projects extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private String description;
    private String code;
    private LocalDate startDate;
    private LocalDate endDate;


    @OneToMany(mappedBy = "projects", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Users> users = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Projects() {
    }

    public Projects(Long id, String location, String description, String code, LocalDate startDate, LocalDate endDate ) {
        this.id = id;
        this.location = location;
        this.description = description;
        this.code = code;
        this.startDate= startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
