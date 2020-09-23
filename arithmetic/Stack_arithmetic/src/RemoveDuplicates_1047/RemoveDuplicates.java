package RemoveDuplicates_1047;


import java.util.Stack;

/*
给出由小写字母组成的字符串S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。

        在 S 上反复执行重复项删除操作，直到无法继续删除。

        在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
*/
public class RemoveDuplicates {


    public static void main(String[] args) {

        String S="abbaca";
        String result=new RemoveDuplicates().removeDuplicates2(S);
        System.out.println(result);

    }


    public String removeDuplicates(String S){

        StringBuilder sb=new StringBuilder();
        Stack<Character> stack=new Stack<>();
        for (char c : S.toCharArray()) {
            if (!stack.isEmpty()&&stack.peek()==c){
                stack.pop();
            }else {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()){

            sb.append(stack.pop());
        }
        sb.reverse();
       return sb.toString();

    }
    public String removeDuplicates2(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char character : S.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1))
                sb.deleteCharAt(sbLength-- - 1);
            else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }




}
