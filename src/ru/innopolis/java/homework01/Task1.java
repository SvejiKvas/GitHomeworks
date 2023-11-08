package ru.innopolis.java.homework01;

import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        Random rand = new Random();

        int digit1 = rand.nextInt(-10, 11);
        int digit2 = rand.nextInt(-10, 11);
        int digit3 = rand.nextInt(-10, 11);
        int digit4 = rand.nextInt(-10, 11);

        printFourNumbers(digit1, digit2, digit3, digit4);
    }

    static void printFourNumbers (int a, int b, int c, int d) {
        System.out.printf("%d %d %d %d", a, b, c, d);
    }
}
