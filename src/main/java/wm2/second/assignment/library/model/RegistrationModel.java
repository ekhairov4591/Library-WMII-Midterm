package wm2.second.assignment.library.model;

import java.io.Serializable;

// Pojo Object
public class RegistrationModel implements Serializable {
    private String firstname;
    private String lastname;
    private String birthday;
    private String password;

    public RegistrationModel() {
    }

    public RegistrationModel(String firstname, String lastname, String birthday, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RegistrationModel{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthday='" + birthday + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
