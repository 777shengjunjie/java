package CuttingRope_14_1;

public class CuttingRope {

    public static void main(String[] args) {
        int n=10;
        int res=new CuttingRope().cuttingRope(n);
        System.out.println(res);
    }

    public int cuttingRope(int n) {
        if (n==2) return 3;
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        for (int i=4;i<=n;i++){

            for (int j=0;j<=i/2;j++){
                dp[i]=Math.max(dp[j]*dp[i-j],dp[i]);
            }

        }

        return dp[n];

    }

}
