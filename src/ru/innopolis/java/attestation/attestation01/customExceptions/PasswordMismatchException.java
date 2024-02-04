package ru.innopolis.java.attestation.attestation01.customExceptions;

public class PasswordMismatchException extends Exception{
    public PasswordMismatchException (String message) {
        super(message);
    }
}
