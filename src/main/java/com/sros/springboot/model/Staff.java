package com.sros.springboot.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Staff {

    @Positive
    @NotNull
    private long id;

    @NotBlank
    @Size(min = 5, max = 50)
    private String name;

    @NotBlank
    @Size(min = 1, max = 1)
    private char gender;

    @Size(min = 1, max = 200)
    private String address;

    @NotBlank
    @Size(min = 1, max = 50)
    private Position position;

    private boolean active;
    private String photo;

    public Staff() {
    }

    public Staff(long id, String name, char gender, String address, Position position, boolean active, String photo) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.position = position;
        this.active = active;
        this.photo = photo;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", position=" + position +
                ", active=" + active +
                ", photo='" + photo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return id == staff.id &&
                gender == staff.gender &&
                active == staff.active &&
                Objects.equals(name, staff.name) &&
                Objects.equals(address, staff.address) &&
                Objects.equals(position, staff.position) &&
                Objects.equals(photo, staff.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, address, position, active, photo);
    }
}
