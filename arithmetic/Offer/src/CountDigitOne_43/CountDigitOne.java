package CountDigitOne_43;

public class CountDigitOne {


    public static void main(String[] args) {

    }


    public int countDigitOne(int n) {

        int res=0,digit=1;
        int high=n/10,cur=n%10,low=0;
        while(high!=0||cur!=0){
            if (cur==0) res+=digit*high;
            else if (cur==1) res+=digit*high+low+1;
            else res+=(high+1)*digit;

            low+=cur*digit;
            cur=high%10;
            high/=10;
            digit*=10;
        }

        return res;
    }

    public int countDigitOne2(int n) {
        int res=0;
        for (int i = 1; i <= n; i++) {
            res+=getOneCounts(i);
        }

        return res;
    }

    public int getOneCounts(int number){
        int count=0;
        while (number!=0){
            if (number%10==1){
                count++;
            }
            number=number/10;
        }

        return count;
    }
}
