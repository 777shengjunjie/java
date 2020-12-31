package KWeakestRows_1337;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个大小为m* n的矩阵mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 *
 * 请你返回矩阵中战斗力最弱的k行的索引，按从最弱到最强排序。
 *
 * 如果第i行的军人数量少于第j行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 *
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 */
public class KWeakestRows {

    public static void main(String[] args) {
        int[][] mat={
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}
        };
        int k=3;
        int[] result=new KWeakestRows().kWeakestRows(mat,k);
        for (int i : result) {
            System.out.println(i);
        }

    }

    public int[] kWeakestRows(int[][] mat, int k) {

        int[] ans=new int[k];
        Map<Integer,Integer> count=new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j]==1){
                    count.put(i, count.getOrDefault(i, 0) + 1);
                }
            }
            if (!count.containsKey(i)){
                count.put(i,0);
            }
        }

        ArrayList<Map.Entry<Integer,Integer>> list=new ArrayList<>(count.entrySet());

        list.sort((o1,o2)->{
            return o1.getValue()-o2.getValue();
        });

        for (int i=0;i<k;i++){
            ans[i]=list.get(i).getKey();
        }

        return ans;

    }
}
