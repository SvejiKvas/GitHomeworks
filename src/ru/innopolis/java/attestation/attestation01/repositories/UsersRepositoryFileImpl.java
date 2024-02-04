package ru.innopolis.java.attestation.attestation01.repositories;

import ru.innopolis.java.attestation.attestation01.User;
import ru.innopolis.java.attestation.attestation01.customExceptions.PasswordMismatchException;
import ru.innopolis.java.attestation.attestation01.customExceptions.ValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryFileImpl implements UsersRepository{

    private ArrayList<User> users = new ArrayList<>();

    final String INPUT_PATH = "C:\\Users\\Dayal\\Desktop\\GitHomeworks\\src\\ru\\innopolis\\java\\attestation\\attestation01\\textFile\\input.txt";

    public UsersRepositoryFileImpl() {
    }

    @Override
    public void create(User user) {
        update(user);
    }

    @Override
    public User findById(String id) {
        for(User userInArray: users) {
            if (userInArray.getId().equals(id)) {
                return userInArray;
            }
        }
        throw new IllegalArgumentException("Пользователя с там id не существует");
    }

    @Override
    public List<User> findAll() {
        updateFromFile();
        return this.users;
    }

    @Override
    public void update(User user) {
        boolean finded = false;
        for (int i = 0; i < users.size(); i++) {
            if (user.getId().equals(users.get(i).getId())) {
                finded = true;
                users.set(i, user);
                updateToFile();
                break;
            }
        }
        if (!finded) {
            users.add(user);
            updateToFile();
        }
    }

    @Override
    public void deleteById(String id){
        boolean removed = users.removeIf(userInArray -> userInArray.getId().equals(id));
        if (!removed) {
            throw new IllegalArgumentException("Пользователя с там id не существует");
        }
        updateToFile();
    }

    @Override
    public void deleteAll() {
        this.users = new ArrayList<>();
        updateToFile();
    }

    private void updateToFile() {
        try(    FileOutputStream fileOutput = new FileOutputStream(INPUT_PATH);
                OutputStreamWriter streamWriter = new OutputStreamWriter(fileOutput);
                BufferedWriter bufferedWriter = new BufferedWriter(streamWriter)
        ) {
            for (User userInArray: users) {
                bufferedWriter.write(userInArray.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateFromFile() {
        try (   FileInputStream fileInput = new FileInputStream(INPUT_PATH);
                InputStreamReader streamReader = new InputStreamReader(fileInput);
                BufferedReader bufferedReader = new BufferedReader(streamReader)    ) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                User user = new User(line);
                update(user);
            }
        } catch (IOException | PasswordMismatchException | ValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
