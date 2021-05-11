package DicesProbability_60;

public class DicesProbability {


    public double[] dicesProbability(int n) {
        double[] dp = {1.0 / 6.0, 1.0 / 6.0, 1.0 / 6.0, 1.0 / 6.0, 1.0 / 6.0, 1.0 / 6.0};
        if (n == 1) {
            return dp;
        }

        for (int i = 2; i <= n; i++) {
            double[] temp = new double[i * 5 + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k=0;k<6;k++){
                    temp[j+k]+=dp[j]/6;
                }
            }
            dp=temp;
        }
        return dp;
    }


}
