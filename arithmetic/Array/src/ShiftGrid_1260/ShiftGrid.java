package ShiftGrid_1260;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n列的二维网格grid和一个整数k。你需要将grid迁移k次。
 * <p>
 * 每次「迁移」操作将会引发下述活动：
 * <p>
 * 位于 grid[i][j]的元素将会移动到grid[i][j + 1]。
 * 位于 grid[i][n- 1] 的元素将会移动到grid[i + 1][0]。
 * 位于 grid[m- 1][n - 1]的元素将会移动到grid[0][0]。
 * 请你返回k 次迁移操作后最终得到的 二维网格。。
 */
public class ShiftGrid {

    public static void main(String[] args) {
    int[][] grid={

        {1,2,3},
        {4,5,6},
        {7,8,9}
    };
    int k=1;
        List<List<Integer>> result=new ShiftGrid().shiftGrid(grid,k);
        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }

    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        for (;k>0;k--){
            int previous=grid[grid.length-1][grid[0].length-1];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    int temp=grid[i][j];
                    grid[i][j]=previous;
                    previous=temp;
                }
            }
        }


        return getLists(grid);

    }

    private List<List<Integer>> getLists(int[][] grid) {
        List<List<Integer>> result=new ArrayList<>();

        for (int[] row : grid) {

            List<Integer> listRow=new ArrayList<>();
            result.add(listRow);
            for (int i : row) {
                listRow.add(i);
            }

        }

        return result;
    }


    public List<List<Integer>> shiftGrid2(int[][] grid, int k) {

        // Repeat the transform k times.
        for (;k > 0; k--) {
            // We'll write the transform into a new 2D array.
            int[][] newGrid = new int[grid.length][grid[0].length];

            // Case #1: Move everything not in the last column.
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length - 1; col++) {
                    newGrid[row][col + 1] = grid[row][col];
                }
            }

            // Case #2: Move everything in last column, but not last row.
            for (int row = 0; row < grid.length - 1; row++) {
                newGrid[row + 1][0] = grid[row][grid[0].length - 1];
            }

            // Case #3: Move the bottom right.
            newGrid[0][0] = grid[grid.length - 1][grid[0].length - 1];

            // Update grid to be the transformed grid.
            grid = newGrid;
        }

        // Copy the grid into a list for returning.
        return getLists(grid);
    }


}
