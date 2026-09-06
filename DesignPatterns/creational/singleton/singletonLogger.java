package DesignPatterns.creational.singleton;

public class SingletonLogger {
    private static volatile SingletonLogger instance;

    private SingletonLogger() { } // private constructor to prevent instantiation

    public static SingletonLogger getInstance() {
        if (instance == null) {
            synchronized (SingletonLogger.class) {
                if (instance == null) {
                    instance = new SingletonLogger();
                }
            }
        }

        return instance;
    }

    public void log(String message) {
        System.out.println(message);
    }
}

// using synchronized - 
// - each thread has to wait for the lock to be released before it can enter the synchronized method even if the instance is already created. This can lead to performance issues in a multi-threaded environment.

// using double-checked locking -
// - reduces the overhead of acquiring a lock by first checking if the instance is already created before
