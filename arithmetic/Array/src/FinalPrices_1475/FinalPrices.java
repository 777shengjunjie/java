package FinalPrices_1475;

import java.util.Stack;

/**
 * 给你一个数组prices，其中prices[i]是商店里第i件商品的价格。
 * <p>
 * 商店里正在进行促销活动，如果你要买第i件商品，那么你可以得到与 prices[j] 相等的折扣，
 * 其中j是满足j > i且prices[j] <= prices[i]的最小下标，如果没有满足条件的j，你将没有任何折扣。
 * <p>
 * 请你返回一个数组，数组中第i个元素是折扣后你购买商品 i最终需要支付的价格。
 */
public class FinalPrices {

    public static void main(String[] args) {
        int[] prices={8,4,6,2,3};
        int[] result=new FinalPrices().finalPrices2(prices);
        for (int i : result) {
            System.out.println(i);
        }

    }

    public int[] finalPrices(int[] prices) {

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i]>=prices[j]){
                    prices[i]-=prices[j];
                    break;
                }
            }
        }

        return prices;
    }

    public int[] finalPrices2(int[] prices) {
        int len = prices.length;

        Stack<Integer> stack=new Stack<>();
        for(int i = 0; i < len; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int index = stack.pop();    // java 的pop可以直接获取顶元素就不用像c++ 一样先top再pop了
                prices[index] -= prices[i];
            }
            stack.push(i);
        }
        return prices;
    }


}
