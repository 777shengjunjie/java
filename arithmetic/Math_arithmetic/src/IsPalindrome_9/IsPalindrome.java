package IsPalindrome_9;

public class IsPalindrome {

    public static void main(String[] args) {

    }

    public boolean isPalindrome(int x) {
        int mdNum=0;
        int pre=x;
        if(x<0) return false;
        while(x!=0){
            int last=x%10;
            mdNum=mdNum*10+last;
            x=x/10;
        }

        return pre==mdNum;
    }
}
