package ke.tsuisekitsuru.tsuisekitsuru.dtos;

import ke.tsuisekitsuru.tsuisekitsuru.models.Roles;

public class UserRolesDTO {
    private String name;
    private String email;
    private Roles roles;

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
