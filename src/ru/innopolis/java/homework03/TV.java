package ru.innopolis.java.homework03;

public class TV {
    private String brand;
    private int diagonal;
    private int refreshRate;
    private boolean have4kDisplay;

    public TV() {
    }

    public TV(String brand,
              int diagonal,
              int refreshRate,
              boolean have4kDisplay) {
        this.brand = brand;
        this.diagonal = diagonal;
        this.refreshRate = refreshRate;
        this.have4kDisplay = have4kDisplay;
    }
    public TV(String brand,
              int diagonal) {
        this.brand = brand;
        this.diagonal = diagonal;
        this.refreshRate = 60;
        this.have4kDisplay = false;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public boolean isHave4kDisplay() {
        return have4kDisplay;
    }

    public String toString() {
        String display4kPointer = this.have4kDisplay ? "Yes" : "No";
        return String.format("Brand: %s%nDiagonal: %s%nRefreshRate: %s%nHave 4k display: %s%n",
                this.brand, this.diagonal, this.refreshRate, display4kPointer);
    }
}
