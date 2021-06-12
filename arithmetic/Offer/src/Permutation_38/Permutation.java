package Permutation_38;

import org.omg.CORBA.INTERNAL;

import java.util.*;

public class Permutation {



    public static void main(String[] args) {

    }


    List<String> res=new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(int x) {
        if (x==c.length-1) {
            res.add(String.valueOf(c));
            return;
        }
        Set<Character> set=new HashSet<>();
        for (int i=x;i< c.length;i++){
            if (set.contains(c[i])) continue;
            set.add(c[i]);
            swap(x,i);
            dfs(x+1);
            swap(i,x);
        }

    }

    private void swap(int x, int i) {
        char temp=c[x];
        c[x]=c[i];
        c[i]=temp;

    }

}
