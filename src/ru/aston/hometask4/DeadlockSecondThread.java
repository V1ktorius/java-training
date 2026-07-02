package ru.aston.hometask4;

public class DeadlockSecondThread extends Thread {
    @Override
    public void run() {
        ThreadLocks.lock2.lock();

        try {
            System.out.println(2);
            sleep(ThreadLocks.TIMEOUT);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }

        ThreadLocks.lock1.lock();

        ThreadLocks.lock1.unlock();
        ThreadLocks.lock2.unlock();
    }
}
