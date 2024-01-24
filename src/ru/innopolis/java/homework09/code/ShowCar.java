package ru.innopolis.java.homework09.code;

public class ShowCar extends Car{

    static {
        System.out.println("Looking cool there, bro");
    }

    private int stars;
    public ShowCar () {}
    public ShowCar (
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
                suspension,
                durability
        );
        stars = 0;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString () {
        return super.toString() + String.format("Stars: %s%n", stars);
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

        return stars == ((ShowCar) obj).stars;
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = result * 17 + super.hashCode();
        result = result * 17 + stars;
        return result;
    }
}
