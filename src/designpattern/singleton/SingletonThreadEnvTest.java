package designpattern.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonThreadEnvTest {
    public static void main(String[] args) {
        //testSingletonMultiThreadEnv();
        testSingletonMultiThreadEnvFixed();
    }

    private static void testSingletonMultiThreadEnv(){
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(()->SingletonMultiThreadEnv.useSingleton());
        executor.submit(()->SingletonMultiThreadEnv.useSingleton());
        executor.shutdown();
    }

    private static void testSingletonMultiThreadEnvFixed(){
        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.submit(()->SingletonMultiThreadEnvFixed.useSingleton());
        executor.submit(()->SingletonMultiThreadEnvFixed.useSingleton());
        executor.submit(()->SingletonMultiThreadEnvFixed.useSingleton());
        executor.submit(()->SingletonMultiThreadEnvFixed.useSingleton());

        executor.shutdown();
    }
}

final class SingletonMultiThreadEnv {

    public static SingletonMultiThreadEnv instance;

    private SingletonMultiThreadEnv() {
        System.out.println("creating instance.....");
    }

    public static SingletonMultiThreadEnv getInstance() {
        if(instance == null)
            instance = new SingletonMultiThreadEnv();
        return instance;
    }

    static void useSingleton(){
        SingletonMultiThreadEnv singleton = SingletonMultiThreadEnv.getInstance();
        System.out.println("Hashcode of Singleton Object: "+singleton.hashCode());
    }
}


final class SingletonMultiThreadEnvFixed {

    public static SingletonMultiThreadEnvFixed instance;

    private SingletonMultiThreadEnvFixed() {
        System.out.println("creating instance.....");
    }

    public static SingletonMultiThreadEnvFixed getInstance() {
        if(instance == null) {
            System.out.println("Thread is waiting: "+Thread.currentThread().getName());
            synchronized (SingletonMultiThreadEnvFixed.class) {
                if (instance == null)
                    instance = new SingletonMultiThreadEnvFixed();
            }
        }
        return instance;
    }

    static void useSingleton(){
        SingletonMultiThreadEnvFixed singleton = SingletonMultiThreadEnvFixed.getInstance();
        System.out.println("Hashcode of Singleton Object: "+singleton.hashCode());
    }
}
