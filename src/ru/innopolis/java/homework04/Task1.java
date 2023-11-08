package ru.innopolis.java.homework04;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите букву английского алфавита");

        System.out.println(findLeftLetter(scan.next()));
    }

    static String findLeftLetter (String letter) {
        String[] letterPool = "qwertyuiopasdfghjklzxcvbnm".split("");

        int position = -1;

        for (int i = 0; i < letterPool.length; i++) {
            if (letterPool[i].equals(letter)) {
                position = i;
                break;
            }
        }

        if (position == -1) {
            return "Вы ввели не букву английского алфавита";
        }
        else if (position == 0) {
            return letterPool[letterPool.length - 1];
        } else {
            return letterPool[position - 1];
        }
    }
}
