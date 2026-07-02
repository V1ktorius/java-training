package ru.aston.hometask4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLocks {
    public static final int TIMEOUT = 1000;

    public static Lock lock1 = new ReentrantLock(true);
    public static Lock lock2 = new ReentrantLock(true);
}
