package MaxProfit_63;

public class MaxProfit {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {

        if (prices.length==0){
            return 0;
        }

        int minPrice=prices[0];
        int ans=0;
        for (int i = 1; i < prices.length; i++) {
            if (minPrice>=prices[i]){
                minPrice=prices[i];
                continue;
            }else {

                ans=Math.max(prices[i]-minPrice,ans);
            }
        }



        return ans;
    }



    public int maxProfit2(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for(int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }


}
