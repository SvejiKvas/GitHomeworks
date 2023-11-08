package main.java.thirdHomework;

public class App {
    public static void main(String[] args) {
        TV oled = new TV("Samsung", 51, 144, true);
        TV lg = new TV("LG", 32);

        System.out.println(oled.toString());
        System.out.println(lg.toString());
    }
}
