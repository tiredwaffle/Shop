package com.edu.entities;

import lombok.NoArgsConstructor;

import java.util.Objects;
@NoArgsConstructor
public class CheckItem {
    private int id;
    private int checkId;
    private int itemId;
    private float itemAmount;
    private float itemWeight;
    private float itemPrice;
    private Boolean active;

    public CheckItem(int id, int checkId, int itemId, float itemAmount, float itemWeight, float itemPrice, Boolean active) {
        this.id = id;
        this.checkId = checkId;
        this.itemId = itemId;
        this.itemAmount = itemAmount;
        this.itemWeight = itemWeight;
        this.itemPrice = itemPrice;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCheckId() {
        return checkId;
    }

    public void setCheckId(int checkId) {
        this.checkId = checkId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public float getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(float itemAmount) {
        this.itemAmount = itemAmount;
    }

    public float getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(float itemWeight) {
        this.itemWeight = itemWeight;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
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
        if (!(o instanceof CheckItem)) return false;
        CheckItem checkItem = (CheckItem) o;
        return getId() == checkItem.getId() && getCheckId() == checkItem.getCheckId() && getItemId() == checkItem.getItemId() && Float.compare(checkItem.getItemAmount(), getItemAmount()) == 0 && Float.compare(checkItem.getItemWeight(), getItemWeight()) == 0 && Float.compare(checkItem.getItemPrice(), getItemPrice()) == 0 && getActive().equals(checkItem.getActive());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCheckId(), getItemId(), getItemAmount(), getItemWeight(), getItemPrice(), getActive());
    }

    @Override
    public String toString() {
        return "CheckItem{" +
                "id=" + id +
                ", checkId=" + checkId +
                ", itemId=" + itemId +
                ", itemAmount=" + itemAmount +
                ", itemWeight=" + itemWeight +
                ", itemPrice=" + itemPrice +
                ", active=" + active +
                '}';
    }
}
