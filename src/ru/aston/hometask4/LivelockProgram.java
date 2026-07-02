package ru.aston.hometask4;

public class LivelockProgram {
    public static void main(String[] args) {
        new LivelockFirstThread().start();
        new LivelockSecondThread().start();
    }
}
