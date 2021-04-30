package FindNumberIn2DArray_04;

import javax.print.DocFlavor;
import javax.xml.bind.annotation.XmlInlineBinaryData;

public class FindNumberIn2DArray {


    public static void main(String[] args) {
//        int[][] matrix={
//                {1,   4,  7, 11, 15},
//                {2,   5,  8, 12, 19},
//                {3,   6,  9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
//        };
        int[][] matrix={
                {-1,   3},
        };
        int target=3;
        boolean result=new FindNumberIn2DArray().findNumberIn2DArray(matrix,target);
        System.out.println(result);
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix.length==0||matrix[0].length==0){
            return false;
        }
        int rowLength = matrix.length;
        int end = rowLength - 1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0]==target){
                return true;
            }
            if (matrix[i][0] < target) {
                end = i;
            }
        }
        if (end < 0) {
            return false;
        }

        int col=matrix[0].length;
        for (int j = 0; j < end+1; j++) {
            int begin = 0;
            int tail = col - 1;
            while (begin < tail) {
                int middle = (begin + tail) / 2 + 1;
                if (matrix[j][middle] == target) {
                    return true;
                } else if (matrix[j][middle] < target) {
                    begin = middle;
                }else {
                    tail=middle-1;
                }
            }
        }
        return false;
    }


    /**
     * 从二维数组的右上角开始查找。如果当前元素等于目标值，则返回 true。如果当前元素大于目标值，
     * 则移到左边一列。如果当前元素小于目标值，则移到下边一行。
     *
     * 可以证明这种方法不会错过目标值。如果当前元素大于目标值，
     * 说明当前元素的下边的所有元素都一定大于目标值，因此往下查找不可能找到目标值，
     * 往左查找可能找到目标值。如果当前元素小于目标值，说明当前元素的左边的所有元素都一定小于目标值，
     * 因此往左查找不可能找到目标值，往下查找可能找到目标值。
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

}
