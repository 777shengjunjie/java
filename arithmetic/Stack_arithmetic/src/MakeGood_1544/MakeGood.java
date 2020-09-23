package MakeGood_1544;





import java.util.Stack;
/*
给你一个由大小写英文字母组成的字符串 s 。

        一个整理好的字符串中，两个相邻字符 s[i] 和 s[i + 1] 不会同时满足下述条件：

        0 <= i <= s.length - 2
        s[i] 是小写字符，但 s[i + 1] 是相同的大写字符；反之亦然 。
        请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。

        请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
*/
public class MakeGood {

    public static void main(String[] args) {

        String s="leEeetcode";
        String result=new MakeGood().makeGood(s);
        System.out.println(result);


    }

    public String makeGood(String s){

       // System.out.println(Character.toLowerCase('A'));


        StringBuilder sb=new StringBuilder();
        Stack<Character> stack=new Stack<>();

        char pre=' ';
        for (char c : s.toCharArray()) {
            if (c>='A'&&c<='Z'&&c+32==pre){
                stack.pop();
                if (stack.isEmpty()){
                    pre=' ';
                }else {
                    pre=stack.peek();
                }


                continue;
            }else if (c>='a'&&c<='z'&&c-32==pre){
                stack.pop();
                if (stack.isEmpty()){
                    pre=' ';
                }else {
                    pre=stack.peek();
                }
                continue;
            }
            stack.push(c);
            pre=c;

        }

        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }


        return sb.reverse().toString();
    }


    public String makeGood2(String s) {
        StringBuffer ret = new StringBuffer();
        int retIndex = -1;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ret.length() > 0 && Character.toLowerCase(ret.charAt(retIndex)) == Character.toLowerCase(ch) && ret.charAt(retIndex) != ch) {
                ret.deleteCharAt(retIndex);
                retIndex--;
            } else {
                ret.append(ch);
                retIndex++;
            }
        }
        return ret.toString();
    }


}
