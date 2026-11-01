public class BestTimeToBuyAndSellStockWithTransactionFeePractice {

    public static int maxProfit(int[] prices, int fee) {
        int cash = 0;
        int hold = -prices[0];

        for (int i = 1; i < prices.length; i++) {

            int previousCash = cash;
            int previousHold = hold;

            // Sell stock and pay transaction fee
            cash = Math.max(previousCash, previousHold + prices[i] - fee);

            // Buy stock
            hold = Math.max(previousHold, previousCash - prices[i]);
        }

        return cash;
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;

        System.out.println(maxProfit(prices, fee));
    }
}
