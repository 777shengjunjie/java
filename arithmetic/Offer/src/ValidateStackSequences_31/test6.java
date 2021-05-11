package ValidateStackSequences_31;

import java.util.Scanner;

public class test6 {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=1;
        int a=1;
        int temp;
        if(n<3){
            System.out.println(1);
        }

        if(n<10){

            for(int i=3;i<=n;i++){
                temp=dp[i-1];
                dp[i]=a+dp[i-1];
                a=temp;
            }
            System.out.println(dp[n]);
        }else{
            for(int i=3;i<=n;i++){
                if(i>=10){
                    dp[i]=a+dp[i-1]-dp[i-8];
                    a=dp[i-1]-dp[i-8];
                }else{

                    temp=dp[i-1];
                    dp[i]=a+dp[i-1];
                    a=temp;
                }

            }
            System.out.println(dp[n]);

        }


    }
}
