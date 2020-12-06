package CountNegatives_1351;


import java.util.Arrays;

/**
 * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
 * <p>
 * 请你统计并返回 grid 中 负数 的数目。
 */
public class CountNegatives {

    public static void main(String[] args) {
        int[][] grid = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        };
        int result = new CountNegatives().countNegatives(grid);
        System.out.println(result);
    }
        public int countNegatives ( int[][] grid){
           int ans=0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                  if (grid[i][j]<0){
                     ans++;
                  }
                }
            }

            return ans;
        }
    }
