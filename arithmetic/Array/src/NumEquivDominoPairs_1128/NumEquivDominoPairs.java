package NumEquivDominoPairs_1128;


import java.util.Arrays;

/**
 * 给你一个由一些多米诺骨牌组成的列表dominoes。
 * <p>
 * 如果其中某一张多米诺骨牌可以通过旋转 0度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 * <p>
 * 形式上，dominoes[i] = [a, b]和dominoes[j] = [c, d]等价的前提是a==c且b==d，或是a==d 且b==c。
 * <p>
 * 在0 <= i < j < dominoes.length的前提下，找出满足dominoes[i] 和dominoes[j]等价的骨牌对 (i, j) 的数量。
 */
public class NumEquivDominoPairs {

    public static void main(String[] args) {
//        String[] a=new String[2];
//        for (String i : a) {
//            System.out.println(i);
    int[][] dominoes={
            {1,2},
            {2,1},
            {2,1},
            {2,1},
    };

    int result=new NumEquivDominoPairs().numEquivDominoPairs(dominoes);
        System.out.println(result);
    }


    public int numEquivDominoPairs(int[][] dominoes) {

        int ans = 0;
        int[] cp = new int[100];
        for(int[] arr:dominoes){
            Arrays.sort(arr);
            ans+=cp[arr[0]*10+arr[1]]++;
        }
        return ans;


    }
}
