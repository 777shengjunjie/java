package Demo1;

import java.util.ArrayList;

public class Manager extends User {

    public Manager() {
    }

    public Manager(String name, int money) {
        super(name, money);
    }

    public ArrayList<Integer> send(int totalMoney,int count){

        ArrayList<Integer> redPackage=new ArrayList<>();

        int leftMoney=super.getMoney();

        if (totalMoney>leftMoney){
            System.out.println("余额不足");
            return redPackage;
        }

        super.setMoney(leftMoney-totalMoney);

        int avg=totalMoney/count;
        int mod=totalMoney%count;

        for (int i = 0; i < count-1; i++) {
                    redPackage.add(avg);
        }

        int last=avg+mod;
        redPackage.add(last);

        return redPackage;


    }

}
