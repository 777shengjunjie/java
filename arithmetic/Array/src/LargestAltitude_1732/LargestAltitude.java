package LargestAltitude_1732;


/**
 * 有一个自行车手打算进行一场公路骑行，这条路线总共由n + 1个不同海拔的点组成。
 * 自行车手从海拔为 0的点0开始骑行。
 * <p>
 * 给你一个长度为 n的整数数组gain，其中 gain[i]是点 i和点 i + 1的
 * 净海拔高度差（0 <= i < n）。请你返回 最高点的海拔
 */
public class LargestAltitude {

    public static void main(String[] args) {
        int[] gain = {-5, 1, 5, 0, -7};
        int result = new LargestAltitude().largestAltitude(gain);
        System.out.println(result);
    }

    public int largestAltitude(int[] gain) {

        int max = 0;
        int height = 0;
        for (int i = 0; i < gain.length; i++) {
            height += gain[i];
            max = Math.max(max, height);
        }

        return max;
    }


}
