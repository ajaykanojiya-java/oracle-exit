package designpattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonTest {

    public static void main(String[] args) {
        useSingleton();
        breakSingleton();
        breakSingletonFixed();

    }

    private static void useSingleton(){
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println("Hashcode of s1: "+s1.hashCode());
        System.out.println("Hashcode of s2: "+s2.hashCode());
    }

    private static void breakSingleton(){
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println("Hashcode of s1: "+s1.hashCode());
        System.out.println("Hashcode of s2: "+s2.hashCode());

        try {
            Class clazz = Class.forName("designpattern.singleton.Singleton");
            Constructor<Singleton> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            Singleton s3 = constructor.newInstance();
            System.out.println("Hashcode of s3: "+s3.hashCode());
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static void breakSingletonFixed(){
        SingletonFixed s1 = SingletonFixed.getInstance();
        SingletonFixed s2 = SingletonFixed.getInstance();

        System.out.println("Hashcode of s1: "+s1.hashCode());
        System.out.println("Hashcode of s2: "+s2.hashCode());

        try {
            Class clazz = Class.forName("designpattern.singleton.SingletonFixed");
            Constructor<SingletonFixed> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            SingletonFixed s3 = constructor.newInstance();
            System.out.println("Hashcode of s3: "+s3.hashCode());
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}

final class Singleton {

    private static Singleton instance = new Singleton();
    private Singleton(){
        System.out.println("Creating instance...");
    }

    public static Singleton getInstance() {
        return instance;
    }
}

final class SingletonFixed {

    private static SingletonFixed instance = new SingletonFixed();
    private SingletonFixed(){
        if (instance != null)
            throw new RuntimeException("Cannot create another instance");
    }

    public static SingletonFixed getInstance() {
        return instance;
    }
}
