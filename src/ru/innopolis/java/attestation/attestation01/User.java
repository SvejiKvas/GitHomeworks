package ru.innopolis.java.attestation.attestation01;

import ru.innopolis.java.attestation.attestation01.customExceptions.PasswordMismatchException;
import ru.innopolis.java.attestation.attestation01.customExceptions.ValidationException;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class User {
    private String id;
    private LocalDateTime date;
    private String login;
    private String password;
    private String confirmPassword;
    private String surname;
    private String name;
    private String middleName;
    private int age;
    private boolean isWorker;
    public User (String data) throws PasswordMismatchException, ValidationException {
        String[] dataMas = data.split("\\|");

        boolean isInteger;
        try {
            int num = Integer.parseInt(dataMas[8]);
            isInteger = true;
        } catch (NumberFormatException e) {
            isInteger = false;
        }

        boolean isDigit; // проверка на то, что переменная является числом (для логина)
        try {
            int number = Integer.parseInt(dataMas[1]);
            isDigit = true;
        } catch (NumberFormatException e) {
            isDigit = false;
        }

        if (!dataMas[0].matches("[a-zA-Z0-9-]+")) {
            throw new ValidationException("Неправильные символы в ID");
        }

        LocalDateTime dateTime;
        try{
            dateTime = LocalDateTime.parse(dataMas[1]);
        }
        catch (DateTimeParseException e ) {
            dateTime = LocalDateTime.now();
        }

        if (!dataMas[2].matches("[a-zA-Z0-9_-]+") || !(dataMas[2].length() < 20) || isDigit || dataMas[2].isBlank()) {
            throw new ValidationException("Неправильные символы в login");
        }
        if (!dataMas[3].matches("[a-zA-Z0-9_]+") || !(dataMas[3].length() < 20) || dataMas[3].matches("\\p{L}+\\b") || dataMas[3].isBlank()) {
            throw new ValidationException("Неправильные символы в password");
        }
        if (!dataMas[3].equals(dataMas[4])) {
            throw new PasswordMismatchException("Пароли не совпадают");
        }
        if (!dataMas[5].matches("\\p{L}+\\b") || dataMas[5].isBlank()) {
            throw new ValidationException("Surname должна состоять только из букв");
        }
        if (!dataMas[6].matches("\\p{L}+\\b") || dataMas[6].isBlank()) {
            throw new ValidationException("Name должна состоять только из букв");
        }
        if (!dataMas[7].matches("\\p{L}+\\b") && !dataMas[7].isBlank()) {
            throw new ValidationException("Middle name должна состоять только из букв");
        }
        if (!isInteger) {
            throw new ValidationException("Age должен состоять из целых чисел");
        }
        if (!dataMas[9].equals("true") && !dataMas[9].equals("false")) {
            throw new ValidationException("В переменную isWorker должны передаваться только параметры true или false");
        }

        this.id = dataMas[0];
        this.date = dateTime;
        this.login = dataMas[2];
        this.password = dataMas[3];
        this.confirmPassword = dataMas[4];
        this.surname = dataMas[5];
        this.name = dataMas[6];

        if (dataMas[7].isBlank()) {
            this.middleName = "";
        } else {
            this.middleName = dataMas[7];
        }

        if (dataMas[8].isBlank()) {
            this.age = 0;
        } else {
            this.age = Integer.parseInt(dataMas[8]);
        }

        this.isWorker = dataMas[9].equals("true");
    }

    @Override
    public String toString() {
        return String.format("%s|%s|%s|%s|%s|%s|%s|%s|%d|%b",
                this.id, this.date, this.login, this.password, this.confirmPassword,
                this.surname, this.name, this.middleName, this.age, this.isWorker);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isWorker() {
        return isWorker;
    }

    public void setWorker(boolean worker) {
        isWorker = worker;
    }
}
