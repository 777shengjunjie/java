package SumEvenAfterQueries_985;

/**
 * 给出一个整数数组A和一个查询数组queries。
 * 对于第i次查询，有val =queries[i][0], index= queries[i][1]，
 * 我们会把val加到A[index]上。然后，第i次查询的答案是 A 中偶数值的和。
 * （此处给定的index = queries[i][1]是从 0 开始的索引，
 * 每次查询都会永久修改数组A。）
 * 返回所有查询的答案。你的答案应当以数组answer给出，answer[i]为第i次查询的答案。
 */
public class SumEvenAfterQueries {

    public static void main(String[] args) {

        int[] A={1,2,3,4};
        int[][] queries={
                {1,0},{-3,1},{-4,0},{2,3},
        };
        int[] result=new SumEvenAfterQueries().sumEvenAfterQueries2(A,queries);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {

        int[] result=new int[A.length];
        for (int i = 0; i < queries.length; i++) {
           A[queries[i][1]]+=queries[i][0];
            for (int j : A) {
                if (j%2==0){
                    result[i]+=j;
                }
            }
        }

        return result;
    }

    public int[] sumEvenAfterQueries2(int[] A, int[][] queries) {
        int S = 0;
        for (int x: A)
            if (x % 2 == 0)
                S += x;

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; ++i) {
            int val = queries[i][0], index = queries[i][1];
            if (A[index] % 2 == 0) S -= A[index];
            A[index] += val;
            if (A[index] % 2 == 0) S += A[index];
            ans[i] = S;
        }

        return ans;
    }


}
