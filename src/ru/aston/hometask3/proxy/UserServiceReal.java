package ru.aston.hometask3.proxy;

public class UserServiceReal implements UserService {
    @Override
    public void saveUser(String name) {
        System.out.println("Saving user: " + name);
    }
}
