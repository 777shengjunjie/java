package RemoveOuterParentheses_1021;




/*

有效括号字符串为空("")、"(" + A + ")"或A + B，其中A 和B都是有效的括号字符串，+代表字符串的连接。例如，""，"()"，"(())()"
        和"(()(()))"都是有效的括号字符串。

        如果有效字符串S非空，且不存在将其拆分为S = A+B的方法，我们称其为原语（primitive），其中A 和B都是非空有效括号字符串。

        给出一个非空有效字符串S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中P_i是有效括号字符串原语。

        对S进行原语化分解，删除分解中每个原语字符串的最外层括号，返回S。


*/


import java.util.Stack;

/*

碰到 "(" 就入栈，碰到 ")" 就把栈顶的一个 "(" 消掉。就像消消乐一样。
如果栈为空，那么刚刚碰到的 “)” 就是最外层右括号；如果入栈前栈为空，则即将入栈的 “(” 就是最外层左括号。
(这其实也是一种单调栈，它的单调性在于：栈里面只存在左括号，右括号仅仅是用来消灭左括号的)

*/


public class RemoveOuterParentheses {

    public static void main(String[] args) {

        String nums="(()())(())(()(()))";
        String result=new RemoveOuterParentheses().removeOuterParentheses(nums);
        System.out.println(result);


    }

    public String removeOuterParentheses(String S){

      /*
      方法一：
       StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {
            if (c == ')') --level;
            if (level >= 1) sb.append(c);
            if (c == '(') ++level;
        }
        return sb.toString();
      }
      */


        StringBuilder sb=new StringBuilder();
        Stack<Character> stack=new Stack<>();


        for (char c : S.toCharArray()) {

            if (c=='(') {

                if (!stack.isEmpty())  sb.append(c);
                stack.push(c);

            }

            if (c==')') {

                stack.pop();
                if (!stack.isEmpty())  sb.append(c);

            }

        }

        return sb.toString();


    }

}
