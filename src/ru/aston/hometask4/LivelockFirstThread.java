package ru.aston.hometask4;

import java.util.concurrent.TimeUnit;

public class LivelockFirstThread extends Thread {
    @Override
    public void run() {
        while(true) {
            try {
                ThreadLocks.lock1.tryLock(ThreadLocks.TIMEOUT, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(1);

            try {
                sleep(ThreadLocks.TIMEOUT);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (!ThreadLocks.lock2.tryLock()) {
                ThreadLocks.lock1.unlock();
                continue;
            }

            break;
        }
        ThreadLocks.lock2.unlock();
        ThreadLocks.lock1.unlock();
    }
}
