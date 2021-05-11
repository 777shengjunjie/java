package PrintNumbers_17;

public class PrintNumbers {

    public static void main(String[] args) {
        int n=2;
        int[] res=new PrintNumbers().printNumbers2(n);
        for (int re : res) {
            System.out.println(re);
        }
    }

    public int[] printNumbers(int n) {

        int[] res=new int[ (int)Math.pow(10,n)-1];
        for (int i=1;i<(Math.pow(10,n));i++){
           res[i-1]=i;
        }
        return res;
    }


    int[] res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public int[] printNumbers2(int n) {
        this.n = n;
        res = new int[(int)Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res;
    }
    void dfs(int x) {
        if(x == n) {
            String s = String.valueOf(num).substring(start);
            if(!s.equals("0")) res[count++] = Integer.parseInt(s);
            if(n - start == nine) start--;
            return;
        }
        for(char i : loop) {
            if(i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }



}
