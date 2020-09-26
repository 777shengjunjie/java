package BalancedStringSplit_1221;



/*
在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。

        给出一个平衡字符串s，请你将它分割成尽可能多的平衡字符串。

        返回可以通过分割得到的平衡字符串的最大数量。
*/

public class BalancedStringSplit {

    public static void main(String[] args) {


        String s="RRRLLRLL";
        int result =new BalancedStringSplit().balancedStringSplit(s);
        System.out.println(result);

    }

    public int balancedStringSplit(String s) {

        int ans=0;
        int strLength = 0;
        int L = 0, R = 0;
        if (strLength < s.length()) {
            for (char c : s.toCharArray()) {
                if (c=='L'){
                    L++;
                }else if (c=='R'){
                    R++;
                }
                if (L==R){
                  ans++;
                  L=R=0;
                }
                strLength++;

            }
        }

        return ans;
    }

    public int balancedStringSplit2(String s) {

        int num = 0;
        int res = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'L')
                num++;
            else
                num--;
            if(num == 0)
                res++;
        }
        return res;





    }

}
