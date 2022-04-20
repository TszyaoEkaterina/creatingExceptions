package ru.netology;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(int id) {
        super(" Product with id " + id + " is already added.");
    }
}
