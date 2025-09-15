package designpattern.singleton;

import java.io.*;

public class SingletonSerializationTest {

    public static void main(String[] args) {
        useSingletonSerializationToBreak();
        useSingletonSerializationToFix();
    }

    private static void useSingletonSerializationToBreak(){
        SingletonSerialization s1 = SingletonSerialization.getInstance();
        SingletonSerialization s2 = SingletonSerialization.getInstance();
        System.out.println("Hashcode of Object s1: " +s1.hashCode());
        System.out.println("Hashcode of Object s2: " +s2.hashCode());

        ObjectOutputStream oos = null;
        SingletonSerialization s3 = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("s2.ser"));
            oos.writeObject(s2);
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("s2.ser"));
            s3= (SingletonSerialization)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hashcode of Object s3: " +s3.hashCode());
    }

    private static void useSingletonSerializationToFix(){
        SingletonSerializationFixed s1 = SingletonSerializationFixed.getInstance();
        SingletonSerializationFixed s2 = SingletonSerializationFixed.getInstance();
        System.out.println("Hashcode of Object s1: " +s1.hashCode());
        System.out.println("Hashcode of Object s2: " +s2.hashCode());

        ObjectOutputStream oos = null;
        SingletonSerializationFixed s3 = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("s2.ser"));
            oos.writeObject(s2);
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("s2.ser"));
            s3= (SingletonSerializationFixed)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hashcode of Object s3: " +s3.hashCode());
    }
}

final class SingletonSerialization implements Serializable {

    public static SingletonSerialization instance= new SingletonSerialization();

    private SingletonSerialization() {
        System.out.println("creating instance.....");
    }

    public static SingletonSerialization getInstance() {
        return instance;
    }
}

final class SingletonSerializationFixed implements Serializable {

    public static SingletonSerializationFixed instance= new SingletonSerializationFixed();

    private SingletonSerializationFixed() {
        System.out.println("creating instance.....");
    }

    public static SingletonSerializationFixed getInstance() {
        return instance;
    }

    private Object readResolve(){
        System.out.println("Applying readResolve()......");
        return instance;
    }

}
