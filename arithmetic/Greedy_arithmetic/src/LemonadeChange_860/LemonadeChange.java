package LemonadeChange_860;




/*
在柠檬水摊上，每一杯柠檬水的售价为5美元。

        顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。

        每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。
        你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。

        注意，一开始你手头没有任何零钱。
*/


import java.util.HashMap;

public class LemonadeChange {

    public static void main(String[] args) {

        int[] bills={5,5,5,10,5,5,10,20,20,20};
        boolean result =new LemonadeChange().lemonadeChange(bills);
        System.out.println(result);
    }

    public boolean lemonadeChange(int[] bills){

        int fCount=0,tCount=0,twCount=0;

        HashMap<Integer,Integer> map=new HashMap<>(){
            {
                put(5,0);
                put(10,0);
                put(20,0);
            }
        };

        for (int bill : bills) {
            if (bill==5) map.put(bill,++fCount);
            else if (bill==10) {
                map.put(bill,++tCount);
                map.put(5,--fCount);
                if (fCount<0) return false;
            }else if (bill==20&&tCount!=0){
                map.put(bill,++twCount);
                map.put(10,--tCount);
                map.put(5,--fCount);
                if (tCount<0||fCount<0) return false;
            }else if (bill==20&&tCount==0){
                map.put(bill,++twCount);
                fCount-=3;
                map.put(5,fCount);
                if (fCount<0) return false;
            }
        }

        return true;


    }


    public boolean lemonadeChange2(int[] bills) {


        int five = 0, ten = 0;
        for (int bill: bills) {
            if (bill == 5)
                five++;
            else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;


    }

}
