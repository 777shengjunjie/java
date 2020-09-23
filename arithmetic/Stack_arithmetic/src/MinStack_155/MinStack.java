package MinStack_155;


import java.util.LinkedList;
import java.util.Queue;

/*
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

        push(x) —— 将元素 x 推入栈中。
        pop()—— 删除栈顶的元素。
        top()—— 获取栈顶元素。
        getMin() —— 检索栈中的最小元素。
*/


/*
也可以直接使用Deque，push()和pop()的方法
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack=new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    private Queue<Integer> stack=new LinkedList<>();

    public MinStack() {
    }

    public  void  push(int x){
        stack.add(x);
        for (int i = 0; i < stack.size()-1; i++) {
            stack.add(stack.poll());
        }
    }

    public void pop(){
        stack.poll();
    }

    public int top(){
        return stack.peek();
    }

    public  int getMin(){
        int min=Integer.MAX_VALUE;
        for (Integer integer : stack) {
            min=Math.min(min,integer);
        }
        return min;
    }




}
