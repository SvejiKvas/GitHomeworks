package ru.innopolis.java.homework06;

import java.util.Scanner;

public class DiscountApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DiscountProduct[] dpMas = new DiscountProduct[0];

        String ending;
        do {
            ending = scanner.nextLine();
            if (ending.equals("END")) {
                break;
            }
            String[] input = ending.split("[=,;]");
            if (input.length > 2) {
                dpMas = addProduct(new DiscountProduct(ending), dpMas);
            } else {
                dpMas = addProduct(new DiscountProduct(new Product(ending)), dpMas);
            }
        } while (!ending.equals("END"));

        StringBuilder sbSale = new StringBuilder("Акционные продукты: ");
        StringBuilder sbCommon = new StringBuilder("Обычные продукты: ");

        for (DiscountProduct el : dpMas) {
            if (el.getDiscount() > 0) {
                sbSale.append(el.getName());
                sbSale.append(", ");
            } else {
                sbCommon.append(el.getName());
                sbCommon.append(", ");
            }
        }
        sbSale.delete(sbSale.length() - 2, sbSale.length());
        sbCommon.delete(sbCommon.length() - 2, sbCommon.length());

        System.out.printf("%s%n%s%n", sbSale, sbCommon);
    }
    static DiscountProduct[] addProduct(DiscountProduct dp , DiscountProduct[] dpMas) {
        int currentLength = dpMas.length;
        int newLength = currentLength + 1;

        DiscountProduct[] newBag = new DiscountProduct[newLength];
        System.arraycopy(dpMas, 0, newBag, 0, currentLength);
        newBag[currentLength] = dp;

        return newBag;
    }
}
