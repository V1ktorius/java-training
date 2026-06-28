package ru.aston.hometask3.proxy;

public class UserServiceProxy implements UserService {
    private final UserService target;
    UserServiceProxy(UserService target) {
        this.target = target;
    }
    @Override
    public void saveUser(String name) {
        System.out.println("Before save...");
        target.saveUser(name);
        System.out.println("After save...");
    }
}
