package RestoreString_1528;



/*
难度简单16给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
        请你重新排列字符串 s ，其中第 i 个字符需要
        移动到 indices[i] 指示的位置。返回重新排列后的字符串。
*/
public class RestoreString {

    public static void main(String[] args) {

        String s="codeleet";
        int[] indices={4,5,6,7,0,2,1,3};
        String result=new RestoreString().restoreString(s,indices);
        System.out.println(result);

    }

    public String restoreString(String s,int[] indices){

        char[] ans=new char[s.length()];
        for (int i = 0; i < ans.length; i++) {
            ans[indices[i]] =s.charAt(i);
        }
        return String.valueOf(ans);

    }

}
