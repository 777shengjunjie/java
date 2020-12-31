package Transpose_867;


/**
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 *
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 */
public class Transpose {

    public static void main(String[] args) {

        int[][] A={{1,2,3},{4,5,6}};
        int[][] result=new Transpose().transpose(A);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.println(result[i][j]);
            }
        }

    }


    public int[][] transpose(int[][] A) {
        int row=A.length,col=A[0].length;
        int[][] tra=new int[col][row];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                tra[j][i]=A[i][j];
            }
        }
        return tra;

    }

}
