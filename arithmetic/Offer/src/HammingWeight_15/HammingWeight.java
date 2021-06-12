package HammingWeight_15;

public class HammingWeight {

    public static void main(String[] args) {

    }

    public int hammingWeight(int n) {
        int count=0;
        while (n!=0){
            int temp=n&1;
            if (temp==1) count++;
            n=n>>1;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int res = 0;
        while(n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }


}
