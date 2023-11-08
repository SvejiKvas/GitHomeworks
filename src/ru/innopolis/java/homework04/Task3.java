package ru.innopolis.java.homework04;

import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] strings = scan.nextLine().split(" ");

        System.out.printf("Исправленная строка: %s", repairWords(strings));
    }

    static String repairWords (String[] words) {
        StringBuilder sb = new StringBuilder();

        String[] wordOne = words[0].split("");
        Arrays.sort(wordOne);
        String[] wordTwo = words[1].split("");
        Arrays.sort(wordTwo);

        for (String s : wordOne) {
            sb.append(s);
        }

        sb.append(" ");

        for (String s : wordTwo) {
            sb.append(s);
        }

        return sb.toString();
    }
}

