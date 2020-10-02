package IsAnagram_242;


import java.util.Arrays;

/*
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
*/
public class IsAnagram {

    public static void main(String[] args) {

      /*  String s="anagram";
        String t="nagaram";*/
        String s="";
        String t="";
        boolean result=new IsAnagram().isAnagram(s,t);
        System.out.println(result);

    }


    public boolean isAnagram(String s,String t){

        if (s.length()!=t.length()) return false;

            char[] charS=s.toCharArray();
            char[] charT=t.toCharArray();
            Arrays.sort(charS);
            Arrays.sort(charT);
            //if(charS.equals(charT)) return true;
            // 这里使用的还是object的equal，相当于==比较的是地址
            return Arrays.equals(charS, charT);


    }

}
