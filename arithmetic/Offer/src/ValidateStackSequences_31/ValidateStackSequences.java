package ValidateStackSequences_31;

import java.util.Stack;

public class ValidateStackSequences {


    public static void main(String[] args) {
        int[] pushed={1,2,3,4,5},popped={4,5,3,2,1};
        boolean result=new ValidateStackSequences().validateStackSequences(pushed,popped);
        System.out.println(result);
    }


    public boolean validateStackSequences(int[] pushed, int[] popped) {

        int popIndex=0;
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < pushed.length; i++) {
            stack.add(pushed[i]);
            while (!stack.isEmpty()&&stack.peek()==popped[popIndex]){
                stack.pop();
                popIndex++;
            }

        }

        return popIndex==popped.length;
    }
}
