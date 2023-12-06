package ru.innopolis.java.homework08;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class App {
    public static void main(String[] args) throws IOException {
        String inputPath = "C:\\Users\\Dayal\\Desktop\\GitHomeworks\\src\\ru\\innopolis\\java\\homework08\\input.txt";
        String outputPath = "C:\\Users\\Dayal\\Desktop\\GitHomeworks\\src\\ru\\innopolis\\java\\homework08\\output.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath, StandardCharsets.UTF_8));

        Person[] persons = createPersons(bufferedReader.readLine());
        Product[] products = createProducts(bufferedReader.readLine());

        String ending;
        while (true) {
            ending = bufferedReader.readLine();
            if (ending.equals("END")) {
                break;
            }
            for (Person person : persons) {
                if (ending.startsWith(person.getName())) {
                    for (Product product : products) {
                        if (ending.endsWith(product.getName())) {
                            if (person.getMoney() >= product.getPrice()) {
                                person.setMoney(person.getMoney() - product.getPrice());
                                bufferedWriter.write(person.getName() + " купил(а) " + product.getName().toLowerCase());
                                person.addProduct(product);
                            } else {
                                bufferedWriter.write( person.getName() + " не может позволить купить " + product.getName().toLowerCase());
                            }
                            bufferedWriter.newLine();
                        }
                    }
                }
            }
        }
        bufferedWriter.newLine();

        for(Person person: persons) {
            bufferedWriter.write(person.showGroceryBag());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    private static Person[] createPersons(String personsStr) {
        String[] personMas = personsStr.split("[;,.]");
        Person[] persons = new Person[personMas.length];
        for (int i = 0; i < personMas.length; i++) {
             persons[i] = new Person(personMas[i]);
        }
        return persons;
    }

    private static Product[] createProducts(String productStr) {
        String[] productMas = productStr.split("[;,.]");
        Product[] products = new Product[productMas.length];
        for (int i = 0; i < productMas.length; i++) {
            products[i] = new Product(productMas[i]);
        }
        return products;
    }
}
