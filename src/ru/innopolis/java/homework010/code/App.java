package ru.innopolis.java.homework010.code;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] numbers = {11, 12, 42, 53, 657, 124, 745, 888, 1254};

        ByCondition conditionEven = number -> number % 2 == 0;

        System.out.println("Чётные числа" + Arrays.toString(Sequence.filter(numbers, conditionEven)));

        ByCondition conditionSumEven = number -> {
            int sum = 0;
            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }
            return sum % 2 == 0;
        };

        System.out.println("Числа сумма цифер которых чётна" + Arrays.toString(Sequence.filter(numbers, conditionSumEven)));
    }
}
