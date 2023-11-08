package ru.innopolis.java.homework01;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Task2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("СДЕЛАЙТЕ ВЫБОР:\n\t0 - Камень\n\t1 - Ножницы\n\t2 - Бумага");
        int playerChoice = scan.nextInt();
        playRockPaperScissors(playerChoice);
    }

    static void playRockPaperScissors(int playerChoice) {
        Random rand = new Random();
        int computerChoice = rand.nextInt(0, 3);

        switch (playerChoice) {
            case (0):
                System.out.println("Вы выбрали камень");
                break;
            case (1):
                System.out.println("Вы выбрали ножницы");
                break;
            case (2):
                System.out.println("Вы выбрали бумагу");
                break;
            default:
                System.out.println("Вы ввели некорректное число, попробуйте заново");
        }

        wait(1500);

        if (playerChoice < 0 || playerChoice > 2){
            System.out.println("Завершаем игру...");
        } else if (playerChoice == computerChoice) {
            System.out.println("Бот выбрал такой же вариант");
            wait(500);
            System.out.println("Ничья, у вас одинаковые ответы с ботом, сыграйте снова");
        } else if (playerChoice == 0) {
            if (computerChoice == 1) {
                System.out.println("Бот выбрал ножницы");
                wait(500);
                System.out.println("Вы выиграли!");
            } else {
                System.out.println("Бот выбрал бумагу");
                wait(500);
                System.out.println("Вы проиграли(");
            }
        } else if (playerChoice == 1) {
            if (computerChoice == 2) {
                System.out.println("Бот выбрал бумагу");
                wait(500);
                System.out.println("Вы выиграли!");
            } else {
                System.out.println("Бот выбрал камень");
                wait(500);
                System.out.println("Вы проиграли(");
            }
        } else {
            if (computerChoice == 0) {
                System.out.println("Бот выбрал камень");
                wait(500);
                System.out.println("Вы выиграли!");
            } else {
                System.out.println("Бот выбрал ножницы");
                wait(500);
                System.out.println("Вы проиграли(");
            }
        }
    }

    public static void wait(int ms) {
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
