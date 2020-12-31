package MaximumWealth_1672;


/**
 * 给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i位客户在第 j 家银行托管的资产数量。
 * 返回最富有客户所拥有的 资产总量 。
 *
 * 客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。

 */
public class MaximumWealth {

    public static void main(String[] args) {
        int[][] accounts={
                {1,5},
                {7,3},
                {3,5},
        };
        int result=new MaximumWealth().maximumWealth(accounts);
        System.out.println(result);

    }

    public int maximumWealth(int[][] accounts) {
        int ans=0;

        for (int i = 0; i < accounts.length; i++) {
            int max=0;
            for (int j = 0; j < accounts[i].length; j++) {
                max+=accounts[i][j];
            }
            if (ans<max){
                ans=max;
            }
        }

        return ans;

    }

    public int maximumWealth2(int[][] accounts) {
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 1; j < accounts[i].length; j++) {

                accounts[i][0] += accounts[i][j];
            }
            accounts[0][0] = Math.max(accounts[0][0], accounts[i][0]);
        }
        return accounts[0][0];
    }


}
