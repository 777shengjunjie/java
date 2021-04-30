package NumWays_10;

public class NumWays {

    int count=0;

    public static void main(String[] args) {
        int n=43;
        int result=new NumWays().numWays(n);
        System.out.println(result);
    }


    public int numWays(int n) {
        int a = 1, b = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }

        return a;
    }

    public int numWays2(int n) {

        up(n);
        return count%1000000007;
    }

    public void up(int n){
        if (n<0){
            return;
        }
        if (n==0){
            count++;
            return;
        }

        n-=1;
        up(n);
        n-=1;
        up(n);

    }
}
