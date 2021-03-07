package com.edu.entities;

import lombok.NoArgsConstructor;

import java.util.Objects;
@NoArgsConstructor

public class Check {
    private int id;
    private int createdBy;
    private float amount;
    private Boolean active;

    public Check(int id, int createdBy, float amount, Boolean active) {
        this.id = id;
        this.createdBy = createdBy;
        this.amount = amount;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
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
        if (!(o instanceof Check)) return false;
        Check check = (Check) o;
        return getId() == check.getId() && getCreatedBy() == check.getCreatedBy() && Float.compare(check.getAmount(), getAmount()) == 0 && getActive().equals(check.getActive());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCreatedBy(), getAmount(), getActive());
    }

    @Override
    public String toString() {
        return "Check{" +
                "id=" + id +
                ", created by=" + createdBy +
                ", amount=" + amount +
                ", active=" + active +
                '}';
    }
}