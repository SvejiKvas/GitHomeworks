package ru.innopolis.java.homework09.code;
public class App {
    public static void main(String[] args) {
        Car[] cars = new Car[] {new Car(), new Car(), new Car()};

        Car tayota = new Car("tayota", "carolla", 2000, 200, 12, 32, 4);
        Car tayota1 = new Car("tayota", "carolla", 2000, 200, 12, 32, 4);
        System.out.println(tayota.toString());
        PerformanceCar BMW = new PerformanceCar();
        System.out.println(BMW.toString());
        ShowCar mersedes = new ShowCar();
        System.out.println(mersedes.toString());

        System.out.println(tayota.equals(tayota1));

        Race race = new Race(30, "malmo", 12000, cars);
        Race race1 = new Race(30, "malmo", 12000, cars);

        CasualRace casualRace = new CasualRace(30, "malmo", 12000, cars);
        DragRace dragRace = new DragRace();
        DriftRace driftRace = new DriftRace();

        System.out.println(race.equals(race1));

        Garage garage = new Garage();

        garage.addCar(tayota);
        garage.addCar(mersedes);
        garage.addCar(BMW);

        garage.showParkedCars();

        garage.upgradeCar(tayota);

        System.out.println(driftRace.toString());
    }
}