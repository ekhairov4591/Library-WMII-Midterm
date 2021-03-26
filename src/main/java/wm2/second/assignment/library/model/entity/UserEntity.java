package wm2.second.assignment.library.model.entity;

import wm2.second.assignment.library.model.dto.RegistrationModel;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Type was AUTO
    @Column(name="id")
    private Long id;

    private String firstname;
    private String lastname;
    private String birthday;
    private String email;
    private String password;

    public UserEntity(){

    }

    public UserEntity(RegistrationModel registrationModel) {
        this.firstname = registrationModel.getFirstname();
        this.lastname = registrationModel.getLastname();
        this.birthday = registrationModel.getBirthday();
        this.email = registrationModel.getEmail();
        this.password = registrationModel.getPassword();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}