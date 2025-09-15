import java.util.*;

/*Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

        Example 1:
        Input: nums = [2,2,3,2]
        Output: 3

        Example 2:
        Input: nums = [0,1,0,1,0,1,99]
        Output: 99

        Example 3:
        Input: nums = [7, 11, 33, 41, 41, 33, 6, 11, 7, 7, 11, 33, 41]
        Output: 6*/
public class LearningmateQuestion {

    public static void main(String[] args) {
        int [] num = new int [] {2,2,3,2};
        Map<Integer,Integer> map  = new HashMap<>();

        for(int i=0; i<num.length;i++){
            if(!map.containsKey(num[i])){
                map.put(num[i],1);
            }else {
                map.put(num[i],map.get(num[i])+1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry<Integer,Integer> entry = itr.next();
            if(entry.getValue() == 1){
                System.out.println("Unique element :"+entry.getKey());
                break;
            }
        }

        //Optional element = map.entrySet().stream().filter((k)->k.getValue()==1).findFirst();

    }

}
