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

        //traditional way
        List<Integer> evens = new ArrayList<>();
        for (Integer n : numbers) {
            if (n % 2 == 0) {
                evens.add(n);
            }
        }
        evens.stream().forEach(System.out::println);

        //using stream
        List<Integer> result = numbers.stream().filter(n->n%2==0).collect(Collectors.toList());
        result.stream().forEach(System.out::println);

    }

    public static void convertToUpperCase(){
        List<String> names = Arrays.asList("john", "doe", "alice");

        //traditional way
        List<String> upper = new ArrayList<>();
        for (String name : names) {
            upper.add(name.toUpperCase());
        }
        System.out.println(upper);

        //using stream api
        names.stream().map(s->s.toUpperCase()).forEach(System.out::println);
    }

    public static void findFirstElementGreaterThan10(){
        List<Integer> nums = Arrays.asList(5, 9, 1, 3, 5);

        //traditional way
        Integer result = null;
        for (Integer n : nums) {
            if (n > 10) {
                result = n;
                break;
            }
        }
        System.out.println(result);

        //using stream api
        Optional<Integer> optional = nums.stream().filter(n->n>10).findFirst();
        optional.ifPresent(System.out::println);
        optional.ifPresentOrElse(System.out::println,()->System.out.println("No value are greater than 10"));
    }

    public static void sortByLengthOfString(){
        List<String> list = Arrays.asList("banana", "apple", "kiwi");

        //traditional way
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        System.out.println(list);

        //using stream api
        list.stream().sorted(Comparator.comparingInt(s->s.length())).forEach(System.out::println);

        //natural ordering
        list.stream().sorted().forEach(System.out::println);
    }

    public static void countWordStartingWitha(){
        List<String> words = Arrays.asList("apple", "banana", "apricot", "grape");

        //traditional way
        int count = 0;
        for (String word : words) {
            if (word.startsWith("a")) {
                count++;
            }
        }
        System.out.println(count);
        //using stream api
        System.out.println("words starting with 'a' "+words.stream().filter(s->s.startsWith("a")).count());
    }

    public static void groupByStringLength(){
        List<String> items = Arrays.asList("a", "bb", "ccc", "dd", "eee");

        //traditional way
        Map<Integer, List<String>> grouped = new HashMap<>();
        for (String item : items) {
            int len = item.length();
            if (!grouped.containsKey(len)) {
                grouped.put(len, new ArrayList<>());
            }
            grouped.get(len).add(item);
        }
        System.out.println(grouped);

        //using stream api
        Map<Integer, List<String>> grouped1 = items.stream().collect(Collectors.groupingBy(s->s.length()));
        System.out.println(grouped1);
    }

    public static void joinStringWithComma(){
        List<String> list = Arrays.asList("apple", "banana", "cherry");

        //traditional way
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb.toString());

        //using stream api
        String result = list.stream().collect(Collectors.joining(", "));
        System.out.println("Result: "+result);
    }

    public static void findMaxElement(){
        List<Integer> nums = Arrays.asList(5, 9, 15, 3, 15);

        //traditional way
        int max = Integer.MIN_VALUE;
        for (Integer n : nums) {
            if (n > max) {
                max = n;
            }
        }
        System.out.println(max);

        //using stream api
        OptionalInt optional = nums.stream().mapToInt(n->n).max();
        optional.ifPresentOrElse(System.out::println,()-> System.out.println("No Max value present"));
    }

    public static void flatMapForNestedList(){
        List<List<String>> list = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d"),
                Arrays.asList("e", "f")
        );

        //traditional way
        List<String> flat = new ArrayList<>();
        for (List<String> sublist : list) {
            for (String s : sublist) {
                flat.add(s);
            }
        }
        System.out.println(flat);

        //using stream api
        List<String> flat1 =list.stream().flatMap(s->s.stream()).collect(Collectors.toList());
        System.out.println("Flatting map: "+flat1);

    }
}
