package ru.innopolis.java.homework02;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите исходную строку");
        String word = scan.nextLine();
        System.out.println("Введите количество итераций");
        int count = scan.nextInt();
        printSeveralTimes(word, count);
    }

    static void printSeveralTimes(String word, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(word);
        }
    }
}
