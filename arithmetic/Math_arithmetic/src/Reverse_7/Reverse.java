package Reverse_7;

public class Reverse {

        public static void main(String[] args) {
            int x=123;
            int result=new Reverse_7.Reverse().reverse(x);
            System.out.println(result);
        }

        public int reverse(int x) {

            int ans=0;
            while(x!=0){
                int last=x%10;
                x=x/10;
                ans=ans*10+last;
            }


        if(ans>(1<<31-1)||ans<-(1<<31)){
            return 0;
        }
            return ans;


        }
    }


