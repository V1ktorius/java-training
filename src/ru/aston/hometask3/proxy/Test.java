package ru.aston.hometask3.proxy;

public class Test {
    public static void main(String[] args) {
        UserService service = new UserServiceProxy(new UserServiceReal());
        service.saveUser("Viktor");
    }
}
