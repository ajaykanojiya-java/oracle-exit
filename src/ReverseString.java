public class ReverseString {

    private static String name = new String ("ajaykanojiya");

    public static void main(String[] args) {
        int length = name.length();
        char[] charArray = name.toCharArray();
        for (int i=0;i<length/2;i++){
            char c = charArray[i];
            charArray[i] = charArray[(length-1)-i];
            charArray[(length-1)-i] = c;
        }
        System.out.println("Reversed String: "+new String (charArray));
    }
}
