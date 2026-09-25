import java.util.Arrays;

public class L2 {
    /**
     * Finds the maximum profit from buying and selling a stock once.
     * Single pass tracking running minimum price and maximum profit.
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Input: " + Arrays.toString(prices1));
        System.out.println("Max Profit: " + maxProfit(prices1));

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Input: " + Arrays.toString(prices2));
        System.out.println("Max Profit: " + maxProfit(prices2));
    }
}
