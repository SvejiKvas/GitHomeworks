package ru.innopolis.java.homework09.code;

public class CasualRace extends Race {

    static {
        System.out.println("Обычная гонка");
    }

    public CasualRace() {
        this.route = "unnamed";
        this.participants = new Car[] {};
    }
    public CasualRace (int length, String route, int prizePool, Car[] participants) {
        super(length, route, prizePool, participants);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
