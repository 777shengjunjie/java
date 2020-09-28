package NumWaterBottles_1518;






/*

小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。

        如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。

        请你计算 最多 能喝到多少瓶酒。

*/
public class NumWaterBottles {

    public static void main(String[] args) {

        int numBottles=2;
        int numExchange=3;

        int result=new NumWaterBottles().numWaterBottles(numBottles,numExchange);
        System.out.println(result);


    }

    public int numWaterBottles(int numBottles,int numExchange){

        int sum=numBottles;
        int tempNumBottles=numBottles;
        int tempNumExchange=numBottles;
        do{
            tempNumBottles=tempNumExchange/numExchange;
            tempNumExchange=(tempNumExchange%numExchange+tempNumBottles);

            sum+=tempNumBottles;


        }while (tempNumExchange>=numExchange);

        return sum;





    }
    public int numWaterBottles2(int numBottles, int numExchange) {
        int bottle = numBottles, ans = numBottles;
        while (bottle >= numExchange) {
            bottle -= numExchange;
            ++ans;
            ++bottle;
        }
        return ans;
    }



}
