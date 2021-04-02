package Clumsy_1006;

import java.util.Deque;
import java.util.LinkedList;

public class Clumsy {

    public static void main(String[] args) {
        int i=1;
        int result=new Clumsy().clumsy(i);
    }

    public int clumsy(int N) {

        int ans=0;
        int count=N/4;
        int more=N%4;
        if (count==0){
            switch (more){
                case 3:
                    ans=(N*(N-1)/(N-2));
                    return ans;
                case 2:
                    ans=(N*(N-1));
                    return ans;
                case 1:
                    ans=N;
                    return ans;
            }
        }
        for (int i = 0; i < count; i++) {
            if (i==0){
                ans=N*(N-1)/(N-2)+N-3;
            }else {
                ans-=(N*(N-1)/(N-2)-N+3);
            }
            N-=4;
        }
        if (more!=0){
            switch (more){
                case 3:
                    ans-=(N*(N-1)/(N-2));
                    break;
                case 2:
                    ans-=(N*(N-1));
                    break;
                case 1:
                    ans-=N;
                    break;
            }

        }

        return ans;
    }

    public int clumsy2(int N) {
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(N);
        N--;

        int index = 0; // 用于控制乘、除、加、减
        while (N > 0) {
            if (index % 4 == 0) {
                stack.push(stack.pop() * N);
            } else if (index % 4 == 1) {
                stack.push(stack.pop() / N);
            } else if (index % 4 == 2) {
                stack.push(N);
            } else {
                stack.push(-N);
            }
            index++;
            N--;
        }

        // 把栈中所有的数字依次弹出求和
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }


}
