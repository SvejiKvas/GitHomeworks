package ru.innopolis.java.attestation.attestation01;

import ru.innopolis.java.attestation.attestation01.customExceptions.PasswordMismatchException;
import ru.innopolis.java.attestation.attestation01.customExceptions.ValidationException;
import ru.innopolis.java.attestation.attestation01.repositories.UsersRepositoryFileImpl;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;


public class App {
    public static void main(String[] args) throws IOException, PasswordMismatchException, ValidationException {

        User user1 = new User("g5a8a3cb-4ac9-4b3b-8a65-c424e129b9de|2023-12-25T19:10:11.706|noisemc_121|789mnop|789mnop|Федоров|Степан|Владимирович|24|true");
        User user2 = new User("1||dayal_22|asdf123|asdf123|Дёмин|Даял||22|false"); // конструктор работает без поля даты и отчества


        UsersRepositoryFileImpl repositoryFile = new UsersRepositoryFileImpl();

        List<User> userList = repositoryFile.findAll();

        repositoryFile.create(user1);
        repositoryFile.create(user2);
        repositoryFile.create(user2); // программа не добавляет дублирующиеся значения

        System.out.println("Пользователь с id 1\n" + repositoryFile.findById("1") + "\n");

        user2.setAge(52);
        repositoryFile.update(user2);

        System.out.println("Изменил возраст 22 -> 52 ");
        System.out.println(user2.toString() + "\n");

        repositoryFile.deleteById("1");
        System.out.println("Удалил пользователя по id, теперь список пользователей выглядит так:");
        System.out.println(userList.stream()
                .map(User::toString)
                .collect(Collectors.joining("\n")));
    }
}
