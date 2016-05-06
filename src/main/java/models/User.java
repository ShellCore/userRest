package models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    private int id;
    private String name;
    private String lastName;
    private String email;

    @Id
    @Column(name = "usr_id")
    public int getId() {
        return id;
    }

    public void setId(int usrId) {
        this.id = usrId;
    }

    @Basic
    @Column(name = "usr_name")
    public String getName() {
        return name;
    }

    public void setName(String usrName) {
        this.name = usrName;
    }

    @Basic
    @Column(name = "usr_last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String usrLastName) {
        this.lastName = usrLastName;
    }

    @Basic
    @Column(name = "usr_email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String usrEmail) {
        this.email = usrEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String id = String.valueOf(getId());
        String name = getName() != null ? getName() : "";
        String lastName = getLastName() != null ? getLastName() : "";
        String email = getEmail() != null ? getEmail() : "";
        return "User: " + id + ": " + name + " " + lastName + ", " + email;
    }
}
