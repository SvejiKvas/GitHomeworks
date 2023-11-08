package main.java.fourthHomework;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder str = new StringBuilder(scan.nextLine());

        System.out.printf("Количество стрел в строке: %d", findArrows(str));
    }

    static int findArrows(StringBuilder str) {
        int count = 0;

        if (str.length() < 5) {
            return 0;
        }

        for (int i = 0; i <= str.length() - 5; i++) {
            String subs = str.substring(i, i + 5);
            if (subs.contentEquals(">>-->") || subs.contentEquals("<--<<")) {
                count++;
            }
        }
        return count;
    }
}
