package ru.innopolis.java.homework010.code;

public class Sequence{
    public static int[] filter(int[] array, ByCondition condition) {

        int correctMasLenght = 0;

        for (int j : array) {
            if (condition.isOk(j)) {
                correctMasLenght++;
            }
        }

        int[] correctMas = new int[correctMasLenght];
        int correctMasIndex = 0;

        for (int j : array) {
            if (condition.isOk(j)) {
                correctMas[correctMasIndex] = j;
                correctMasIndex++;
            }
        }
        return correctMas;
    }
}
