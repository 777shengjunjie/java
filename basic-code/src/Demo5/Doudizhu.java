package Demo5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Doudizhu {

    public static void main(String[] args) {

        ArrayList<String> poker=new ArrayList<>();
        String[] numbers={"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
        String[] Colors={"♠","♣","♦","♥"};
        poker.add("大王");
        poker.add("小王");
        for (String number : numbers) {
            for (String color : Colors) {
                poker.add(color+number);
            }
        }

        Collections.shuffle(poker);
        //System.out.println(poker);


        ArrayList<String> player1=new ArrayList<>();
        ArrayList<String> player2=new ArrayList<>();
        ArrayList<String> player3=new ArrayList<>();
        ArrayList<String> diPan=new ArrayList<>();

        for (int i = 0; i < poker.size(); i++) {
            String p=poker.get(i);
            if (i>=51){
                diPan.add(p);
            }else if(i%3==0){
                player1.add(p);

            }else if (i%3==1){
                player2.add(p);
            }else if (i%3==2){
                player3.add(p);
            }
        }

        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);
        System.out.println(diPan);




    }

}
