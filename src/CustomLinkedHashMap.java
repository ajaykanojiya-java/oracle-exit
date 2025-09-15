import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomLinkedHashMap {
    Map<Integer,String> map;
    List<Integer> list;

    public CustomLinkedHashMap(){
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public void put(Integer key, String value){
        if(!map.containsKey(key))
            list.add(key);
        map.put(key,value);
    }

    public String get(Integer key){
        return map.get(key);
    }

    public void display(){
        for(Integer key : list){
            System.out.println("Output: "+map.get(key));
        }
    }

    public static void main(String[] args) {
        CustomLinkedHashMap customLinkedHashMap = new CustomLinkedHashMap();
        customLinkedHashMap.put(1,"one");
        customLinkedHashMap.put(2,"two");
        customLinkedHashMap.put(3,"three");
        customLinkedHashMap.put(4,"four");
        customLinkedHashMap.put(5,"five");

        System.out.println("Get element 2: "+customLinkedHashMap.get(2));
        customLinkedHashMap.display();
    }
}

