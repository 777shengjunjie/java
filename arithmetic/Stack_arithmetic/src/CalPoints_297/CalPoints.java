package CalPoints_297;




/*
你现在是棒球比赛记录员。
        给定一个字符串列表，每个字符串可以是以下四种类型之一：
        1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
        2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效回合得分的总和。
        3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效回合得分的两倍。
        4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效回合的分数是无效的，应该被移除。

*/

import java.util.Stack;

public class CalPoints {

    public static void main(String[] args) {

        String[] ops={"5","2","C","D","+"};
        int result=new CalPoints().calPoints(ops);
        System.out.println(result);



    }

    public int calPoints(String[] ops){

        Stack<Integer> stack=new Stack<>();
        int ans=0;

        for (String op : ops) {

            if (op.equals("+")) {
                int temp=stack.pop();
                int result=temp+stack.peek();
                stack.push(temp);
                stack.push(result);
            }
            else if (op.equals("D")) {
                stack.push(2*stack.peek());
            }else if (op.equals("C")){

                stack.pop();
            }else {
                //System.out.println(op);
                stack.push(Integer.valueOf(op));
            }

        }
        for (Integer integer : stack) {
            ans+=integer;
        }
        return ans;
    }
}
