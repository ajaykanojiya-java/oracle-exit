package stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AdvancedStreamApiPractice {

    public static void main(String[] args) {
        FindEmployeesWithDuplicateNames();
        System.out.println("--------------------------------");
        findTopKFrequentElementsInAlist();
        System.out.println("--------------------------------");
        findCommonElementsInTwoLists();
        System.out.println("--------------------------------");
        checkIfTwoStringsAreAnagrams();
        System.out.println("--------------------------------");
        findMajorityElement();
        System.out.println("--------------------------------");
        findTheFirstRepeatedCharacterInAString();
        System.out.println("--------------------------------");
        findTheLongestWordInASentence();
        System.out.println("--------------------------------");
        findAllNumbersThatAppearExactlyTwice();
        System.out.println("--------------------------------");
        findTheKthLargestElement();
        System.out.println("--------------------------------");
        findDuplicateCharactersInAString();
    }

    public static void FindEmployeesWithDuplicateNames(){
        List<String> names = Arrays.asList("Ajay", "Vijay", "Sanjay", "Ajay", "Deepak", "Sanjay");

        List<String> duplicates = names.stream().collect(
                        Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet().stream()
                        .filter(e->e.getValue()>1)
                        .map(Map.Entry::getKey)
                        .toList();
        System.out.println(duplicates);
        //Output: [Ajay, Sanjay]
    }

    public static void findTopKFrequentElementsInAlist(){
        List<Integer> nums = Arrays.asList(1,1,1,2,2,3,3,3,3,4,5);
        int k = 2;

        List<Integer> list = nums.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer,Long>comparingByValue().reversed())
                .limit(k)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(list);
        //output: [3, 2]
    }

    public static void findCommonElementsInTwoLists(){
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8);

        List<Integer> commons = list1.stream().filter(list2::contains)
                .toList();

        System.out.println(commons);
        //Output: [4, 5]
    }

    public static void checkIfTwoStringsAreAnagrams(){
        String s1 = "listen", s2 = "silent";

        boolean isAnagrams = s1.chars().sorted().boxed().collect(Collectors.toList())
                .equals(s2.chars().sorted().boxed().collect(Collectors.toList()));

        System.out.println("Is Anagram: "+isAnagrams);
        //Output: true
    }

    //Find majority element (> n/2 times)
    //the element which presence greater than half the size of array
    //2 present 4 times and array half size is 7/2 = 3
    public static void findMajorityElement(){
        List<Integer> nums = Arrays.asList(2,2,1,1,1,2,2);

        Optional<Integer> optional = nums.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(e->e.getValue()>nums.size()/2)
                .map(Map.Entry::getKey)
                .findFirst();
        optional.ifPresentOrElse(System.out::println,()->System.out.println("No majority element found"));
        //output: 2
    }

    public static void findTheFirstRepeatedCharacterInAString(){
        String str = "programming";

        Character character = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .filter(e->e.getValue()>1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);

        System.out.println(character);
        //Output: r;
    }

    public static void findTheLongestWordInASentence(){
        String sentence = "Java Stream API makes coding concise and powerful";

        String longestWord = Arrays.stream(sentence.split("\\s"))
                .max(Comparator.comparingInt(String::length))
                        .orElse("");

        System.out.println(longestWord);
        //output: powerful
    }

    public static void findAllNumbersThatAppearExactlyTwice(){
        List<Integer> nums = Arrays.asList(4, 5, 6, 5, 6, 7, 8, 8);

        List<Integer> twiceNumberList = nums.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(e->e.getValue()==2)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println(twiceNumberList);
        //output: [5, 6, 8]
    }

    public static void findTheKthLargestElement(){
        List<Integer> nums = Arrays.asList(3, 2, 1, 5, 6, 4);
        int k = 2;

        Integer element = nums.stream().sorted(Comparator.reverseOrder())
                .skip(k-1)
                .findFirst().orElse(-1);

        System.out.println(element);
        //Output: 5
    }

    public static void findDuplicateCharactersInAString(){
        String str = "banana";

        Set<Character> duplicates = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        System.out.println(duplicates);
        //Output: [a, n]
    }
}
