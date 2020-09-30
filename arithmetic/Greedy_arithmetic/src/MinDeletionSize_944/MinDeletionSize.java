package MinDeletionSize_944;






/*

给定由N个小写字母字符串组成的数组 A，其中每个字符串长度相等。

        你需要选出一组要删掉的列D，对A 执行删除操作，使 A 中剩余的每一列都是 非降序排列的，然后请你返D.length的
        最小可能值。删除 操作的定义是：选出一组要删掉的列，删去A 中对应列中的所有字符，形式上，第 n列 [A[0][n],
        A[1][n], ..., A[A.length-1][n]]）。（可以参见 删除操作范例）
*/
public class MinDeletionSize {

    public static void main(String[] args) {

        String [] A={"cba", "daf", "ghi"};
        int result=new MinDeletionSize().minDeletionSize(A);
        System.out.println(result);

    }

    public int minDeletionSize(String[] A){

        int ans=0;

        for (int i = 0; i < A[0].length(); i++) {

            for(int j=0;j<A.length-1;j++)
                if (A[j].charAt(i)>A[j+1].charAt(i)){
                    ans++;
                    break;
                }

            }

        return ans;

    }

}
