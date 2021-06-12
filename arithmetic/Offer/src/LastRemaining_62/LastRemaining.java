package LastRemaining_62;

import java.util.ArrayList;
import java.util.List;

public class LastRemaining {


    public static void main(String[] args) {

    }

    public int lastRemaining(int n, int m) {
        int x=0;
        for (int i = 2; i <= n; i++) {
            x=(x+m)%i;
        }
        return x;
    }

    public int lastRemaining2(int n, int m) {
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx=0;
        while (n>1){
            idx=(idx+m-1)%n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

}
