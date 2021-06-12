package MinStack_30;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Stack;

public class MinStack {

    Stack<Integer> A, B;

    public static void main(String[] args) {


    }

    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.add(x);
        if(B.empty() || B.peek() >= x)
            B.add(x);
    }

    public void pop() {
        if (A.pop().equals(B.peek())){
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }

}
