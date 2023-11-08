package main.java.secondHomework;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите степень в градусах Фаренгейта:");
        double fahrenheit = scan.nextInt();
        System.out.printf("%.1f градусов по Фаренгейту равны %.1f по Цельсию", fahrenheit, fahrenheitToCelsius(fahrenheit));
    }

    static double fahrenheitToCelsius (double Fahrenheit) {
        return (Fahrenheit - 32) * (5./9);
    }
}
