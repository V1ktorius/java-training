package ru.aston.hometask4;

public class DeadlockProgram {
    public static void main(String[] args) {
        new DeadlockFirstThread().start();
        new DeadlockSecondThread().start();
    }
}
