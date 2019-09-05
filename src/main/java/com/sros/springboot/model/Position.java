package com.sros.springboot.model;

import java.util.Objects;

public class Position {

    private long id;
    private String position;

    public Position() {
    }

    public Position(int id, String position) {
        this.id = id;
        this.position = position;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", position='" + position + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return id == position1.id && Objects.equals(position, position1.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, position);
    }
}
