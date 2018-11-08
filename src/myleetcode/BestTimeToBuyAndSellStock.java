package myleetcode;

/**
 * 买卖股票的最佳时机
 * @author acer
 *
 */
public class BestTimeToBuyAndSellStock {
	
	public int maxProfit(int[] prices) {
		int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
	
}
