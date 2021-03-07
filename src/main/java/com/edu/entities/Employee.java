package com.edu.entities;

import lombok.NoArgsConstructor;

import java.util.Objects;
@NoArgsConstructor

public class Employee {
    private int id;
    private String name;
    private String surname;
    private String title;
    private int level;
    private Boolean active;

    public Employee(int id, String name, String surname, String title, int level, Boolean active) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.level = level;
        this.active = active;
    }

    public int getId() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId() && getLevel() == employee.getLevel() && getName().equals(employee.getName()) && getSurname().equals(employee.getSurname()) && getTitle().equals(employee.getTitle()) && getActive().equals(employee.getActive());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getTitle(), getLevel(), getActive());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", title='" + title + '\'' +
                ", level=" + level +
                ", active=" + active +
                '}';
    }
}
