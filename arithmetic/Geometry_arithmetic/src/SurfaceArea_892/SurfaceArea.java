package SurfaceArea_892;


/**
 * 在N*N的网格上，我们放置一些1 * 1 * 1的立方体。
 * 每个值v = grid[i][j]表示v个正方体叠放在对应单元格(i, j)上。
 * 请你返回最终形体的表面积。
 */
public class SurfaceArea {



    public static void main(String[] args) {

        int[][] grid={{1,0},{0,2}};
        int result=new SurfaceArea().surfaceArea(grid);
        System.out.println(result);
    }

    public int surfaceArea(int[][] grid){

        int sum=0;

        //列数
        int col=grid.length;
        //行数
        int row=grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int num=grid[i][j];

                if (num>0){

                sum+=num*4+2;
                sum-= j>0 ?Math.min(num,grid[i][j-1])*2:0;
                sum-= i>0?Math.min(num,grid[i-1][j])*2:0;
                }

            }
        }

        return sum;

    }



}
