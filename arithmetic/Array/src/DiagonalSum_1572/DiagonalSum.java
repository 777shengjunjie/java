package DiagonalSum_1572;


/**
 * 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
 *
 * 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
 */
public class DiagonalSum {


    public static void main(String[] args) {

        int[][] mat={
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        int result=new DiagonalSum().diagonalSum(mat);
        System.out.println(result);


    }


    public int diagonalSum(int[][] mat) {
        int length=mat.length;
        int ans=0;
        if (length%2==0){
            for (int i = 0; i < mat.length; i++) {
                ans+=mat[i][i]+mat[i][length-1-i];
            }
        }else {
            for (int i = 0; i < mat.length; i++) {
                ans+=mat[i][i]+mat[i][length-1-i];
            }
            ans-=mat[length/2][length/2];
        }

        return ans;
    }

}
