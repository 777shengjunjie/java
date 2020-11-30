package MinCostClimbingStairs_746;

/**
 * 数组的每个索引作为一个阶梯，第i个阶梯对应着一个非负数的体力花费值cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] cost={1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int result=new MinCostClimbingStairs().minCostClimbingStairs(cost);
        System.out.println(result);
    }

    public int minCostClimbingStairs(int[] cost) {
        int f1=0,f2=0;
        for (int i = 0; i < cost.length; i++) {
            int cur=cost[i]+Math.min(f1,f2);
            f1=f2;
            f2=cur;
        }
        return Math.min(f1,f2);
    }
}
