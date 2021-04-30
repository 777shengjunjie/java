package MaxQueue_59;

import java.util.ArrayList;
import java.util.List;

public class MaxQueue {

    public static void main(String[] args) {
        MaxQueue max = new MaxQueue();
        max.push_back(46);
        System.out.println(max.max_value());
        System.out.println(max.pop_front());
        System.out.println(max.max_value());
    }

    List<Integer> list;


    public MaxQueue() {
        list=new ArrayList<>();
    }

    public int max_value() {

        int max=-1;

        for(int i=0;i<list.size();i++){
            if(list.get(i)>max){
                max=list.get(i);
            }
        }
        return max;
    }

    public void push_back(int value) {

        list.add(value);
    }

    public int pop_front() {
        if(list.isEmpty()){
            return -1;
        }else{
            return list.remove(0);
        }

    }
}
