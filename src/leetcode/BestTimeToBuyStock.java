package leetcode;
/*Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.*/

public class BestTimeToBuyStock {
    public static void main(String[] args) {
        int [] num =  {2,1,2,1,0,1,2};
        System.out.println("MaxProfit: "+maxProfit(num));
    }
    public static int maxProfit(int[] prices){
        int minPrice = prices[0];
        int maxProfit = 0, profit = 0;
        for (int i=0; i<prices.length; i++){
            //calculate the profit
            profit = prices[i] - minPrice;
            //update max profit
            maxProfit = Math.max(maxProfit,profit);
            //update min price seen so far
            minPrice = Math.min(minPrice,prices[i]);
        }
        return maxProfit;
    }
}
