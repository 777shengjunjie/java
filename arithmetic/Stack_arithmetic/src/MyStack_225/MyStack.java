package MyStack_225;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
push(x) -- 元素 x 入栈
pop() -- 移除栈顶元素
top() -- 获取栈顶元素
empty() -- 返回栈是否为空
*/

public class MyStack {
    private  Queue<Integer> q1=new LinkedList<>();



    public static void main(String[] args) {
        MyStack stack=new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        int result=stack.pop();
        System.out.println(result);
        System.out.println( stack.pop());
        System.out.println(stack.pop());

    }
    public MyStack() {


    }

    public void push(int x) {
        q1.add(x);
        for (int i= q1.size()-1;i>0;i--){

           q1.add(q1.poll());
        }


    }

    public int pop() {



        return q1.poll();
    }

    public int top() {


        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
