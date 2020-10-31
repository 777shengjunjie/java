package FindJudge_997;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 在一个小镇里，按从 1 到 N 标记了N 个人。传言称，这些人中有一个是小镇上的秘密法官。
 * 如果小镇的法官真的存在，那么：
 * 小镇的法官不相信任何人。
 * 每个人（除了小镇法官外）都信任小镇的法官。
 * 只有一个人同时满足属性 1 和属性 2 。
 * 给定数组trust，该数组由信任对 trust[i] = [a, b]组成，表示标记为 a 的人信任标记为 b 的人。
 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
 */
public class FindJudge {

    public static void main(String[] args) {

       /* int N=3;
        int[][] trust={{1,3},{2,3},{3,1}};*/
        int N=2;
        int[][] trust={{1,2}};
        int result=new FindJudge().findJudge(N,trust);
        System.out.println(result);

    }

    public int findJudge(int N,int[][] trust){

        int[] degree=new int[N+1];

        for (int[] ints : trust) {
            degree[ints[1]]++;// 获得投票
            degree[ints[0]]--;// 投出一票
        }

        int judge=-1;

        for (int i = 1; i <= N; i++) {
            if (degree[i]==N-1) {
                judge = i;
                break;
            }
        }

        return judge;
    }
}
