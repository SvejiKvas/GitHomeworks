package ru.innopolis.java.homework08;

import java.util.Arrays;

public class Person {
    private String name;
    private int money;
    private Product[] groceryBag;

    public Person(String name, int money) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустой строкой");
        }
        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательным числом");
        }
        this.name = name;
        this.money = money;
        groceryBag = new Product[] {};
    }
    public Person(String allInfo) {
        String[] strConstructor = allInfo.split("=");
        String name = strConstructor[0].trim();
        int money = Integer.parseInt(strConstructor[1].trim());

        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустой строкой");
        }
        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательным числом");
        }

        this.name = name;
        this.money = money;
        this.groceryBag = new Product[] {};
    }

    public void addProduct(Product newProduct) {
        int pastLength = this.groceryBag.length;
        int newLength = pastLength + 1;

        Product[] newBag;
        newBag = new Product[newLength];
        System.arraycopy(this.groceryBag, 0, newBag, 0, pastLength);
        newBag[pastLength] = newProduct;

        this.groceryBag = newBag;
    }

    public String showGroceryBag () {
        if (this.groceryBag.length != 0) {
            StringBuilder sb = new StringBuilder(this.getName() + " - ");
            for (Product product : this.groceryBag) {
                sb.append(product.getName().toLowerCase()).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            return sb.toString();
        } else {
            return String.format("%s - ничего не куплено", this.getName());
        }
    }
    @Override
    public String toString () {
        return String.format(
                "Name: %s%n" + "Money: %s%n",
                this.getName(),this.getMoney()
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
                        this.money == ((Person) obj).getMoney() &&
                        Arrays.equals(this.groceryBag, ((Person) obj).groceryBag);
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = result * 17 + name.hashCode();
        result = result * 17 + money;
        result = result * 17 + Arrays.hashCode(groceryBag);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Product[] getGroceryBag() {
        return groceryBag;
    }

    public void setGroceryBag(Product[] groceryBag) {
        this.groceryBag = groceryBag;
    }
}
