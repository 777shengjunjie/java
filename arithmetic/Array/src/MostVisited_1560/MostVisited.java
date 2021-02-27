package MostVisited_1560;


import java.util.*;

/**
 * 给你一个整数 n 和一个整数数组 rounds 。
 * 有一条圆形赛道由 n 个扇区组成，扇区编号从 1 到 n 。
 * 现将在这条赛道上举办一场马拉松比赛，该马拉松全程由 m 个阶段组成。
 * 其中，第 i 个阶段将会从扇区 rounds[i - 1] 开始，到扇区 rounds[i] 结束。
 * 举例来说，第 1 阶段从rounds[0]开始，到rounds[1]结束。
 *
 * 请你以数组形式返回经过次数最多的那几个扇区，按扇区编号 升序 排列。
 *
 * 注意，赛道按扇区编号升序逆时针形成一个圆（请参见第一个示例）。
 */
public class MostVisited {

    public static void main(String[] args) {
    int n=4;
    int[] rounds={1,3,1,2};
    List<Integer> result=new MostVisited().mostVisited(n,rounds);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    public List<Integer> mostVisited(int n, int[] rounds) {

        List<Integer> ret = new ArrayList<Integer>();
        int length = rounds.length;
        int start = rounds[0], end = rounds[length - 1];
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                ret.add(i);
            }
        } else { // 由于题目要求按扇区大小排序，因此我们要将区间分成两部分
            for (int i = 1; i <= end; i++) {
                ret.add(i);
            }
            for (int i = start; i <= n; i++) {
                ret.add(i);
            }
        }
        return ret;

    }
}
