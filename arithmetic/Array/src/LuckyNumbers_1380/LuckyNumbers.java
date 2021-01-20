package LuckyNumbers_1380;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 * <p>
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 * <p>
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 * m == mat.length
 * n == mat[i].length
 * 1 <= n, m <= 50
 * 1 <= matrix[i][j] <= 10^5
 */
public class LuckyNumbers {

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 7, 8},
                {9, 11, 13},
                {15, 16, 17},
        };
        List<Integer> result = new LuckyNumbers().luckyNumbers(matrix);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        int r = matrix.length, c = matrix[0].length;
        int[] rMin = new int[r];
        Arrays.fill(rMin, Integer.MAX_VALUE);
        int[] cMax = new int[c];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                rMin[i]=Math.min(rMin[i],matrix[i][j]);
                cMax[j]=Math.max(cMax[j],matrix[i][j]);
            }
        }
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (rMin[i]==cMax[j]) {
                    ans.add(rMin[i]);
                }
            }
        }

        return ans;
    }

    public List<Integer> luckyNumbers2 (int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int[] rMin = new int[r];
        Arrays.fill(rMin, Integer.MAX_VALUE);
        int[] cMax = new int[c];
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                rMin[i] = Math.min(rMin[i], matrix[i][j]);
                cMax[j] = Math.max(cMax[j], matrix[i][j]);
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (matrix[i][j] == rMin[i] && matrix[i][j] == cMax[j]) {
                    ans.add(matrix[i][j]);
                }
            }
        }
        return ans;
    }

}
