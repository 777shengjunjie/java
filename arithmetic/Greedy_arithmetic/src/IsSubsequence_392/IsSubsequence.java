package IsSubsequence_392;



/*

给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

        你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），
        而 s 是个短字符串（长度 <=100）。字符串的一个子序列是原始字符串删除一些（也可以不删除）
        字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
*/



public class IsSubsequence {

    public static void main(String[] args) {

        String s="acb";
        String t="ahbgdc";
        boolean result=new IsSubsequence().isSubsequence(s,t);
        System.out.println(result);


    }

    public boolean isSubsequence(String s,String t){


        int sLength=s.length();
        //if (sLength==0) return true;
        int i=0;
        for (int j = 0; j < t.toCharArray().length; j++) {
            if (s.charAt(i)==t.charAt(j)){
                i++;
                if (i==sLength)return true;
            }

        }

        return false;

    }

    public boolean isSubsequence2(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    //动态规划
    public boolean isSubsequence3(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i + 1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }


}
