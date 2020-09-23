package IsValid_20;



/*
给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串，判断字符串是否有效。

        有效字符串需满足：

        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        注意空字符串可被认为是有效字符串。
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CalIsValid {


    public static void main(String[] args) {

    }


    public boolean isValid(String s){

        if (s.length()%2==1) return false;
        Stack<Character> stack=new Stack<>();

        Map<Character,Character> map= new HashMap<>(){
            //也就是说第一层括弧实际是定义了一个匿名内部类 (Anonymous Inner Class)，第二层括弧实际上是
            // 一个实例初始化块 (instance initializer block)，这个块在内部匿名类构造时被执行。这个块之所
            // 以被叫做“实例初始化块”是因为它们被定义在了一个类的实例范围内。
            {
                put('(',')');
                put('[',']');
                put('{','}');
            }
        };

        for (char c : s.toCharArray()) {

            if (c=='(') stack.push(map.get(c));
            else if (c=='[') stack.push(map.get(c));
            else if (c=='{') stack.push(map.get(c));
            else if (stack.isEmpty()||c!=stack.pop()) return false;
        }

        return stack.isEmpty();

    }
}
