package AllCellsDistOrder_1030;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/*
度简单44给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，
        满足 0 <= r < R 且 0 <= c < C。
        另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
        返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小
        到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离
        是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件
        的顺序返回答案。）
*/
public class AllCellsDistOrder {

    private static class Pos{

        int r;
        int c;

        public Pos(int r,int c){
            this.r=r;
            this.c=c;
        }

    }

    public static void main(String[] args) {

       int R=1,C=2,r0=0,c0=0;
       int[][] result=new AllCellsDistOrder().allCellsDistOrder(R,C,r0,c0);

       for (int i=0;i<result.length;i++){
           for (int j=0;j<result[i].length;j++){
               System.out.println(result[i][j]);
           }
       }


    }

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0){

        int[][] ans=new int[R*C][2];
        int maxDist=Math.max(r0,R-1-r0)+Math.max(c0,C-1-c0);
        ArrayList<LinkedList<Pos>> bucket=new ArrayList<>();


        for (int i = 0; i <= maxDist; i++) {
            bucket.add(new LinkedList<>());
        }

        for(int i=0;i<R;i++){
            for (int j=0;j<C;j++){
                int d=dist(i,j,r0,c0);
                LinkedList<Pos> list=bucket.get(d);
                list.add(new Pos(i,j));
            }
        }


        int cut=0;
        for(int i=0;i<=maxDist;i++){
            LinkedList<Pos> list=bucket.get(i);
            if (list.isEmpty()) continue;

            for (Pos pos : list) {
                ans[cut][0]=pos.r;
                ans[cut][1]=pos.c;
                cut++;
            }
        }



        return ans;
    }

    public int dist(int r1,int c1,int r2,int c2){
        return Math.abs(r1-r2)+Math.abs(c1-c2);
    }

    public int[][] allCellsDistOrder2(int R, int C, int r0, int c0) {
        int[][] re = new int[R * C][2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int t = i*C+j;
                re[t][0] = i;
                re[t][1] = j;
            }
        }
        Arrays.sort(re, (arr1, arr2) -> {
            int d1 = dist(arr1[0], arr1[1], r0, c0);
            int d2 = dist(arr2[0], arr2[1], r0, c0);
            return Integer.compare(d1, d2);
        });

        return re;
    }



}
