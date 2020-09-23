package Demo1;

import java.util.ArrayList;
import java.util.Random;

public class Member extends User{

    public Member() {


    }

    public Member(String name, int money) {
        super(name, money);
        //show();
    }

    public void receive(ArrayList<Integer> list){

        int index=new Random().nextInt(list.size());

        Integer money = list.remove(index);

        int last=money+super.getMoney();

        super.setMoney(last);
    }
}
