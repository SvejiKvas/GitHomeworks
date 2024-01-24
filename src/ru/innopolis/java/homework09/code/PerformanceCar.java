package ru.innopolis.java.homework09.code;

import java.util.Arrays;

public class PerformanceCar extends Car{
    private String[] addOns;

    public PerformanceCar () {
        this.addOns = new String[] {};
        upgradeStats();
    }
    public PerformanceCar (
            String mark,
            String model,
            int yearOfIssue,
            int power,
            int acceleration,
            int suspension,
            int durability
    ) {
        super(
                mark,
                model,
                yearOfIssue,
                power,
                acceleration,
                suspension ,
                durability
        );
        this.addOns = new String[] {};
        upgradeStats();
    }

    public String[] getAddOns() {
        return addOns;
    }

    public void setAddOns(String[] addOns) {
        this.addOns = addOns;
    }

    @Override
    public String toString () {
        return super.toString() + String.format("AddOns: %s%n", showComponents(addOns));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }

        return Arrays.equals(this.addOns, ((PerformanceCar) obj).addOns);
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = result * 17 + super.hashCode();
        result = result * 17 + Arrays.hashCode(addOns);
        return result;
    }


    private String showComponents (String[] addOns) {
        StringBuilder sb = new StringBuilder();
        for (String str: addOns) {
            sb.append(str);
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

    private void upgradeStats() {
        this.setPower((int)(this.getPower() * 1.5));
        this.setSuspension((int)(this.getSuspension() * 0.75));
    }
}
