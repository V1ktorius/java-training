package ru.aston.hometask3.chainOfResponsibility;

public abstract class Validator {
    private Validator next;

    public Validator setNext(Validator next) {
        this.next = next;
        return next;
    }

    public void validate(Order order) {
        check(order);
        if (next != null) {
            next.validate(order);
        }
    }

    protected abstract void check(Order order);
}