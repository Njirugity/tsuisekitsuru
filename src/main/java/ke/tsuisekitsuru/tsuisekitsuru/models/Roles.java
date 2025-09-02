package ke.tsuisekitsuru.tsuisekitsuru.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

//    @OneToMany(mappedBy = "roles", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIdentityInfo(
//            generator = ObjectIdGenerators.PropertyGenerator.class,
//            property = "id"
//    )
//    private Set<Users> users = new HashSet<>();
    public Roles() {
    }

    public Roles(Long id, String name) {
        this.id = id;
        this.name = name;
    }

//    public Set<Users> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<Users> users) {
//        this.users = users;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
