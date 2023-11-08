package main.java.secondHomework;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите первое целое число");
        int firstDigit = scan.nextInt();
        System.out.println("Введите второе целое число");
        int secondDigit = scan.nextInt();

        System.out.println("----------------------------------------");

        System.out.printf("Сумма двух целых чисел: %d\n", firstDigit + secondDigit);
        System.out.printf("Разница двух целых чисел: %d\n", firstDigit - secondDigit);
        System.out.printf("Произведение из двух целых чисел: %d\n", firstDigit * secondDigit);
        System.out.printf("Среднее из двух целых чисел: %.2f\n", (firstDigit + secondDigit) / 2. );
        System.out.printf("Расстояние двух целых чисел: %d\n", Math.abs(firstDigit - secondDigit));
        System.out.printf("Максимальное целое число: %d\n", Math.max(firstDigit, secondDigit));
        System.out.printf("Минимальное целое число: %d\n", Math.min(firstDigit, secondDigit));
    }
}
