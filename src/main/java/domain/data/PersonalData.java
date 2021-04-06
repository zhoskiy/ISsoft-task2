package domain.data;

import java.util.Date;

public class PersonalData {
    private Date birthday;
    private String name;
    private String surname;
    private String address;

    public PersonalData(Date birthday, String name, String surname, String address) {
        this.birthday = birthday;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
