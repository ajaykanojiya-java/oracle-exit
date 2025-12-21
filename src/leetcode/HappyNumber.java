package leetcode;

/*A happy number is a number defined by the following process:
* Starting with any positive integer, replace the number by the sum of the squares of its digits.
* Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
* Those numbers for which this process ends in 1 are happy.
* Example 1:
* Input: n = 19
* Output: true
* Explanation:
* 1 + 81 = 82
* 64 + 4 = 68
* 36 + 64 = 100
* 1 + 0 + 0 = 1
* logic: Finding happy number could conclude in one of the two ways
* Case 1: the process continues until the final number is 1
* Case 2: the process gets stuck in an infinite loop, meaning there could be a cycle like linked list
* */

public class HappyNumber {
    public static void main(String[] args) {
        int number = 23;
        System.out.println(number+ " is happy number "+isHappyNumber(number));
    }

    public static boolean isHappyNumber(int number){
        int slow = number;
        int fast = number;
        while(true){
            //advance the slow pointer one number at a time
            slow = getNextNumber(slow);
            //advance the fast pointer two numbers at a time
            fast = getNextNumber(getNextNumber(fast));
            if (fast == 1)
                return true;
            else if(fast == slow) //both meets so there is a cycle, so return false
                return false;
        }
    }

    private static int getNextNumber(int number){
        int nextNumber=0;
        int digit = 0;
        while(number>0){
            //extract the last digit of number
            digit = number % 10;
            //truncate last digit of the number
            number = number / 10;
            nextNumber = nextNumber + digit*digit;
        }
        return nextNumber;
    }
}
