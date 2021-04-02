package RomanToInt_13;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public static void main(String[] args) {
        String s="MCMXCIV";
        int result=new RomanToInt().romanToInt(s);
        System.out.println(result);
    }

    
    public int romanToInt(String s) {
        int ans=0;
        Map<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        for(int i=0;i<s.length();i++){
            int pre=0;
            if(i>0){
                pre=map.get(s.charAt(i-1));
            }
            int cur=map.get(s.charAt(i));
            ans+=cur;
            if(i>0&&(cur==5||cur==10)&&pre==1){
                ans-=2*pre;
            }
            if(i>0&&(cur==50||cur==100)&&pre==10){
                ans-=2*pre;
            }
            if(i>0&&(cur==500||cur==1000)&&pre==100){
                ans-=2*pre;
            }
        }

        return ans;
    }

}
