package stream;

import java.util.*;
import java.util.stream.Collectors;

public class Java8Practice {


    public static void main(String[] args) {
        FilterEvenNumber();
        System.out.println("-------------------------");
        convertToUpperCase();
        System.out.println("-------------------------");
        findFirstElementGreaterThan10();
        System.out.println("-------------------------");
        sortByLengthOfString();
        System.out.println("-------------------------");
        countWordStartingWitha();
        System.out.println("-------------------------");
        groupByStringLength();
        System.out.println("-------------------------");
        joinStringWithComma();
        System.out.println("-------------------------");
        findMaxElement();
        System.out.println("-------------------------");
        flatMapForNestedList();
        System.out.println("-------------------------");
    }

    private static void FilterEvenNumber() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> result = numbers.stream().filter(n->n%2==0).collect(Collectors.toList());
        List<Integer> evens = new ArrayList<>();
        for (Integer n : numbers) {
            if (n % 2 == 0) {
                evens.add(n);
            }
        }
        result.stream().forEach(System.out::println);
        evens.stream().forEach(System.out::println);
    }

    public static void convertToUpperCase(){
        List<String> names = Arrays.asList("john", "doe", "alice");
        List<String> upper = new ArrayList<>();
        for (String name : names) {
            upper.add(name.toUpperCase());
        }
        System.out.println(upper);
        names.stream().map(s->s.toUpperCase()).forEach(System.out::println);
    }

    public static void findFirstElementGreaterThan10(){
        List<Integer> nums = Arrays.asList(5, 9, 1, 3, 5);
        Integer result = null;
        for (Integer n : nums) {
            if (n > 10) {
                result = n;
                break;
            }
        }
        System.out.println(result);
        Optional<Integer> optional = nums.stream().filter(n->n>10).findFirst();
        optional.ifPresent(System.out::println);
        optional.ifPresentOrElse(System.out::println,()->System.out.println("No value are greater than 10"));
    }

    public static void sortByLengthOfString(){
        List<String> list = Arrays.asList("banana", "apple", "kiwi");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        System.out.println(list);

        list.stream().sorted(Comparator.comparingInt(s->s.length())).forEach(System.out::println);
        //natural ordering
        list.stream().sorted().forEach(System.out::println);
    }

    public static void countWordStartingWitha(){
        List<String> words = Arrays.asList("apple", "banana", "apricot", "grape");
        int count = 0;
        for (String word : words) {
            if (word.startsWith("a")) {
                count++;
            }
        }
        System.out.println(count);
        System.out.println("words starting with 'a' "+words.stream().filter(s->s.startsWith("a")).count());
    }

    public static void groupByStringLength(){
        List<String> items = Arrays.asList("a", "bb", "ccc", "dd", "eee");
        Map<Integer, List<String>> grouped = new HashMap<>();
        for (String item : items) {
            int len = item.length();
            if (!grouped.containsKey(len)) {
                grouped.put(len, new ArrayList<>());
            }
            grouped.get(len).add(item);
        }
        System.out.println(grouped);

        Map<Integer, List<String>> grouped1 = items.stream().collect(Collectors.groupingBy(s->s.length()));
        System.out.println(grouped1);
    }

    public static void joinStringWithComma(){
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb.toString());
        String result = list.stream().collect(Collectors.joining(", "));
        System.out.println("Result: "+result);
    }

    public static void findMaxElement(){
        List<Integer> nums = Arrays.asList(5, 9, 15, 3, 15);
        int max = Integer.MIN_VALUE;
        for (Integer n : nums) {
            if (n > max) {
                max = n;
            }
        }
        System.out.println(max);
        OptionalInt optional = nums.stream().mapToInt(n->n).max();
        optional.ifPresentOrElse(System.out::println,()-> System.out.println("No Max value present"));
    }

    public static void flatMapForNestedList(){
        List<List<String>> list = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d"),
                Arrays.asList("e", "f")
        );
        List<String> flat = new ArrayList<>();
        for (List<String> sublist : list) {
            for (String s : sublist) {
                flat.add(s);
            }
        }
        System.out.println(flat);

        List<String> flat1 =list.stream().flatMap(s->s.stream()).collect(Collectors.toList());
        System.out.println("Flatting map: "+flat1);

    }
}
