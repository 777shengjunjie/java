package MaxProfit_121;


/**
 * 给定一个数组，它的第i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），
 * 设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 */
public class MaxProfit {

    public static void main(String[] args) {

        int[] prices={7,1,5,3,6,4};
        int result=new MaxProfit().maxProfit2(prices);
        System.out.println(result);
    }

    public int maxProfit(int[] prices){
        int min=0,max=0;
        int maxProfit=0;
        for (int i = 0; i < prices.length; i++) {
            min=prices[i];
            for (int j = i+1; j < prices.length; j++) {
                max=prices[j];
                if (maxProfit<max-min){
                    maxProfit=max-min;
                }
            }
        }
        return maxProfit;

    }
    public int maxProfit2(int[] prices){
        int min=Integer.MAX_VALUE;
        int maxProfit=0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]<min){
                min=prices[i];
            }else if (maxProfit<prices[i]-min){
                maxProfit=prices[i]-min;
            }
        }
        return maxProfit;

    }
}
