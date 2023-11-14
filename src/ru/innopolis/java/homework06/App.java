package ru.innopolis.java.homework06;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Person[] persons = createNewPerson(scan.nextLine());
        Product[] products = createNewProduct(scan.nextLine());

        String ending = "start";

        while(!ending.equals("END")) {
            ending = scan.nextLine();
            findProductAndPerson(ending, persons, products);
        }
        for (Person el: persons) {
            System.out.print(el.showGroceryBag());
        }
    }

    //коды в двух функциях одинаковые с отличием лишь в классах, чьи экземпляры создаются
    static Person[] createNewPerson(String personStr) {
        // обработка строки, убираем лишние пробелы
        String[] personsMas = personStr.replaceAll("\\s+", " ").split("[,:;]");
        Person[] newPersons = new Person[personsMas.length];
        for (int i = 0; i < newPersons.length; i++) {
            newPersons[i] = new Person(
                    personsMas[i].split(" = ")[0].trim(),
                    Integer.parseInt(personsMas[i].split(" = ")[1].trim())
            );
        }
        return newPersons;
    }

    static Product[] createNewProduct(String productStr) {
        String[] productMas = productStr.replaceAll("\\s+", " ").split("[,:;]");
        Product[] newProducts = new Product[productMas.length];
        for (int i = 0; i < newProducts.length; i++) {
            newProducts[i] = new Product(
                    productMas[i].split(" = ")[0].trim(),
                    Integer.parseInt(productMas[i].split(" = ")[1].trim())
            );
        }
        return newProducts;
    }

    static void findProductAndPerson(String personWant, Person[] person, Product[] products) {
        // я решил сравнивать только символы строк чтобы избежать ошибки, поэтому избавился от всех пробелов
        personWant = personWant.replaceAll(" ", "");
        for (Person value : person) {
            if (personWant.contains(value.getName().replaceAll(" ", ""))) {
                for (Product product : products) {
                    if (personWant.contains(product.getName().replaceAll(" ", ""))) {
                        if (value.getMoneySum() >= product.getPrice()) {
                            value.setMoneySum(value.getMoneySum() - product.getPrice());
                            value.addProduct(product);
                            System.out.printf("%s купил %s%n", value.getName(), product.getName());
                        } else {
                            System.out.printf("%s не может позволить себе %s%n", value.getName(), product.getName());
                        }
                        return;
                    }
                }
            }
        }
    }
}
