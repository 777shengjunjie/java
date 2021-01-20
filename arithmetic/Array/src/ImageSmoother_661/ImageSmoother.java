package ImageSmoother_661;


/**
 * 包含整数的二维矩阵 M 表示一个图片的灰度。
 * 你需要设计一个平滑器来让每一个单元的灰度成为平均灰度(向下舍入) ，
 * 平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
 */
public class ImageSmoother {

    public static void main(String[] args) {

        int[][] M={
                {1,1,1},
                {1,0,1},
                {1,1,1},
        };
        int[][] result=new ImageSmoother().imageSmoother(M);
        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }

    }

    public int[][] imageSmoother(int[][] M) {

        int col=M[0].length;
        int row=M.length;
        int[][] result=new int[row][col];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                int sum=0;
                int count=0;
                for (int ir = i-1; ir <= i+1; ir++) {
                    for (int jc = j-1; jc <= j+1; jc++) {
                        if (ir>=0&&ir<row&&jc>=0&&jc<col){
                            sum+=M[ir][jc];
                            count++;

                        }
                    }
                }

                result[i][j]=sum/count;

            }
        }

        return result;
    }
}
