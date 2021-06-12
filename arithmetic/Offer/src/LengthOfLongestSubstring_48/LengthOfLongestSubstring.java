package LengthOfLongestSubstring_48;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s=" ";
        int result=new LengthOfLongestSubstring().lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    public int lengthOfLongestSubstring(String s) {

        int count=0;
        int res=0;
        List<Character> list=new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
            count++;
            for (int j = i+1; j < s.length(); j++) {
                if (!list.contains(s.charAt(j))){
                    list.add(s.charAt(j));
                    count++;
                }else {
                    res=Math.max(count,res);
                    count=0;
                    list.clear();
                    break;
                }
                if (j==s.length()-1){
                    res=Math.max(count,res);
                    count=0;
                    list.clear();
                }
            }
        }
        res=Math.max(count,res);
        return res;

    }



    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for(int j = 0; j < s.length(); j++) {
            int i = j - 1;
            while(i >= 0 && s.charAt(i) != s.charAt(j)) i--; // 线性查找 i
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }


}
