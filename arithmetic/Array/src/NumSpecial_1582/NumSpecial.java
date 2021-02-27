package NumSpecial_1582;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，
 * 请返回 矩阵mat 中特殊位置的数目 。
 *
 * 特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），
 * 则位置 (i, j) 被称为特殊位置。
 */
public class NumSpecial {

    public static void main(String[] args) {
        int[][] mat={
        {1,0,0},
        {0,0,1},
        {1,0,0},
        };
        int result=new NumSpecial().numSpecial(mat);
        System.out.println(result);
    }

    public int numSpecial(int[][] mat) {

        int row=mat.length;
        int col=mat[0].length;
        int[] rows=new int[row];
        int[] cols=new int[col];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j]==1){
                   rows[i]++;
                   cols[j]++;
                }
            }
        }

        int ans=0;
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < cols.length; j++) {
                if (mat[i][j]==1&&rows[i]==1&&cols[j]==1){
                    ans++;
                }
            }
        }
        return ans;
    }
}
