package ru.innopolis.java.homework06;

import java.util.Arrays;

public class Person {
    private String name;
    private int moneySum;
    private Product[] groceryBag;

    public Person() {
        this.name = "unnamed";
        this.moneySum = 0;
    }

    public Person(String name, int moneySum) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (moneySum < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }
        this.name = name;
        this.moneySum = moneySum;
        this.groceryBag = new Product[] {};
    }
    public Person (String name, int moneySum, Product[] groceryBag) {
        this.name = name;
        this.moneySum = moneySum;
        this.groceryBag = groceryBag;
    }

    @Override
    public String toString () {
        StringBuilder groceryBag = new StringBuilder();
        for (Product product : this.groceryBag) {
            groceryBag.append(product.getName());
            groceryBag.append(" ");
        }
        return String.format(
                "Name: %s%n" +
                "Money: %s%n" +
                "Grocery bag: %s%n",
                this.name, this.moneySum, groceryBag
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
                this.name.equals(((Person) obj).name) &&
                this.moneySum == ((Person) obj).getMoneySum() &&
                Arrays.equals(this.groceryBag, ((Person) obj).groceryBag);
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = result * 17 + name.hashCode();
        result = result * 17 + moneySum;
        result = result * 17 + Arrays.hashCode(groceryBag);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoneySum() {
        return moneySum;
    }

    public void setMoneySum(int moneySum) {
        this.moneySum = moneySum;
    }

    public Product[] getGroceryBag() {
        return groceryBag;
    }

    public void setGroceryBag(Product[] groceryBag) {
        this.groceryBag = groceryBag;
    }

    public void addProduct(Product newProduct) {
        int currentLength = this.groceryBag.length;
        int newLength = currentLength + 1;

        Product[] newBag = new Product[newLength];
        System.arraycopy(this.groceryBag, 0, newBag, 0, currentLength);
        newBag[currentLength] = newProduct;

        this.groceryBag = newBag;
    }

    public String showGroceryBag() {
        if (this.groceryBag.length != 0) {
            StringBuilder productsInBag = new StringBuilder();
            for (Product product: this.groceryBag) {
                productsInBag.append(product.getName());
                productsInBag.append(", ");
            }
            productsInBag.delete(productsInBag.length() - 2, productsInBag.length());
            return String.format(
                    "%s - %s\n",
                    this.name, productsInBag
            );
        } else {
            return String.format(
                    "%s - Ничего не куплено", this.name);
        }
    }
}
