package ru.aston.hometask4;

import java.util.concurrent.TimeUnit;

public class LivelockSecondThread extends Thread {
    @Override
    public void run() {
        while(true) {
            try {
                ThreadLocks.lock2.tryLock(ThreadLocks.TIMEOUT, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(2);

            try {
                sleep(ThreadLocks.TIMEOUT);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (!ThreadLocks.lock1.tryLock()) {
                ThreadLocks.lock2.unlock();
                continue;
            }

            break;
        }
        ThreadLocks.lock1.unlock();
        ThreadLocks.lock2.unlock();
    }
}
