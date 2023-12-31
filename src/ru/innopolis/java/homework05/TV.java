package ru.innopolis.java.homework05;

public class TV {
    private String brand;
    private int diagonal;
    private int refreshRate;
    private boolean have4kDisplay;

    private int activeChannelNumber;
    private int volume;
    private boolean isOn;

    public TV() {
    }

    public TV(String brand,
              int activeChannelNumber,
              int volume,
              boolean isOn) {
        this.brand = brand;
        this.activeChannelNumber = activeChannelNumber;
        this.volume = volume;
        this.isOn = isOn;
    }

    public TV(String brand,
              int diagonal) {
        this.brand = brand;
        this.diagonal = diagonal;
        this.refreshRate = 60;
        this.have4kDisplay = false;
    }


    public String toString() {
        String className = this.getClass().getName();
        String display4kPointer = this.have4kDisplay ? "Yes" : "No";
        String isOnPointer = this.isOn ? "Yes" : "No";
        return String.format(
                    "Class name: %s%n" +
                    "Brand: %s%n" +
                    "Diagonal: %s%n" +
                    "RefreshRate: %s%n" +
                    "Have 4k display: %s%n" +
                    "Active channel number: %s%n" +
                    "Volume: %s%n" +
                    "TV is on: %s%n",
                className,
                this.brand,
                this.diagonal,
                this.refreshRate,
                display4kPointer,
                activeChannelNumber,
                volume,
                isOnPointer);
    }

    @Override
    public boolean equals (Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return
                this.brand.equals(((TV) obj).brand) &&
                this.diagonal == ((TV) obj).diagonal &&
                this.refreshRate == ((TV) obj).refreshRate &&
                this.have4kDisplay == ((TV) obj).isHave4kDisplay() && this.activeChannelNumber == ((TV) obj).activeChannelNumber &&
                this.volume == ((TV) obj).volume &&
                this.isOn == ((TV) obj).isOn;
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = result * 17 + brand.hashCode();
        result = result * 17 + diagonal;
        result = result * 17 + refreshRate;
        result = result * 17 + (have4kDisplay ? 1 : 0);
        result = result * 17 + activeChannelNumber;
        result = result * 17 + volume;
        result = result * 17 + (isOn ? 1 : 0);
        return result;
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

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume <= 100 && volume >= 0) {
            this.volume = volume;
        } else if (volume > 100) {this.volume = 100;}
        else {this.volume = 0;}
    }

    public int getActiveChannelNumber() {
        return activeChannelNumber;
    }

    public void setActiveChannelNumber(int activeChannelNumber) {
        this.activeChannelNumber = activeChannelNumber;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}
