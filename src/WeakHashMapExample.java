import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapExample {



    public static void main(String[] args) {
        weakHashMapImpl();
        hashMapImpl();
    }

    public static void weakHashMapImpl(){
        Map<Image,String> cache = new WeakHashMap<>();

        Image image1 = new Image("Image1");
        Image image2 = new Image("Image2");

        cache.put(image1,"Logo Image");
        cache.put(image2,"Banner Image");

        System.out.println("Cache before GC "+cache);

        image1 = null; //removing reference
        System.gc(); //calling garbage collector to collect weak references in memory
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //we didn't remove image1 object key from map but as it is a WeakHashMap therefore
        //removing reference from map resulting removing the object as well.
        System.out.println("Cache after GC "+cache);
    }

    public static void hashMapImpl(){
        Map<Image,String> hashMap = new HashMap<>();

        Image image1 = new Image("Image1");
        Image image2 = new Image("Image2");

        hashMap.put(image1,"Logo Image");
        hashMap.put(image2,"Banner Image");

        System.out.println("hash map before GC "+hashMap);

        image1 = null; //removing reference
        System.gc(); //calling garbage collector to collect weak references in memory
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //we didn't remove image1 object key from map but as it is a HashMap therefore
        //removing reference from map will not remove key and value from map.

        System.out.println("hash map after GC "+hashMap);
    }
}

class Image{
    private String name;

    Image(String name) {
        this.name = name;
    }

    public String toString() {
        return "Image: " + name;
    }
}
