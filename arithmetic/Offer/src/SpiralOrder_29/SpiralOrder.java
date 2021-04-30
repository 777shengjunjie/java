package SpiralOrder_29;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public static void main(String[] args) {

    }

    public int[] spiralOrder(int[][] matrix) {
       if (matrix==null||matrix.length==0||matrix[0].length==0){
           return new int[0];
       }

       int rows=matrix.length,cols=matrix[0].length;
       int total=rows*cols;
       int[] order=new int[total];
       boolean[][] visited=new boolean[rows][cols];
       int row=0,col=0;
       int[][] direction={{0,1},{1,0},{0,-1},{-1,0}};
       int directionIndex=0;
        for (int i = 0; i < total; i++) {
            order[i]=matrix[row][col];
            visited[row][col]=true;
            int nextRow=row+direction[directionIndex][0],nextCol=col+direction[directionIndex][1];
            if (nextRow<0||nextRow>=rows||nextCol<0||nextCol>=cols||visited[nextRow][nextCol]){
                directionIndex=(directionIndex+1)%4;
            }

            row+=direction[directionIndex][0];
            col+=direction[directionIndex][1];
        }


        return order;

    }
    public int[] spiralOrder2(int[][] matrix) {

        if (matrix.length==0) return new int[0];
        int l=0,r=matrix[0].length-1,t=0,b=matrix.length-1,index=0;
        int[] ans=new int[(r+1)*(b+1)];
        while (true){

            for (int i=l;i<=r;i++) ans[index++]=matrix[t][i];
            if (++t>b) break;
            for (int i=t;i<=b;i++) ans[index++]=matrix[i][r];
            if (l>--r) break;
            for (int i=r;i>=l;i--) ans[index++]=matrix[b][i];
            if (t>--b) break;
            for (int i=b;i>=t;i--) ans[index++]=matrix[i][l];
            if (++l>r) break;


        }

        return ans;


    }

}
