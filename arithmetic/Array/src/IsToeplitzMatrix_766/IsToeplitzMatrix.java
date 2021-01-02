package IsToeplitzMatrix_766;


/**
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 * <p>
 * 给定一个M x N的矩阵，当且仅当它是托普利茨矩阵时返回True。
 */
public class IsToeplitzMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2},
        };
        boolean result = new IsToeplitzMatrix().isToeplitzMatrix(matrix);
        System.out.println(result);

    }

    public boolean isToeplitzMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }

        return true;

    }
}
