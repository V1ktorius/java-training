package ru.aston.hometask4;

public class DeadlockFirstThread extends Thread {

    @Override
    public void run() {
        ThreadLocks.lock1.lock();

        try {
            System.out.println(1);
            sleep(ThreadLocks.TIMEOUT);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }

        ThreadLocks.lock2.lock();

        ThreadLocks.lock2.unlock();
        ThreadLocks.lock1.unlock();
    }
}
