package FlipAndInvertImage_832;


import java.util.Arrays;
import java.util.Collections;

/**
 * 给定一个二进制矩阵A，我们想先水平翻转图像，然后反转图像并返回结果。
 *
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转[1, 1, 0]的结果是[0, 1, 1]。
 *
 * 反转图片的意思是图片中的0全部被1替换，1全部被0替换。例如，反转[0, 1, 1]的结果是[1, 0, 0]。
 */
public class FlipAndInvertImage {

    public static void main(String[] args) {

        int[][] A={{1,1,0},{1,0,1},{0,0,0}};
        int[][] result=new FlipAndInvertImage().flipAndInvertImage(A);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.println(A[i][j]);
            }
        }


    }

    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            A[i]=helper(A[i]);
        }
        for (int i = 0; i < A.length; i++) {
            for (int k = 0; k < A[i].length; k++) {
                A[i][k]^=1;
            }
        }
        return A;
    }

    public int[] helper(int[] A){
        int[] B=new int[A.length];
        for (int i = 0; i < B.length; i++) {
            B[i]=A[A.length-i-1];
        }
        return B;

    }

    public int[][] flipAndInvertImage2(int[][] A) {
        int C = A[0].length;
        for (int[] row: A)
            for (int i = 0; i < (C + 1) / 2; ++i) {
                int tmp = row[i] ^ 1;
                row[i] = row[C - 1 - i] ^ 1;
                row[C - 1 - i] = tmp;
            }

        return A;
    }

}
