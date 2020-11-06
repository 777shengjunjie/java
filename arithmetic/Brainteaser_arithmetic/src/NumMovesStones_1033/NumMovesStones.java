package NumMovesStones_1033;


import java.util.Arrays;

/**
 * 三枚石子放置在数轴上，位置分别为 a，b，c。
 * 每一回合，我们假设这三枚石子当前分别位于位置 x, y, z 且 x < y < z。从位置 x 或者是位置 z 拿起一枚石子，
 * 并将该石子移动到某一整数位置 k 处，其中 x < k < z 且 k != y。
 * 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。
 * 要使游戏结束，你可以执行的最小和最大移动次数分别是多少？
 * 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves]
 */
public class NumMovesStones {


    public static void main(String[] args) {
        int a=1,b=2,c=5;
        int[] result=new NumMovesStones().numMovesStones(a,b,c);
        for (int i : result) {
            System.out.println(i);
        }
    }

    /**
     * 现在只剩三个石子都不连续的情况，例如，1,3,5，开始也坑在这里了，看到别人代码的注释才知道，
     * 1移到4的位置或者5移到2的位置，这样最小步数就是1了。
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int[] numMovesStones(int a,int b,int c){

        int[] moves={a,b,c};
        //升序
        Arrays.sort(moves);
        if (moves[0]+2==moves[2]){
            return new int[]{0,0};
        }else if (moves[0]+1==moves[1]||moves[1]+1==moves[2]||moves[0]+2==moves[1]||moves[1]+2==moves[2]){
          return new int[]{1,moves[2]-moves[0]-2};
        }else {
            return new int[] {2,moves[2]-moves[0]-2};
        }
    }


}
