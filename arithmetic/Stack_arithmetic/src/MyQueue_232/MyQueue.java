package MyQueue_232;


import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
使用栈实现队列的下列操作：

        push(x) -- 将一个元素放入队列的尾部。
        pop() -- 从队列首部移除元素。
        peek() -- 返回队列首部的元素。
        empty() -- 返回队列是否为空。
*/
public class MyQueue {


    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.peek();
        System.out.println(queue.peek()); // 返回 1
        System.out.println(queue.pop());  // 返回 1
        System.out.println(queue.empty()); // 返回 false


    }

    Deque<Integer> stack;
    Deque<Integer> stack1;
    int front;

    public MyQueue() {
        stack=new LinkedList<>();
        stack1 =new LinkedList<>();
       //front=0;
    }

    public  void  push(int x){

       // if(stack.isEmpty()) front=x;
        stack.push(x);


    }

    public int pop(){
        if (stack1.isEmpty()){
            while (!stack.isEmpty()){
                stack1.push(stack.pop());
            }
        }
        return stack1.pop();
    }

    public int peek(){
        //if (!stack1.isEmpty()) return stack1.peek();

        if (stack1.isEmpty()){
            while (!stack.isEmpty()){
                stack1.push(stack.pop());
            }
        }
        return stack1.peek();
    }
    public boolean empty(){
        return stack.isEmpty()&&stack1.isEmpty();
    }

}
