package Add_65;

public class Add {

    public static void main(String[] args) {
        int a=1,b=1;
        int result=new Add().add(a,b);
        System.out.println(result);
    }

    public int add(int a, int b) {

        while (b!=0){
             int c=(a&b)<<1;
              a=a^b;
              b=c;
        }
        return a;
    }
}
