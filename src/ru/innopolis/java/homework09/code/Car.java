package ru.innopolis.java.homework09.code;

import java.util.Objects;

public class Car {
    private String mark;
    private String model;
    private int yearOfIssue;
    private int power;
    private int acceleration;
    private int suspension;
    private int durability;

    public Car () {
        this.mark = "default mark";
        this.model = "default model";
    }
    public Car (String mark,
                String model,
                int yearOfIssue,
                int power,
                int acceleration,
                int suspension,
                int durability) {
        this.mark = mark;
        this.model = model;
        this.yearOfIssue = yearOfIssue;
        this.power = power;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public int getSuspension() {
        return suspension;
    }

    public void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    @Override
    public String toString() {
        String format;
        format = String.format(
                "Mark: %s%n" +
                        "Model: %s%n" +
                        "Year of issue: %d%n" +
                        "Power: %d%n" +
                        "Acceleration: %d%n" +
                        "Suspension: %d%n" +
                        "Durability: %d%n",
                mark, model, yearOfIssue,
                power, acceleration,
                suspension, durability
        );
        return format;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return
                Objects.equals(mark, ((Car) obj).mark) &&
                Objects.equals(model, ((Car) obj).model) &&
                yearOfIssue == ((Car) obj).yearOfIssue &&
                power == ((Car) obj).power &&
                acceleration == ((Car) obj).acceleration &&
                suspension == ((Car) obj).suspension &&
                durability == ((Car) obj).durability;
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = result * 17 + mark.hashCode();
        result = result * 17 + model.hashCode();
        result = result * 17 + yearOfIssue;
        result = result * 17 + power;
        result = result * 17 + acceleration;
        result = result * 17 + suspension;
        result = result * 17 + durability;
        return result;
    }
}
