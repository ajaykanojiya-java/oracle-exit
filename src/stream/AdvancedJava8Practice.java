package stream;

import org.w3c.dom.ls.LSOutput;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



public class AdvancedJava8Practice {

    public static void main(String[] args) {

        List<Employee> employeeList = Arrays.asList(
          new Employee("A1","D1", 25000),
                new Employee("A1","D1", 25000),
                new Employee("A2","D2", 35000),
                new Employee("A3","D3", 15000),
                new Employee("A4","D1", 25300),
                new Employee("A5","D2", 5000)
        );
        findTop3HighestPaidEmployees(employeeList);
        groupEmployeesByDepartmentAndFindAverageSalary(employeeList);
        partitionNumbersIntoPrimeAndNonPrime();
        findMostFrequentWord();
        findSecondHighestNumber();
        customCollector();
        findLongestPalindromeWord();
        flattenJSONLikeStructure();
        SumTransactionAmountsByStock();
        findKthSmallestElement();


    }

    public static void findTop3HighestPaidEmployees(List<Employee> employeeList){
        List<Employee> result = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .collect(Collectors.toList());
        result.stream().forEach(System.out::println);
    }

    public static void groupEmployeesByDepartmentAndFindAverageSalary(List<Employee> employeeList){
        Map<String, Double> result = employeeList.stream()
                .collect(Collectors
                        .groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(result);
    }

    public static void partitionNumbersIntoPrimeAndNonPrime(){
        List<Integer> numbers = IntStream.rangeClosed(2, 50).boxed().toList();
        Map<Boolean,List<Integer>> map = numbers.stream().collect(Collectors.partitioningBy(AdvancedJava8Practice::isPrime));
        List<Integer> primeNumbers = map.get(true);
        List<Integer> nonPrime = map.get(false);
        System.out.println("Prime: "+primeNumbers);
        System.out.println("Non Prime: "+nonPrime);

    }
    private static boolean isPrime(int number){
        return IntStream.rangeClosed(2,(int)Math.sqrt(number)).allMatch(n->number%n!=0);
    }

    private static void findMostFrequentWord(){
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String,Long> frequencyMap = words.stream().collect(Collectors.groupingBy(word->word,Collectors.counting()));
         Optional<Map.Entry<String, Long>> optional = frequencyMap.entrySet().stream().max(Comparator.comparing(key->key.getValue()));
         optional.ifPresent(entry -> {
             System.out.println(entry.getKey()+" "+entry.getValue());
         });
    }


    private static void findSecondHighestNumber(){
        List<Integer> list = Arrays.asList(5,6,7,4,3,5,6,8,6,4,3,32,2,2,3,34,5,56,7,7,8,8,6,54,4,433,3);
        Optional<Integer> secondHighest = list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        secondHighest.ifPresent(System.out::println);
    }

    //Create a collector that joins strings in uppercase but separates them with " | " instead of ", ".
    private static void customCollector(){
        List<String> words = Arrays.asList("apple", "banana", "kiwi", "orange", "mango", "guava");
        String result = words.stream().map(s->s.toUpperCase()).collect(Collectors.joining(" | "));
        System.out.println("Joined Strings: "+result);
    }

    private static void findLongestPalindromeWord(){
        List<String> words = Arrays.asList("madam", "apple", "racecar", "banana", "level", "hello");
        Optional<String> longestPalidnrom = words.stream()
                .filter(s->AdvancedJava8Practice.findPalindrom(s))
                .sorted(Comparator.comparing(String::length).reversed())
                .findFirst();
        longestPalidnrom.ifPresent(System.out::println);
    }

    private static boolean findPalindrom(String s){
        int end = s.length()-1;
        int start = 0;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;end--;
        }
        return true;
    }

    //Flatten this map into a list of strings like:
    // USA-New York, USA-Los Angeles, India-Delhi, India-Mumbai, UK-London, UK-Manchester
    private static void flattenJSONLikeStructure(){
        Map<String, List<String>> countryCities = new HashMap<>();
        countryCities.put("USA", Arrays.asList("New York", "Los Angeles"));
        countryCities.put("India", Arrays.asList("Delhi", "Mumbai"));
        countryCities.put("UK", Arrays.asList("London", "Manchester"));

        List<String> list = countryCities.entrySet()
                .stream()
                .flatMap(entry->entry.getValue().stream().map(city->entry.getKey()+"-"+city))
                .collect(Collectors.toList());
        System.out.println(list);
    }

    private static void SumTransactionAmountsByStock(){

        List<Transaction> transactions = Arrays.asList(
                new Transaction("AAPL", 1000.0),
                new Transaction("GOOG", 1500.0),
                new Transaction("AAPL", 2000.0),
                new Transaction("MSFT", 1200.0),
                new Transaction("GOOG", 500.0));

        Map<String,Double> result = transactions
                .stream()
                .collect(Collectors.groupingBy(t->t.getStock(),Collectors.summingDouble(t->t.getAmount())));
        System.out.println(result);
    }

    private static void findKthSmallestElement(){
        List<Integer> nums = Arrays.asList(7, 10, 4, 3, 20, 15, 12, 45, 32, 43, 14);
        Optional<Integer> number = nums.stream().sorted().limit(3).sorted(Comparator.reverseOrder()).findFirst();
        number.ifPresentOrElse(System.out::println,()-> System.out.println("Not found"));
    }

    private static void groupByGender(){

        //Map<String,Integer> genderMap = employeeList.stream().map(e->e.getGender()).collect(Collectors.groupingBy(gender->gender,Collectors.counting()));
    }

}

class Employee {
    String name;
    String department;
    double salary;

    Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class Transaction {
    String stock;
    double amount;

    Transaction(String stock, double amount) {
        this.stock = stock;
        this.amount = amount;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
