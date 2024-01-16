package ru.innopolis.java.homework09.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Garage {
    private Car[] parkedCars;

    Garage () {
        parkedCars = new Car[] {};
    }
    Garage (Car[] parkedCars) {
        this.parkedCars = parkedCars;
    }

    @Override
    public String toString () {
        return String.format("Parked cars: %s%n",
                showParkedCars());
    }

    public String showParkedCars () {
        StringBuilder sb = new StringBuilder();
        for (Car cars: parkedCars) {
            sb.append(cars.getMark());
            sb.append(", ");
        }
        if (sb.length() > 2) {
            sb.delete(sb.length() - 2, sb.length());
            return sb.toString();
        }
        else {
            return "it's empty";
        }
    }

    public void addCar(Car car) {

        Car[] newParkedCars = new Car[parkedCars.length + 1];
        System.arraycopy(parkedCars, 0, newParkedCars, 0, parkedCars.length);
        newParkedCars[parkedCars.length] = car;
        parkedCars = newParkedCars;

        System.out.println("Машина добавлена в гараж");
    }

    public void upgradeCar (Car car) {

        List<Car> carList = new ArrayList<>(Arrays.asList(parkedCars));

        if(!carList.contains(car)){
            System.out.println("Такой машины нет в гараже");
            return;
        }

        System.out.println("Выберите часть которую хотите улучшить\n" +
                "м - мощность\n" +
                "у - ускорение\n" +
                "п - подвеска\n");
        Scanner scan = new Scanner(System.in);
        String partToUpgrade = scan.next();
        System.out.println("Введите число на которое нужно умножить значение части");
        int multiplyValue = scan.nextInt();
        switch (partToUpgrade){
            case "м" -> {
                car.setPower(car.getPower() * multiplyValue);
                System.out.println("Cтало " + car.getPower());
            }
            case "у" -> {
                car.setAcceleration(car.getAcceleration() * multiplyValue);
                System.out.println("Cтало " + car.getAcceleration());
            }
            case "п" -> {
                car.setSuspension(car.getSuspension() * multiplyValue);
                System.out.println("Cтало " + car.getSuspension());
            }
            default -> System.out.println("Вы ввели не ту букву");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        return Arrays.equals(parkedCars, ((Garage) obj).parkedCars);
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = result * 17 + Arrays.hashCode(parkedCars);
        return result;
    }

    public void setParkedCars(Car[] parkedCars) {
        this.parkedCars = parkedCars;
    }

    public Car[] getParkedCars() {
        return parkedCars;
    }
}
