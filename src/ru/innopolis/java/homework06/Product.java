package ru.innopolis.java.homework06;

public class Product {
    private String name;
    private int price;
    public Product(String name, int price) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной");
        }
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format(
                "Name: %s%n" +
                "Price: %s%n",
                this.name, this.price
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return
                this.name.equals(((Product) obj).name) &&
                this.price == ((Product) obj).getPrice();
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = result * 17 + name.hashCode();
        result = result * 17 + price;
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}