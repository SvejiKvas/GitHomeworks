package ru.innopolis.java.attestation.attestation01.repositories;

import ru.innopolis.java.attestation.attestation01.User;

import java.io.IOException;
import java.util.List;

public interface UsersRepository {
    void create (User user) throws IOException;
    User findById(String id);
    List<User> findAll() throws IOException;
    void update(User user) throws IOException;
    void deleteById(String id) throws IOException;
    void deleteAll() throws IOException;

}
