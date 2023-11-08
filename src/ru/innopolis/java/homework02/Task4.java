package main.java.secondHomework;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] figureSize = {0, 0};

        System.out.println("Введите размерность сетки и повторяющийся элемент\n" +
                "Всё через пробелы!!!\n\t" +
                "1 число - квадрат,\n\t" +
                "2 числа - прямоугольник, сначала длинна потом ширина\n");
        figureSize[0] = scan.nextInt();
        try {
            figureSize[1] = scan.nextInt();
        } catch (InputMismatchException e) {
            figureSize[1] = 0;
        }
        String element = scan.nextLine();

        if (figureSize[1] == 0) {
            printCube(figureSize[0], element);
        } else {
            printRectangle(figureSize[0], figureSize[1], element);
        }

    }

    static void printCube(int size, String element) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(element);
            }
            System.out.println();
        }
    }

    static void printRectangle(int height, int width, String element) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
}
