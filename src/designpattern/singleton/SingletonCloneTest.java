package designpattern.singleton;

public class SingletonCloneTest {

    public static void main(String[] args) {
        useSingletonToBreakIt();
        useSingletonToTestFix();
    }
    private static void useSingletonToBreakIt(){
        System.out.println("Inside useSingletonToBreakIt method");
        SingletonClone s1 = SingletonClone.getInstance();
        SingletonClone s2 = SingletonClone.getInstance();

        System.out.println("Hashcode of s1: "+s1.hashCode());
        System.out.println("Hashcode of s2: "+s2.hashCode());

        try {
            SingletonClone s3 = (SingletonClone) s2.clone();
            System.out.println("Hashcode of s3: "+s3.hashCode());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void useSingletonToTestFix(){
        System.out.println("Inside useSingletonToTestFix method");
        SingletonCloneFixed s1 = SingletonCloneFixed.getInstance();
        SingletonCloneFixed s2 = SingletonCloneFixed.getInstance();

        System.out.println("Hashcode of s1: "+s1.hashCode());
        System.out.println("Hashcode of s2: "+s2.hashCode());

        try {
            SingletonCloneFixed s3 = (SingletonCloneFixed) s2.clone();
            System.out.println("Hashcode of s3: "+s3.hashCode());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

final class SingletonClone implements Cloneable {

    private static SingletonClone instance = new SingletonClone();
    private SingletonClone(){
        System.out.println("Creating instance...");
    }

    public static SingletonClone getInstance() {
        return instance;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

final class SingletonCloneFixed implements Cloneable {

    private static SingletonCloneFixed instance = new SingletonCloneFixed();
    private SingletonCloneFixed(){
        System.out.println("Creating instance...");
    }

    public static SingletonCloneFixed getInstance() {
        return instance;
    }

    protected Object clone() throws CloneNotSupportedException {
        if (instance != null)
            throw new CloneNotSupportedException("Can't create instance. Please use getInsance() to create it.");
        return super.clone();
    }
}
