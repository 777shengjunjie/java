package Demo1;

import java.util.ArrayList;

public class LuckyMoney {

    public static void main(String[] args) {



            Manager manager=new Manager("老板",100);
            Member member1=new Member("A",0);
            Member member2=new Member("B",0);
            Member member3=new Member("C",0);

            manager.show();
            member1.show();
            member2.show();
            member3.show();

        System.out.println("=================");


        ArrayList<Integer> redMoney = manager.send(20, 3);
        member1.receive(redMoney);
        member2.receive(redMoney);
        member3.receive(redMoney);

        manager.show();
        member1.show();
        member2.show();
        member3.show();

    }
}
