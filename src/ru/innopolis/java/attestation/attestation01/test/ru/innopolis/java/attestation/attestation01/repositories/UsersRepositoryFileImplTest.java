package ru.innopolis.java.attestation.attestation01.repositories;

import org.junit.jupiter.api.*;

import ru.innopolis.java.attestation.attestation01.User;
import ru.innopolis.java.attestation.attestation01.customExceptions.PasswordMismatchException;
import ru.innopolis.java.attestation.attestation01.customExceptions.ValidationException;

import java.util.ArrayList;

class UsersRepositoryFileImplTest {


    UsersRepositoryFileImpl repositoryFile;

    @BeforeEach
    void setupEach() {
        repositoryFile = new UsersRepositoryFileImpl();
    }

    @AfterEach
    void cleanUpEach() {
        repositoryFile.deleteAll();
    }

    @Test
    @DisplayName("Создание пользователя с корректными данными")
    public void testCreateUserWithValidData() throws PasswordMismatchException, ValidationException {
        User user = new User("g5a8a3cb-4ac9-4b3b-8a65-c424e129b9de|2023-12-25T19:10:11.706|noisemc_121|789mnop|789mnop|Федоров|Степан|Владимирович|24|true");
        ArrayList<User> users = repositoryFile.getUsers();
        Assertions.assertDoesNotThrow(() -> repositoryFile.create(user));
        Assertions.assertEquals(users.get(users.size() - 1).toString(), user.toString());
    }

    @Test
    @DisplayName("Создание пользователя с некорректными данными")
    public void testCreateUserWithInvalidData() throws PasswordMismatchException, ValidationException {
        Assertions.assertThrows(ValidationException.class, () -> {
            User user = new User("&&&|2023-12-25T19:10:11.706|noisemc_121|789mnop|789mnop|Федоров|Степан|Владимирович|24|true");
            repositoryFile.create(user);
        });
        ArrayList<User> users = repositoryFile.getUsers();
        Assertions.assertEquals(users.size(), 0);
    }

    @Test
    @DisplayName("Удаление пользователя по корректному id")
    void deleteByIdWithValidData() throws PasswordMismatchException, ValidationException {
        User user = new User("g5a8a3cb-4ac9-4b3b-8a65-c424e129b9de|2023-12-25T19:10:11.706|noisemc_121|789mnop|789mnop|Федоров|Степан|Владимирович|24|true");
        repositoryFile.create(user);
        Assertions.assertDoesNotThrow(() -> repositoryFile.deleteById("g5a8a3cb-4ac9-4b3b-8a65-c424e129b9de"));
        ArrayList<User> users = repositoryFile.getUsers();
        Assertions.assertEquals(users.size(), 0);
    }

    @Test
    @DisplayName("Удаление пользователя по корректному id")
    void deleteByIdWithInvalidData() throws PasswordMismatchException, ValidationException {
        User user = new User("g5a8a3cb-4ac9-4b3b-8a65-c424e129b9de|2023-12-25T19:10:11.706|noisemc_121|789mnop|789mnop|Федоров|Степан|Владимирович|24|true");
        repositoryFile.create(user);
        Assertions.assertThrows(IllegalArgumentException.class, () -> repositoryFile.deleteById("11"));
        ArrayList<User> users = repositoryFile.getUsers();
        Assertions.assertEquals(users.size(), 1);
    }
}