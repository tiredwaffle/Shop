package com.edu.entities;

import lombok.NoArgsConstructor;

import java.util.Objects;
@NoArgsConstructor
public class Item {
    private int id;
    private float amountAvailable;
    private float weight;
    private float price;
    private String name;

    public Item(int id, float amountAvailable, float weight, float price, String name) {
        this.id = id;
        this.amountAvailable = amountAvailable;
        this.weight = weight;
        this.price = price;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAmountAvailable() {
        return amountAvailable;
    }

    public void setAmountAvailable(float amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return getId() == item.getId() && Float.compare(item.getAmountAvailable(), getAmountAvailable()) == 0 && Float.compare(item.getWeight(), getWeight()) == 0 && Float.compare(item.getPrice(), getPrice()) == 0 && getName().equals(item.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAmountAvailable(), getWeight(), getPrice(), getName());
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", amountAvailable=" + amountAvailable +
                ", weight=" + weight +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
