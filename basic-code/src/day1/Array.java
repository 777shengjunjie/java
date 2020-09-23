package day1;

import java.util.ArrayList;

public class Array {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Array() {

    }

    public static void main(String[] args) {
        ArrayList<String>  al=new ArrayList<>();

        System.out.println( al);//[]
        al.add("1");
        al.get(0);
        System.out.println(al.get(0));



    }

}
