package ru.innopolis.java.homework03;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        String[] namesMas = new String[] {
                "LG", "Sony", "Panasonic", "Philips", "Samsung",
                "TCL", "Hisense", "Grundig", "Huawei", "Motorola"}; // список чтобы не тестировать код долго

        TV[] classMas = new TV[10];

        for (int i = 0; i < 10; i++) {
            classMas[i] = new TV(
                    namesMas[i],
                    rand.nextInt(0, 1000),
                    rand.nextInt(0, 95),
                    rand.nextBoolean()
            );
        }

        int maxVolume = scan.nextInt();
        maxVolume = (maxVolume < 50) ? 50 : (Math.min(maxVolume, 70));

        for (TV el: classMas) {
            if (el.isOn() && el.getVolume() <= maxVolume) {
                System.out.println(el.getBrand() + "'s volume: " + el.getVolume());
            }
        }
    }
}
