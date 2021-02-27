package CountBalls_1742;


import java.util.HashMap;
import java.util.Map;

/**
 * 你在一家生产小球的玩具厂工作，有 n 个小球，编号从 lowLimit 开始，
 * 到 highLimit 结束（包括 lowLimit 和highLimit ，
 * 即n == highLimit - lowLimit + 1）。另有无限数量的盒子，
 * 编号从 1 到 infinity 。
 *
 * 你的工作是将每个小球放入盒子中，其中盒子的编号应当等于小球编号上每位数字的和。
 * 例如，编号 321 的小球应当放入编号 3 + 2 + 1 = 6 的盒子，
 * 而编号 10 的小球应当放入编号 1 + 0 = 1 的盒子。
 *
 * 给你两个整数 lowLimit 和 highLimit ，返回放有最多小球的盒子中的小球数量。
 * 如果有多个盒子都满足放有最多小球，只需返回其中任一盒子的小球数量。
 *
 */
public class CountBalls {


    public static void main(String[] args) {
        int lowLimit=5,highLimit=15;
        int result=new CountBalls().countBalls(lowLimit,highLimit);
        System.out.println(result);
    }

    public int countBalls(int lowLimit, int highLimit) {
        int max=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = lowLimit; i <= highLimit ; i++) {
            int key=i;
            int sum=0;
            while (key!=0){
                sum+=key%10;
                key/=10;
            }

            map.put(sum,map.getOrDefault(sum,0)+1);
            max=Math.max(max,map.get(sum));
        }

        return max;
    }

    public int countBalls2(int lowLimit, int highLimit) {
        // 盒子所有可能编号为下标组成的数组
        int[] arr = new int[46];
        // 第一个小球对应的盒子的编号
        int index = sum(lowLimit);
        arr[index]++;
        // 将小球放入对应编号的盒子中
        for (int i = lowLimit + 1; i <= highLimit; i++) {
            // 利用前一个小球对应盒子的编号，
            // 求出后一个小球对应盒子的编号
            int endZeroCount = endZeroCount(i);
            index += 1 - 9 * endZeroCount;
            arr[index]++;
        }
        // 找出最多小球的盒子中的小球数量
        int maxNum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxNum) {
                maxNum = arr[i];
            }
        }
        return maxNum;
    }
    //数字的各个位之和
    public int sum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
    //数字末尾连续0的个数
    public int endZeroCount(int num) {
        int endZeroCount = 0;
        while (num % 10 == 0) {
            num = num / 10;
            endZeroCount++;
        }
        return endZeroCount;
    }


}
