package GetRow_119;


import java.util.ArrayList;
import java.util.List;

/**
 *  给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *  在杨辉三角中，每个数是它左上方和右上方的数的和。
 */
public class GetRow {

    public static void main(String[] args) {

        int rowindex=3;
        List<Integer> result=new GetRow().getRow(rowindex);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }


    public List<Integer> getRow(int rowIndex) {

        List<Integer> pre=new ArrayList<>();
        pre.add(1);
        if (rowIndex==0) return pre ;

        for (int i = 1; i < rowIndex+1; i++) {
            List<Integer> cur=new ArrayList<>();
            cur.add(1);
            for (int j = 1; j <i ; j++) {
                cur.add(pre.get(j-1)+ pre.get(j));
            }
            cur.add(1);
            pre=cur;
            if (i==rowIndex) return cur;
        }

      return pre;


    }

}
