package BackspaceCompare_844;




/*

给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
        注意：如果对空文本输入退格字符，文本继续为空。
*/

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Stack;

public class BackspaceCompare {

    public static void main(String[] args) {


        String S="a##cb";
        String T="#a#c";
        boolean result=new BackspaceCompare().backspaceCompare2(S,T);
        System.out.println(result);


    }


    public boolean backspaceCompare(String S,String T){

        Stack<Character> stackS=new Stack<>();
        Stack<Character> stackT=new Stack<>();
        for (char c : S.toCharArray()) {
            if (c=='#'&&!stackS.isEmpty()) stackS.pop();
            else if(c!='#') stackS.push(c);
        }
        for (char c : T.toCharArray()) {
            if (c=='#'&&!stackT.isEmpty()) stackT.pop();
            else if(c!='#') stackT.push(c);
        }

        if (stackS.size()!=stackT.size()) return false;
        while (!stackS.isEmpty()){
            if (stackS.pop()==stackT.pop()) continue;
            return false;
        }

        return true;
    }
    public boolean backspaceCompare2(String S,String T)
    {
        return build(S).equals(build(T));

    }

    private String build(String s) {

        Stack<Character> ans = new Stack();
        for (char c: s.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }

        //String s1 = String.valueOf(ans);


        return String.valueOf(ans);
    }
}
